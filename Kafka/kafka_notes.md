### Apache Kafka

# Introduction

Basically, Kafka is the answer to problems faced by the distribution and scaling of messaging systems.
Apache Kafka is an open-source distributed streaming platform that allows for the development of real-time event driven applications.
Specifically, it allows developers to make applications that can continuously produce and consume streams of data records.
Kafka is distributed - it runs as a cluster that can span multiple servers or data centers. The Records on Partitions are distributed in such a way that it allows users use the application simultaneously without any noticeable lag - so, it is very fast.
It also maintains a very high accuracy of the data records.
Further, it maintains the order of occurence.
It is also fault tolerant due to the replication and its distributed nature.
So all these qualities leads it to being a very powerful platform.

# Example 1

1. Imagine we design a system that listens to various basketball updates from various systems. Information could include: scoring, participants, and timing information. It then displays the game's status on various channels, such as mobile devices and browsers.
2. In our architecture, we have a process that reads these updates and writes them in a Queue - we call this process, a Producer b/c it's producing these updates onto the Queue.
3. At the head of the queue, a number of downstream processes consume these updates to display them on the various channel - we call these processes, Consumers.
4. Over time, we decide to expand and start following more games. The problem is now our servers are struggling b/c the Queue is hosted on one server, and it is running out of memory and processing/compute power. Naturally, our downstream customers are also suffering.
5. So, now we begin to ask the question - how can we add more compute by distributing our infrastructure. I.e. How can we distribute the Queue?

- We could try to distribute the Queue onto random servers, but our customers may be consuming updates out-of-order.
- One solution is to let the Application specify how to distribute the items/updates in the Queue. In our example, we could distribute the items/updates using the match name. i.e. the items/updates for one match, will be on the same Queue. This strategy would maintain the correct ordering per basketball match.

This strategy is the basic fundamental difference of Kafka with other messaging systems. That is, items sent and received through Kafka requires a distribution strategy.

# Explanation

- In Kafka, each separate and distributed Queue is called a 'Partition'
- The total number of 'Partitions', is called a 'Partition Count'.
- Each server holding one or more of the 'Partition' is called a 'Broker'.
- Each item/update on a 'Partition' is called a 'Record'.
- The field used to decide which 'Partition' the 'Record' should be stored in is called a 'Partition Key'. In our example 'Partition Key' = Match Name. It's up the Application to decide which field to use as the 'Partition Key'. If no 'Key' is specified, Kafka simply assigns the 'Record' to a random 'Partition'.
- A grouping of 'Partitions' handling the same type of data is called a 'Topic'.
- In order to identify each record uniquely, Kafka provides a sequential number to each record, called an 'Offset' (0-indexing, 0 is earliest, first out 'Record').

# Scaling for Distribution

1. In our Application, as we have now distributed our match information across Partitions using the Partition Key, we can now parallelize our Consumer Application. Having one Consumer per Partition guarantees ordering per game. Consumers can live on one machine or be distributed across many. One important concept in Kafka is that Consumers are very lightweight and we can create many of them without affecting performance. This is mainly because Kafka only needs to maintain the latest offset read by each Consumer.
2. Typically, Consumers read one record after the other and resume from where they left after a restart. However, in Kafka it's up to the Consumer implementation to decide how to consume Records.
3. It's quite common for Consumers to read all of the Record on start-up or reading the Record in a different order, such as back-to-front.
4. In Kafka, each Consumer belonging to the same Consumer Group (Consumer Group Id) do not share Partitions. This means that each Consumer would read different Records from the other Consumers.
5. Multiple Consumer Groups are useful When you have different Applications reading the same context. In our example, we could have two groups, Mobile Consumer and Desktop Consumer Groups, these Consumers would read the same Records, but update different Channels.
6. Each Consumer in these Groups will have separate Offset pointers to keep track of which Record was the latest read on the Partition.

# Deleting Records from a Partition

If each Consumer can read Records using a Offset somewhat freely from the custom ordering, how can Kafka determine that a Record has been completely consumed and can be safely deleted (so it can free up space)?
The answer is that Kafka provides various policies that allow it to do a Record Clean-up.
For example:

1. Retention Policy - a Record age limit. E.g. 24 hours, after which the Records are automatically deleted. In Kafka, your messages are never down during this age limit of 24 hours.

# Fault Tolerant & Durable Storage

In Kafka, each Record is stored on persistent storage, so that if a Broker goes down, it can recover when it comes back up. Additionally, Kafka replicates Partitions so that when a Partition goes down a back up Partition takes over and processing can resume. This replication is configured using a Replication Factor. For example, a Replication Factor = 3 means 3 copies - 1 Leader and 2 Back Ups (meaning we can tolerate 2 Partition going down).
