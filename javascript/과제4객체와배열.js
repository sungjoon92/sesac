// 객체와 배열 1

const todos = [
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

for (let index of todos) {
  console.log(index);
}
console.log('---------객체와 배열 2--------');

// 객체와 배열 2
for (let index of todos) {
  console.log(
    'content: ' + index.content + ', isCompleted: ' + index.isCompleted
  );
}

console.log('---------객체와 배열 3--------');
// 객체와 배열 3

for (let index of todos) {
  if (index.todoId === 2) {
    console.log(index);
  }
}

console.log('---------객체와 배열 4--------');
// 객체와 배열 4
for (let index of todos) {
  if (index.todoId === 2) {
    index.isCompleted = true;
  }
  console.log(index);
}
