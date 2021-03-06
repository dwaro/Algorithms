import CustomSet from '../CustomSet.js';
import each from 'jest-each';

describe('Testing Constructors', () => {
  test('Constructor sets values with valid input', () => {
    let mySet = new CustomSet([1, 2]);
    expect(mySet.values).toEqual([1, 2]);

    let mySet1 = new CustomSet([1]);
    expect(mySet1.values).toEqual([1]);
  });

  test('Constructor handles parameters of null, undefined and empty', () => {
    let mySet = new CustomSet(undefined);
    expect(mySet.values).toEqual([]);

    let mySet1 = new CustomSet(null);
    expect(mySet1.values).toEqual([]);

    let mySet2 = new CustomSet([]);
    expect(mySet2.values).toEqual([]);

    let mySet3 = new CustomSet();
    expect(mySet3.values).toEqual([]);
  });

  each([
    [
      [1, 1, 1, 2],
      [1, 2],
    ],
    [
      [1, 2, 3, 4, 4],
      [1, 2, 3, 4],
    ],
  ]).test('Repeat values', (values, expected) => {
    let mySet = new CustomSet(values);
    expect(mySet.values).toEqual(expected);
  });
});

describe('Add tests', () => {
  each([
    [[1], [1]],
    [
      [1, 2],
      [1, 2],
    ],
    [
      [1, 2, 3, 4, 5, 6, 1, 2, 4, 5, 10],
      [1, 2, 3, 4, 5, 6, 10],
    ],
    [[1, 1, 1, 1, 1], [1]],
  ]).test('Adding values to set.', (values, expected) => {
    let mySet = new CustomSet();
    values.forEach((val) => {
      mySet.add(val);
    });
    expect(mySet.values).toEqual(expected);
  });
});

describe('Contains test', () => {
  const mySet = new CustomSet([1, 3, 8, 5, 6, -3]);
  each([
    [1, true],
    [2, false],
    [5, true],
    [10, false],
    [6, true],
    [-18, false],
    [8, true],
    [-3, true],
    ['hello', false],
    [[1, 2, 3], false],
  ]).test('Contains value', (val, expected) => {
    expect(mySet.contains(val)).toEqual(expected);
  });
});

describe('Remove tests', () => {});

describe('Union tests', () => {});

describe('Intersection tests', () => {});

describe('Subset tests', () => {});

describe('Size tests', () => {});
