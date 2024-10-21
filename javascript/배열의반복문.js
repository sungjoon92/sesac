// 배열의 반복문 1
let arr = [1, 2, 3, 4, 5];
for (let index of arr) {
  console.log(index);
}

// 배열의 반복문 2

console.log('-------------');
let a = 0;
for (let index of arr) {
  // arr = [arr * index]
  arr[0] * arr[0];
  arr[1] * arr[1];
  arr[2] * arr[2];
  arr[3] * arr[3];
  arr[4] * arr[4];

  a = index * index;
  console.log(a);
}

// const lst = ['a', 'b', 'c', 'd'];

// for (index in lst) {
//   value = lst[index];
// }

// for (value of lst) {
// }

// 배열의 반복문 3
console.log('-------------');

for (let index of arr) {
  if (index % 2 === 0) {
    console.log(index);
  }
}

// 객체의 반복문 1
let person = {
  name: '홍길동',
  age: 30,
  job: '개발자',
};

for (let index in person) {
  console.log(index + ',' + person[index]);
}
