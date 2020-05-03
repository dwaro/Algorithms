export default class CustomSet {
  constructor(values) {
    if (values !== undefined && values !== null && values !== []) {
      this._values = values;
    } else {
      this._values = [];
    }
  }

  contains(val) {
    return this._values.indexOf(val) === -1 ? false : true;
  }

  get values() {
    return this._values;
  }

  add(val) {
    if (this.contains(val)) {
      return -1;
    }
    this._values.push(val);
    return 1;
  }

  remove(val) {
    const index = this._values.indexOf(val);
    if (index === -1) return -1;
    const end = this._values.slice(index + 1);
    this._values.splice(index);
    this._values.push.apply(this.values, end);
    return 1;
  }

  // return all unique values between two sets
  union(otherSet) {
    let unionSet = new CustomSet();
    this._values.forEach((element) => {
      unionSet.add(element);
    });
    otherSet.forEach((element) => {
      if (!unionSet.contains(element)) {
        unionSet.add(element);
      }
    });
    return unionSet;
  }

  // return only the values of which both sets contain
  intersection(otherSet) {
    let intersectionSet = new CustomSet();
    this._values.forEach((element) => {
      if (otherSet.contains(element)) {
        intersectionSet.add(element);
      }
    });
    return intersectionSet;
  }

  // return all the values that are unique to the sets
  difference(otherSet) {
    let differenceSet = new CustomSet();
    this._values.forEach((element) => {
      if (!otherSet.contains(element)) {
        differenceSet.add(element);
      }
    });
    otherSet.values.forEach((element) => {
      if (!this.contains(element)) {
        differenceSet.add(element);
      }
    });
    return differenceSet;
  }

  // test if a set is a subset of a different set
  subset(otherSet) {
    return otherSet.values.every((element) => this.contains(element));
  }

  size() {
    return this._values.length;
  }
}

// let uniques = new CustomSet();
// uniques.add(1);
// uniques.add(4);
// uniques.add(5);
// uniques.add(2);
// uniques.add(3);
// uniques.add(5);
// uniques.add(2);
// uniques.add(9);
// console.log(uniques.values);
// console.log(uniques.contains(9));
// console.log(uniques.contains(23));
// uniques.remove(4);
// console.log(uniques.values);
// console.log(uniques.contains(4));
// console.log(uniques.union([10, 2, 5, 9, 7, 25]).values);
// console.log(uniques.intersection(new CustomSet([10, 2, 5, 9, 7, 25])).values);
// console.log(uniques.difference(new CustomSet([10, 2, 5, 9, 7, 25])).values);
// console.log(uniques.subset(new CustomSet([1, 3, 9])));
// console.log(uniques.subset(new CustomSet([29, 13])));
// console.log(uniques.subset(new CustomSet([1, 3, 10])));
// console.log(uniques.size());
