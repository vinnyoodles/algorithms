## Genetic Algorithms

I find genetic algorithms to be super cool and interesting that it is based off natural evolution. The idea is that given a gene, which represents a single object such as a person, has a specific trait or attribute that makes it unique. The algorithm would have a gene with an ideal trait, this will be the target gene which is the end goal of the algorithm. 

It works by grouping together multiple genes to *mate* and produce offspring which have certain traits from its parents but can also contain mutation which is random. The initial genes in the group or pool are completely random and from there only the best fitting genes are allowed to mate. This is to mock the natural selection or survival of the fittest. Over a period of time, the pools become closer and closer to the target gene.

The developer has to define the ideal trait as well as how to calculate the best fitting genes. These functions are called cost functions which calculate the closeness to the trait. There are also fitness functions which are similar to cost functions but it calculates the score so the higher the better.
