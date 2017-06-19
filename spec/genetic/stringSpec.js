var Population = require('../../javascript/genetic/string');

describe('hello', () => {
  it('should contain "Hello World!"', () => {
    var population = new Population('Hello World!', 10);
    population.generate(false /* No logging */);
    expect(JSON.stringify(population.members[0])).toEqual(JSON.stringify({ code: 'Hello World!', cost: 0 }));
  });

  it('should contain "Hello World!" with a high population size', () => {
    var population = new Population('Hello World!', 50);
    population.generate(false /* No logging */);
    expect(JSON.stringify(population.members[0])).toEqual(JSON.stringify({ code: 'Hello World!', cost: 0 }));
  });

  it('should contain "Hello World!" with a low population size', () => {
    var population = new Population('Hello World!', 5);
    population.generate(false /* No logging */);
    expect(JSON.stringify(population.members[0])).toEqual(JSON.stringify({ code: 'Hello World!', cost: 0 }));
  });

  it('should contain "Virginia Tech"', () => {
    var population = new Population('Virginia Tech', 10);
    population.generate(false /* No logging */);
    expect(JSON.stringify(population.members[0])).toEqual(JSON.stringify({ code: 'Virginia Tech', cost: 0 }));
  });

  it('should contain "Virginia Tech" with a high population size', () => {
    var population = new Population('Virginia Tech', 40);
    population.generate(false /* No logging */);
    expect(JSON.stringify(population.members[0])).toEqual(JSON.stringify({ code: 'Virginia Tech', cost: 0 }));
  });

  it('should contain "Virginia Tech" with a low population size', () => {
    var population = new Population('Virginia Tech', 7);
    population.generate(false /* No logging */);
    expect(JSON.stringify(population.members[0])).toEqual(JSON.stringify({ code: 'Virginia Tech', cost: 0 }));
  });
});
