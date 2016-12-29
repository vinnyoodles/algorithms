var TreeNode = require('../../src/tree/TreeNode');
var pathSum = require('../../src/tree/pathSum');

describe('pathSum', () => {
  beforeEach(() => {
    this.node = new TreeNode([1, 2, 3, 4, 5]);
  });

  it('should return true if there is a valid path', () => {
    expect(pathSum(this.node, 6)).toEqual(true);
    expect(pathSum(this.node, 12)).toEqual(true);
  });

  it('should return false if there is not a valid path', () => {
    expect(pathSum(this.node, 1)).toEqual(false);
    expect(pathSum(this.node, 2)).toEqual(false);
    expect(pathSum(this.node, 3)).toEqual(false);
    expect(pathSum(this.node, 4)).toEqual(false);
    expect(pathSum(this.node, 5)).toEqual(false);
    expect(pathSum(this.node, 7)).toEqual(false);
    expect(pathSum(this.node, 8)).toEqual(false);
    expect(pathSum(this.node, 9)).toEqual(false);
    expect(pathSum(this.node, 10)).toEqual(false);
    expect(pathSum(this.node, 11)).toEqual(false);
    expect(pathSum(this.node, 13)).toEqual(false);
  });
});
