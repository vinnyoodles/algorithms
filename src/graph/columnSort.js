/**
 * Given a binary tree, return an array with the values in the array in column sorted order.
 *
 * @param  {TreeNode} root
 * @return {Array}
 */
function columnSort(root) {
  if (!root || !root.value) return [];
  var { table, min, max } = populateTable(root, {} /* Empty table */, 0 /* Root node */, 0, 0);

  var output = [];
  // Add the columns in order of column index.
  for (var i = min; i <= max; i++) {
    output = output.concat(table[i]);
  }

  return output;
}

/**
 * Recursive function to populate the table with the columns of the tree.
 * Also, check for the smallest and largest column indexes for the tree.
 *
 * @param  {TreeNode} node
 * @param  {Object} table
 * @param  {Int} column
 * @param  {Object} extremes
 * @return {Object}
 */
function populateTable(node, table, column, extremes) { // jshint ignore:line

  // Initialize a table that stores the minimum and maximum column indexes
  extremes = extremes || { min: column, max: column };

  // Add the node to the table.
  if (node.value) {
    // If the column already exists, then concatenate the new value.
    if (table[column]) table[column].push(node.value);
    else table[column] = [node.value];

  } else { // If this node doesn't have any values, then its children shouldn't either.
    return;
  }

  // Add the left subtree.
  if (node.left) populateTable(node.left, table, column - 1, extremes);

  // Add the right subtree
  if (node.right) populateTable(node.right, table, column + 1, extremes);

  // Keep track of the column minimum and maximum.
  extremes.min = Math.min(extremes.min, column);
  extremes.max = Math.max(extremes.max, column);

  return {
    table,
    min: extremes.min,
    max: extremes.max
  };
}

module.exports = columnSort;
