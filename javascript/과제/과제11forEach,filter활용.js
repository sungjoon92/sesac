// 배열생성
// 변수 `arr` 을 선언하고, 아래 배열을 할당한다.

const arr = [1, 3, 5, -3, 9, 10, 23, -6, 44, 22, -10, 5, 20];
console.log('-----------양수 출력----------');

arr.forEach((num) => {
  if (num > 0) {
    console.log(num);
  }
});

console.log('-----------곱하기 2----------');
// const gop = [];
const gop = arr.map((num) => {
  // gop.push(num);
  return (num *= 2);
});
console.log(gop);

console.log('-----------양수 홀수 배열----------');

// const yh = [];
const yh = arr.filter((num) => {
  return num > 0 && num % 2 === 1;
});
console.log(yh);

console.log('-----------첫 번째 5 찾기----------');
const five = arr.findIndex((num) => {
  return num === 5;
});
console.log(five);

console.log('-----------배열 내 객체 출력하기 1----------');
let todos = [
  {
    todoId: 1,
    content: '예습하기',
    isCompleted: false,
  },
  {
    todoId: 2,
    content: '강의듣기',
    isCompleted: false,
  },
  {
    todoId: 3,
    content: '복습하기',
    isCompleted: false,
  },
];

const list = todos.map((list) => {
  console.log(list);
});

console.log('-----------배열 내 객체 출력하기 2----------');

todos = [
  {
    todoId: 1,
    content: '예습하기',
    isCompleted: false,
  },
  {
    todoId: 2,
    content: '강의듣기',
    isCompleted: true,
  },
  {
    todoId: 3,
    content: '복습하기',
    isCompleted: true,
  },
];

const isCom = todos.filter((list) => {
  return list.isCompleted;
});
console.log(isCom);

console.log('-----------이차원 배열 출력----------');
const matrix = [
  [4, 2],
  [3, 2],
  [5, 7],
  [10, 1],
];

const search = matrix.map((num) => {
  return num[1];
});
console.log(search);
console.log('-----------이차원 배열의 합----------');
const sum = matrix.filter((num) => {
  console.log(num[0] + num[1]);

  return (num[0] + num[1]) % 2 === 0;
});
console.log(sum);
