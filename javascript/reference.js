const names = ['jun', 'beemo', 'lynda'];

// index 로 접근
console.log(names[0]);

// push로 원소 추가
names.push('ken');
names.push('ka');
console.log(names);

// pop로 원소 삭제
let popped_el = names.pop();
names.pop();
names.pop();
console.log(popped_el);
console.log(names);

const numbers = [0, 1, 2, 3, 4, 5, 6, 7, 8];
console.log(numbers.slice(2, 4));
console.log(numbers.slice(4, 7));

let person = {
  name: 'bemo',
  age: 27,
  handsome: true,
};

console.log(person.name);
let a = [1, 2, 3];
let b = [1, 2, 3];

console.log(a === b);
