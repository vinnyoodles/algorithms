var kmeans = require('../../javascript/kmeans');

describe('kmeans', () => {
  describe('dataset1', () => {
    beforeEach(() => {
      this.data = [[1,2],[2,1],[2,4],[1,3],[2,2],[3,1],[1,1],[7,3],[8,2],[6,4],[7,4],[8,1],[9,2],[10,8],[9,10],[7,8],[7,9],[8,10],[9,9]];

      this.factors = [0, 1];
      this.clusterSize = 3;
      this.list = new kmeans.NodeList(this.clusterSize, this.data);
    });

    it('should cluster the data', () => {
      var clusters = this.list.cluster(this.factors);
      expect(this.list.normalizeAxis(this.factors)).toEqual({ 0: { min: 1, max: 10, label: 0, range: 9 }, 1: { min: 1, max: 10, label: 1, range: 9 } });
      expect(clusters.length).toEqual(this.clusterSize);
      clusters.forEach((cluster) => {
        cluster.forEach((point) => {
          expect(point).toBeWithinRange(1, 10);
        });
      });
    });

    it('should make the assignments', () => {
      var assignments = this.list.assign(this.factors);
      expect(assignments.length).toEqual(this.data.length);
      assignments.forEach((assignment) => {
        expect(assignment).toBeWithinRange(0, this.clusterSize - 1);
      });
    });

    it('should keep clustering and assigning until complete', () => {
      var results = this.list.run(this.factors, [[9,9], [1,1], [5,2]]);
      expect(this.list.nodes).toEqual(this.data);
      var clusters = [[8,9], [1,2], [7,2]];
      results.forEach(r => expect(clusters).toContain(r));
    });
  });
});
