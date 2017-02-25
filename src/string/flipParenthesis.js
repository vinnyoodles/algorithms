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

  if (list.length == 0) return 0;

  var open = 0;
  var close = 0;
  for (var j = 0; j < list.length; j ++) {
  	if (list[j] == '(') {
  		open ++;
  	} else {
  		close ++;
  	}
  }

  return (open / 2) + (close / 2);
}

module.exports = flipParen;
