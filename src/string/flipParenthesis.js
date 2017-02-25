function flipParen(paren) {
  var list = [];
  for (var i = 0; i < paren.length; i ++) {
  	if (paren.charAt(i) == '(') {
  		list.push('(');
  	} else if (paren.charAt(i) == ')' && list[list.length - 1] == '(') {
  		list.pop();
  	} else {
  		list.push(paren.charAt(i));
  	}
  }

  return list.length / 2;
}

module.exports = flipParen;
