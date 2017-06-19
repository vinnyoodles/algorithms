/**
 * Node class that represents a single entity in the graph.
 * Each node should have some required params such as the
 * factors and the outcome.
 * The actual names of each are abstracted so
 * that the nodes can represent any dataset.
 */
function Node(params) {
  for (var key in params) {
    this[key] = params[key];
  }
}

Node.prototype.determine = function({ factors, axis, neighbors, k, type}) {
  var calculatedNeighbors = [];
  for (var i in neighbors) {
    var sumDelta = 0;
    for (var f in factors) {
      var factor = factors[f];
      var delta = (neighbors[i][factor] - this[factor]) / axis[factor].range
      sumDelta += delta * delta;
    }

    // Use pythagorean theorem to calculate distance between this node and the neighbor.
    calculatedNeighbors.push({
      distance: Math.sqrt(sumDelta),
      type: neighbors[i][type]
    });
  }

  // Sort the neighbors by distance in ascending order, first is closest.
  var sortedNeighbors = calculatedNeighbors.sort((a, b) => a.distance - b.distance);
  // Grab the first k elements.
  var knn = sortedNeighbors.slice(0, k);

  // Iterate through the nearest neighbors and find the best match for the type.
  var types = {};
  for (var i in knn) {
    var type = knn[i].type;
    // If it doesn't exist, then initialize the counter.
    if (!types[type]) types[type] = 0;
    types[type] ++;
  }

  var score = 0;
  var type;
  for (var t in types) {
    if (!type || types[t] > score) {
      type = t;
      score = types[t];
    }
  }

  return type;
};


/**
 * An abstracted structure to handle an entire dataset represented
 * as a list of nodes.
 */
function NodeList(k, dataset) {
  this.nodes = [];
  this.k = k;

  if (dataset) dataset.forEach(this.add.bind(this));
}

/**
 * Add the datum as a node object.
 * @param {Node} node
 */
NodeList.prototype.add = function(node) {
  this.nodes.push(node);
};

/**
 * Normalize the dataset on a scale from -1 to 1.
 * @param  {Array}  factors support multidimensional datasets by accepting
 *                          an array of factors or dimensions.
 * @return {Boolean}
 */
NodeList.prototype.normalizeAxis = function(factors) {
  var extremes = [];
  for (var f in factors) {
    extremes.push({ min: Number.MAX_VALUE, max: 0, label: factors[f] });
  }

  // Iterate through all the nodes and find the extremes for both axis.
  for (var i in this.nodes) {
    for (var e in extremes) {
      var ex = extremes[e];
      if (this.nodes[i][ex.label] < ex.min) ex.min = this.nodes[i][ex.label];
      if (this.nodes[i][ex.label] > ex.max) ex.max = this.nodes[i][ex.label];
    }
  }


  var extremesTable = {};
  for (var x in extremes) {
    extremes[x].range = extremes[x].max - extremes[x].min;
    extremesTable[extremes[x].label] = extremes[x];
  }

  return extremesTable;
};

NodeList.prototype.determine = function(factors, type) {
  var axis = this.normalizeAxis(factors);

  // Iterate through all nodes and find the unknown nodes.
  // Assign the unknown nodes a list of its neighbors that are known.
  var known = [];
  var unknown = [];
  for (var i in this.nodes) {
    // If `type` is truthy for the node, then it is considered a known node.
    var array = this.nodes[i][type] ? known : unknown;
    array.push(this.nodes[i]);
  }
  if (!unknown.length) return [];

  var types = [];
  for (var j in unknown) {
    unknown[j][type] = unknown[j].determine({
      factors,
      axis,
      type,
      neighbors: known,
      k: this.k
    });
    types.push(unknown[j][type]);
  }
  return types;
};

module.exports = {
  Node,
  NodeList
};
