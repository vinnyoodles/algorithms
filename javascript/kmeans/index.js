// Build off the Node and NodeList objects from the knn algorithm.
var { Node, NodeList } = require('../knn');

/**
 * Create k clusters and randomly assign them to a point within the axis.
 *
 * @param  {Array} factors
 * @return {Array<Cluster>}
 */
NodeList.prototype.cluster = function(factors) {
  var clusters = [];
  var extremes = this.normalizeAxis(factors);
  var k = this.k;

  while (k--) {
    var cluster = [];

    for (var f in factors) {
      // Randomly place the cluster somewhere within range.
      cluster[factors[f]] = Math.floor(extremes[factors[f]].min + (Math.random() * extremes[factors[f]].range));
    }
    clusters.push(cluster);
  }

  return clusters;
};

/**
 * Calculate the Euclidean distance between each node and cluster.
 * Each node is then assigned to the closest cluster.
 *
 * @param {Array} factors list of factor or dimension names
 */
NodeList.prototype.assign = function(factors, clusters) {
  var clusters = clusters || this.cluster(factors);
  var assignments = new Array(this.nodes.length);
  for (var i in this.nodes) {
    var node = this.nodes[i];
    var distances = [];

    // Find the closest cluster to the current node.
    for (var c in clusters) {
      var cluster = clusters[c];
      var sum = 0;

      // Calculate the distance between the current node and the current cluster.
      for (var n in node) {
        var difference = node[n] - cluster[n];
        difference *= difference;
        sum += difference;
      }

      distances[c] = Math.sqrt(sum);
    }

    // Assign the current node the cluster with the shortest distance.
    assignments[i] = distances.indexOf(Math.min(...distances));
  }

  return assignments;
}

/**
 * Run the kmeans algorithm with the given dataset when initializing the NodeList.
 *
 * @param  {Array} factors
 * @param  {Array<Cluster>} clusters
 */
NodeList.prototype.run = function(factors, clusters) {
  clusters = clusters || this.cluster(factors);

  var assignments = this.assign(factors, clusters);
  var extremes = this.normalizeAxis(factors);

  // Array to be used to calculate the arithmetic mean of each cluster's assignments.
  var sums = new Array(clusters.length);
  // Array to keep track of assignments per cluster.
  var counts = new Array(clusters.length);

  // Initialize a counter array to keep track of assignments.
  for (var c in clusters) {
    counts[c] = 0;
    sums[c] = new Array(clusters[c].length);
    for (var point in clusters[c]) {
      sums[c][point] = 0;
    }
  }

  for (var nodeIndex in assignments) {
    var clusterIndex = assignments[nodeIndex];
    var node = this.nodes[nodeIndex];
    var cluster = clusters[clusterIndex];

    counts[clusterIndex]++;

    for (var factor in cluster) {
      sums[clusterIndex][factor] += node[factor];
    }
  }

  for (var s in sums) {
    // If the cluster didn't receive any assignments, then reassign it with another random point.
    if (counts[s] === 0) {
      for (var e in extremes) {
        sums[s][e] = clusters[s][e] = Math.floor(extremes[e].min + (Math.random() * extremes[e].range));
      }
    } else {
      for (var dimension in sums[s]) {
        sums[s][dimension] = Math.floor(sums[s][dimension] / counts[s]);
      }
    }
  }

  // If the clusters do not equal the sums, then a move has occurred.
  return clusters.toString() !== sums.toString() ? this.run(factors, sums) : clusters;
}

module.exports = {
  Node,
  NodeList
};
