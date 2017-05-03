var permutations = require('../../src/recursion/permutations');

describe('permutations', () => {
    it('should return all permutations of arrays', () => {
        var result = permutations([[1, 2], [3, 4]]);
        expect(result).toContain([3, 2]);
        expect(result).toContain([3, 1]);
        expect(result).toContain([4, 2]);
        expect(result).toContain([4, 1]);
    });

    it('should return all permutations of arrays', () => {
        var result = permutations([[1, 2], [3], [4, 5], [6, 7]])
        expect(result).toEqual([ 
            [ 6, 4, 3, 1 ],
            [ 6, 4, 3, 2 ],
            [ 6, 5, 3, 1 ],
            [ 6, 5, 3, 2 ],
            [ 7, 4, 3, 1 ],
            [ 7, 4, 3, 2 ], 
            [ 7, 5, 3, 1 ],
            [ 7, 5, 3, 2 ] 
        ]);
    });
});
