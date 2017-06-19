function longestPalindrome(string) {
  if (!string.length) return null;
  else if (string.length === 1) return string;

  var front = 0;
  var back = 0;
  var length = 1;

  for (var i = 0; i < string.length; i ++) {
    var odd = findMaxPalindrome(string, i, i);
    var even = findMaxPalindrome(string, i, i + 1);

    if (length < odd[0]) {
      length = odd[0];
      front = odd[1];
      back = odd[2];
    }

    if (length < even[0]) {
      length = even[0];
      front = even[1];
      back = even[2];
    }
  }

  return string.substring(front, back);
}

function findMaxPalindrome(string, i, j) {
  while (i > -1 && j < string.length && string.charAt(i) === string.charAt(j)) {
    i --;
    j ++;
  }

  return [j - i + 1, i + 1, j];
}

module.exports = longestPalindrome;
