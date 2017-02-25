function flipParen(paren) {
  var counter = 0;
  var min = 0;
  for (var i = 0; i < paren.length; i ++) {
    if (paren.charAt(i) == "(") {
      counter ++;
    } else {
      counter --;
    }

    min = Math.min(counter, min);
  }

  min = Math.abs(min);
  return min + (counter - min);
  //add -mini "(" at the start of the string
  //counter -= mini
  //add counter ")" at the end of the string
}

module.exports = flipParen;
