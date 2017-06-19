## Table of Contents
- [Random Weights](#random-weights)

## Random Weights
#### Problem
Write a function that returns values randomly, according to their weight.

#### Input/Output
```
Input: [1, 2, 3], [1, 1, 2]
Output: 1 and 2 should have a 25% chance and 3 should have a 50% chance of appearing.
```

#### Explanation
The problems seems simple at first and there are many solutions for this problem.

I believe the brute force solution would be to have the array of elements but also include additional elements with a higher weight. Using the example, the base array would be `[1, 2, 3]` and because `3` has a weight of 2, it should have 2 elemnts in the array, so `[1, 2, 3, 3]`. Some drawbacks are that if the weight is a very large number, the array would be large as well. Also, this requires the weight to be an integer.

A slightly more optimal solution would be to calculate the range for each element. If 1 and 2 have both 25% chances and 3 has a 50% chance, the range would look something like `0 < 0.25 < 0.5 < 1`. This would run in linear time and if the ranges are stored as an array, then it would require linear memory.

An even more optimal solution would be to calculate the sum weight, *w* and create a random number from 0 - *w*. Then, iterate through the elements and accumulate the sum of the element's weight. Once the current sum is greater than the random number, then return the current number. This also runs in linear time but requires no extra memory.

The next step would be to approach a logarithmic runtime. To solve this in O(logn) time, we will need to use a binary search. In order to do so, preprocessing will be required. Many problems will require these types of tradeoffs. In this case, the preprocessing will be to create an array the current accumulated sum of weights in the same order of the elements. This array will require linear memory.

For most random number generators, a constant time solution is ideal. To do so, the array must have a length equal to the sum of the weights. This way we can just create the random number and use that as an index.

[Implementation](https://github.com/vinnyoodles/algorithms/blob/master/src/math/randomWeight.js)
