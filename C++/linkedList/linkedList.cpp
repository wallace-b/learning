/* C++ linked list using class i.e. an object blueprint
Remember that a linked list is composed of dynamically allocated nodes of 'data' stitched together.
needs to store *data* and a separate 'pointer' to the *next* chunk/node (in this case an object)
*/

#include <iostream>
using namespace std;

// Node of the linked list, as a class - data: int only, next: pointer
class Node
{
public:
    int data;
    int *next;

    // Default initial constructor i.e. tail
    Node()
    {
        data = 0;
        next = NULL;
    }

    // Parameterised initial constructor i.e. tail
    Node(int num)
    {
        data = num;
        next = NULL;
    }

    // Add a new node, referencing previous node
    Node(int num, int *ptr)
    {
        data = num;
        next = ptr;
    }
};

int main()
{
    Node node0(55);
    cout << node0.data << "\n";
    cout << node0.next << "\n";

    Node node1(44, &node0.data);
    cout << node1.data << "\n";
    cout << node1.next << "\n";

    Node node2(33, &node1.data);
    cout << node2.data << "\n";
    cout << node2.next << "\n";

    Node node3(22, &node2.data);
    cout << node3.data << "\n";
    cout << node3.next << "\n";
};