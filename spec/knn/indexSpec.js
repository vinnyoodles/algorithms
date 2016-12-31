var knn = require('../../src/knn');
var housing = require('./housing.json');
var cars = require('./cars.json');

describe('knn', () => {
  describe('housing', () => {
    it('should determine unknown housing types', () => {
      var dataset = new knn.NodeList(3, housing);
      var x = 'rooms';
      var y = 'area';
      var type = 'type';
      expect(dataset.normalizeAxis([x, y])).toEqual({ rooms: { min: 1, max: 10, label: 'rooms', range: 9 }, area: { min: 250, max: 1700, label: 'area', range: 1450 }});
      expect(dataset.determine([x, y], type)).toEqual([]);
      dataset.add(new knn.Node({ 'rooms': 1, 'area': 350, 'type': null }));
      expect(dataset.determine([x, y], type)).toEqual(['apartment']);
      dataset.add(new knn.Node({ 'rooms': 10, 'area': 350, 'type': null }));
      expect(dataset.determine([x, y], type)).toEqual(['house']);
      dataset.add(new knn.Node({ 'rooms': 10, 'area': 1, 'type': null }));
      expect(dataset.determine([x, y], type)).toEqual(['house']);
      dataset.add(new knn.Node({ 'rooms': 2, 'area': 2000, 'type': null }));
      expect(dataset.determine([x, y], type)).toEqual(['flat']);
      dataset.add(new knn.Node({ 'rooms': 100, 'area': 200, 'type': null }));
      expect(dataset.determine([x, y], type)).toEqual(['house']);
      dataset.add(new knn.Node({ 'rooms': 100, 'area': 200, 'type': null }));
      expect(dataset.determine([x, y], type)).toEqual(['house']);
    });
  });

  describe('cars', () => {
    it('should work for multidimensional datasets', () => {
      var dataset = new knn.NodeList(3, cars);
      var dimensions = ['mpg','cylinders','displacement','horsepower','weight','acceleration'];
      expect(dataset.normalizeAxis(dimensions)).toEqual({
        mpg: { min: 9, max: 46.6, label: 'mpg', range: 37.6 },
        cylinders: { min: 3, max: 8, label: 'cylinders', range: 5 },
        displacement: { min: 68, max: 455, label: 'displacement', range: 387 },
        horsepower: { min: 46, max: 230, label: 'horsepower', range: 184 },
        weight: { min: 1613, max: 5140, label: 'weight', range: 3527 },
        acceleration: { min: 8, max: 24.8, label: 'acceleration', range: 16.8 }
      });
      dataset.add(new knn.Node({'mpg':30,'cylinders':4,'displacement':200,'horsepower':100,'weight':2000,'acceleration':10}));
      dataset.add(new knn.Node({'mpg':20,'cylinders':8,'displacement':100,'horsepower':100,'weight':1500,'acceleration':20}));
      dataset.add(new knn.Node({'mpg':30,'cylinders':8,'displacement':250,'horsepower':200,'weight':1000,'acceleration':15}));
      expect(dataset.determine(dimensions, 'year')).toEqual([ '79', '70', '78' ]);
    });
  });
});
