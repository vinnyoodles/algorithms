/**
 * A gene represents a single entity in a generation.
 * Each gene has a code which in this case represents a string
 * and a cost which represents the closesness to the goal string.
 */
function Gene(code) {
  this.code = code ? code : '';
  this.cost = Number.MAX_VALUE;
}

/**
 * Create and set the code randomly
 */
Gene.prototype.random = function(length) {  
  while (length--) {
    this.code += String.fromCharCode(Math.floor(Math.random()*255));
  }
};

/**
 * Calculate the cost of the gene's code
 * using the distance formula.
 */
Gene.prototype.calculate = function(compareTo) {  
  var total = 0;
  for(i = 0; i < this.code.length; i++) {
    var diff = this.code.charCodeAt(i) - compareTo.charCodeAt(i);
    total += (diff * diff);
  }
  this.cost = total;
};

/**
 * Combine two genes to produce two offsprings
 */
Gene.prototype.mate = function(gene) {  
  var pivot = Math.round(this.code.length / 2) - 1;

  var child1 = this.code.substr(0, pivot) + gene.code.substr(pivot);
  var child2 = gene.code.substr(0, pivot) + this.code.substr(pivot);

  return [new Gene(child1), new Gene(child2)];
};

/**
 * Randomly change a char in the gene's code
 */
Gene.prototype.mutate = function(chance) {  
  if (Math.random() < chance) return;

  var index = Math.floor(Math.random() * this.code.length);
  var upOrDown = Math.random() <= 0.5 ? -1 : 1;
  var newChar = String.fromCharCode(this.code.charCodeAt(index) + upOrDown);
  var newString = '';
  for (i = 0; i < this.code.length; i++) {
    newString += (i === index) ? newChar : this.code[i];
  }

  this.code = newString;
};

/**
 * An object to abstract a group of genes
 */
function Population(goal, size) {
  this.members = [];
  this.goal = goal;
  this.generationNumber = 0;
  while (size--) {
    var gene = new Gene();
    gene.random(this.goal.length);
    this.members.push(gene);
  }
}

/**
 * Sort all the genes in the population by cost
 */
Population.prototype.sort = function() {  
  return this.members.sort((a, b) => a.cost - b.cost);
};

/**
 * Display or log the genes
 */
Population.prototype.display = function() {
  console.log(`Generation #${this.generationNumber}`);

  for (var i = 0; i < this.members.length; i++) {
    console.log(`Code: ${this.members[i].code} Cost: ${this.members[i].cost}`);
  }
  console.log('');
};

/**
 * The main function of the population.
 * Used to perform the required actions
 *
 * @param {Boolean} logging if true, then display progress
 */
Population.prototype.generate = function(logging) {  
  for (var i = 0; i < this.members.length; i++) {
    this.members[i].calculate(this.goal);    
  }

  this.sort();
  if (logging) this.display();
  var children = this.members[0].mate(this.members[1]);
  this.members.splice(this.members.length - 2, 2, children[0], children[1]);

  for (var i = 0; i < this.members.length; i++) {
    this.members[i].mutate(0.5);
    this.members[i].calculate(this.goal);
    if (this.members[i].code == this.goal) { 
      this.sort();
      if (logging) this.display();
      return true;
    }
  }

  this.generationNumber++;
  this.generate();
};

module.exports = Population;
