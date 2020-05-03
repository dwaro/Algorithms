// example of a stack is a browser's history
// LIFO

class Stack {
  constructor() {
    this.length = 0;
    this.stack = {};
  }

  push(element) {
    this.stack[this.length] = element;
    this.length++;
  }

  pop() {
    if (this.length === 0) {
      return null;
    }
    this.length--;
    const val = this.stack[this.length];
    delete this.stack[this.length];
    return val;
  }

  peek() {
    return this.stack[this.length - 1];
  }

  size() {
    return this.length;
  }
}

let myStack = new Stack();
myStack.push(1);
myStack.push(2);
myStack.push(3);
console.log('Size', myStack.size());
console.log(myStack.peek());
console.log('Size', myStack.size());
console.log(myStack.pop());
console.log('Size', myStack.size());
console.log(myStack.pop());
console.log('Size', myStack.size());
console.log(myStack.peek());
myStack.push(5);
console.log('Size', myStack.size());
console.log(myStack.pop());
