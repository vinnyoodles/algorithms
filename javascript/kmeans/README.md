## Kth Means
#### Problem
Kth means is a machine learning algorithms, more specifically it is a clustering algorithm. Clustering algorithms group together similar nodes to form a single cluster. Similar to knn, *k* represents the number of clusters. A good use case for a clustering algorithm such as kmeans is tagging clothing styles. For example, we can determine if a given shirt is a specific style if it has similar features to a certain cluster.

#### Explanation
kmeans works by first creating *k* clusters and randomly assigning them to a certain location in the grid. Once the clusters are assigned a coordinate, we iterate through each node and assign that node to the closest cluster. When all nodes have been assigned, the cluster are then moved to the center of all of its assigned nodes. These steps will keep looping until no more clusters are moving. This will happen when all the clusters are in the correct center location.

In order to use kmeans you either need to know how many clusters you're looking for in the dataset or you have to use a second algorithm to also guess the number of clusters. kmeans just organizes your points into clusters; you need to do something else to figure out the right number of clusters.
