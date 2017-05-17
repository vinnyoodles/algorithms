module.exports = function(pid, ppid, kill) {
  var table = {};

  // Populate the hash table.
  for (var i = 0; i < ppid.length; i ++) {
    if (ppid[i] === 0) continue;
    var list = table[ppid[i]];
    if (!list) list = [];
    list.push(pid[i]);
    table[ppid[i]] = list;
  }

  var results = [];
  var queue = [];
  queue.push(kill);

  // Use bfs to find all connected pids.
  while (queue.length > 0) {
    var elem = queue.shift();
    results.push(elem);
    if (!table[elem]) continue;
    var l = table[elem];

    for (var i = 0; i < l.length; i ++) 
      queue.push(l[i]);
  }

  return results;
}

