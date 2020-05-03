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
  });
});

describe('Add tests', () => {
  each([
    [[1]],
    [[1, 2]],
    [[1, 2, 3, 4, 5, 6, 1, 2, 4, 5, 10]],
    [[1, 1, 1, 1, 1]],
  ]).test('Adding values to set.', (values) => {
    let arr = [];
    let mySet = new CustomSet();
    values.forEach((val) => {
      mySet.add(val);
      if (!arr.includes(val)) {
        arr.push(val);
      }
    });
    expect(mySet.values).toEqual(arr);
  });
});
