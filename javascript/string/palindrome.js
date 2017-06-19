function isPalindrome(string) {
  if (!string.length) return false;

  var front = 0;
  var end = string.length - 1;

  while (front < end) {
    if (string.charAt(front++) != string.charAt(end--)) return false;
  }

  return true;
}

module.exports = isPalindrome;
