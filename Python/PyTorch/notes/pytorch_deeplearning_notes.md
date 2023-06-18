# Chapter 0 - PyTorch Fundamentals

## 1. Basic Introduction

Traditional Programming: Input + Programmed Rules => Computed Output
Machine Learning: Input + Output => Computed Rules using Programmed Algorithms

You could use ML for anything as long as you can convert input and output i.e. supervised (or input alone - unsupervised) to numbers and the algorithms can find patterns.

Why use Machine Learning?
What if we can't program the Rules set? or the Rules set is too vast?
Rule#1 of Google's Machine Learning Handbook - "If you can build a simple rule-based system that doesn't require machine learning, do that." ... It might not be very simple

## 2A. What is Deep Learning is good for?

1. Problems with long lists of rules - when the traditional approach fails, machine learning/deep learning may help.
2. Continually changing environments - deep learning can adapt ('learn') to new scenarios. E.g. autonomous driving - you are good driving in your own neighborhood, but not necessarily in unfamiliar places.
3. Discovering insights within large collections of data - can you imagine trying to handcraft rules for an image dataset of 100+ labels? E.g. As per Plato vs Diogenes, a featherless biped is a human, which Diogenes disproves by presenting a featherless chicken to the Athenian Forum and proclaiming "behold, a man".

## 2B. What is Deep Learning (typically) not good for?

1. When you need explainability - the patterns learned by a deep learning model are typically uninterpretable by a human. They are not a descriptive / explanatory ML model architecture unlike some of the more traditional ML model architectures whose parameters can be interpreted. The number of weight and bias parameters in a deep learning model can number in the millions to trillions of parameters.
2. When the traditional approach is the better option - if you can accomplish what you need with a simple rule-based system (#1 Google ML Handbook)
3. When errors are unacceptable - since the outputs of deep learning model aren't always predictable. (There is an error % typically. Perhaps this is a drawback at the moment in terms of automonous vehicles, their accident rate i.e. error rate is not on order of magnitude less than human error rate.)
4. When you don't have much data - deep learning models usually require a fairly large amount of data to produce great results.
   There are techniques to augment (and increase the amount of your data) e.g. image data -> skew / rotate / color change / flip / squash and so on.

## 3. Machine Learning vs Deep Learning

With structured data i.e. in rows and columns -> usually dml XGBoost (Gradient Boosting Model) performs very well and appears in production a lot.
Random forest, GBM, Naive Bayes, Nearest Neighbor, SVM, and many more (one pass or 'shallow' algorithms)

With unstructured data -> a Deep Learning algorithm will likely work best. Unstructured data could be images, text (Natural Language), voice recording
Neural networks (NN), Fully-connected NN, CNN, RNN, Transformer.

But data science has artistry too, so the models can be used in both situations.

## 4. Anatomy of a Neural Network

Inputs -> Numerical encoding -> Learn representation (patterns/embedding/features/weights/feature representation/feature vectors) -> Representation outputs (features, weight matrix, learned representations and so on) -> Outputs (human interpretable)

1. Unstructured data can be numerically-encoded so it can passed as an input/out into a neural network model.
2. The neural network learns patterns in the data (e.g. recognizing food, NLP - words following other words, bag of words = %disaster, %spam)
3. The outputs are represented in terms of the learned reprsentation or prediction probilities.
4. The outputs can be converted into a human interpretable result.

## 5. Learning Paradigms

1. Supervised
2. Unsupervised, self-supervised
3. Reinforcement learning (agents with fitness and typically generational improvement)
4. Transfer learning (transfer the learned patterns from one model to another model to give the new model a head-start)

## 6. Deep Learning use cases

Recommendation algorithms, translation, speech recognition, object detection/computer vision, natural language procesing (spam email could be Naive Bayes, Chatgpt uses a Transformer).

translation, speech recognition - sequence to sequence
computer vision, NLP - multiclass, classification/regression
