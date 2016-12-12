function findIntersection(a, b) {
  var temp1 = a;
  var temp2 = b;
  var length1 = 0;
  var length2 = 0;

  while (temp1 || temp2) {
    if (temp1) {
      length1 ++;
      temp1 = temp1.next
    }

    if (temp2) {
      length2 ++;
      temp2 = temp2.next;
    }
  }

  // No intersecting node exists.
  if (temp1 !== temp2) return null;

  var longer = length1 > length2 ? a : b;
  var shorter = length1 > length2 ? b : a;
  var difference = Math.abs(length1 - length2);

  for (var i = 0; i < difference; i++) {
    longer = longer.next;
  }

  while(longer) {
    // Found the intersecting node.
    if (longer === shorter) return longer;

    longer = longer.next;
    shorter = shorter.next;
  }


  return null;
}

module.exports = findIntersection;
