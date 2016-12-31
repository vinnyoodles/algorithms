## Kth Nearest Neighbor
#### Problem
[knn](https://en.wikipedia.org/wiki/K-nearest_neighbors_algorithm) is a machine learning algorithms that can classify an unknown data points based off of prior data. The prior data is also known as *training data* which is used to make generalization that can be used to classify unknown data points.

#### Explanation
knn works by graphing all the data points as nodes and then finding the *kth* nearest neighbors. The outcome would be the majority out of the neighbors. For example, given the following fake dataset:

|Weight (kg)|Height (in)|Shoe size|
|------|------|---------|
|60|60|8|
|62|70|9|
|65|70|9.5|
|80|90|12|
|70|85|10|
|75|75|9.5|
|90|82|12|
|82|70|*x*|

The last data point has an unknown shoe size. *knn* would use the 7 prior nodes that have complete data to predict the 8th node's shoe size. If the dataset was plotted on an *xy* graph with weight and height as the variables, ideally we would see clusters the make up certain shoe sizes. When the unknown node is plotted on the graph, we would find the 3, 4, 5, or *kth* nearest nodes to it and find the majority of those node's shoe sizes which would be the predicted shoe size of the unknown node.

For datasets that only have two factors, such as weight and height in this case, it is easy for humans to visualize the data on a graph. However, *knn* excels when there are multiple factors that exceed our visualization capabilities, imagine a dataset with 20 factors and try to visualize it.

![](https://media.giphy.com/media/EldfH1VJdbrwY/giphy.gif)

Some important parts for calculating the nearest neighbors. When the values are entered, those are the absolute values. As in the value could be any number. If the factors are on different scales, the graph would be really skewed and the neighbors would then be inaccurate. For example, the above dataset but the scales are in *grams* and *miles*.

The solution would be to normalize the dataset by projecting the value between -1 and 1. The normalization formula is:
```
(calculated - predicted) / (max - min)
```
Using the *weight* column in the dataset in *kg*, in order to calculate the distance between the first node and the last node it would look something like:
```
[60, 62, 65, 80, 70, 75, 90, 82]
 ^                        ^
min                      max

(60 - 82) / (90 - 60) = -0.733
```

Once the distance is found for each neighbor, we would get the *k* closest neighbors and get the majority type.
