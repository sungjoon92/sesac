// 변수와 상수
let let_variable = 'Hello World';
const const_variable = 'Hello World';

console.log(let_variable);
console.log(const_variable);

// 숫자형 변수와 문자열 변수
console.log('-----------------');
let number_variable = 1;
let string_variable = '1';

console.log(typeof number_variable);
console.log(typeof string_variable);

// 상수형 변수
console.log('-----------------');
let variable = '상수형 변수에는 재할당 할 수 없다.';
variable = '재할당';

console.log(variable);

// 템플릿 리터럴
console.log('-----------------');
const name = '정우영';
const hello = `안녕하세요. ${name} 입니다.`;

console.log(hello);

// 사칙연산
console.log('-----------------');
const number1 = 100;
const number2 = 200;

console.log(number1 + number2);
console.log(number1 - number2);
console.log(number1 * number2);
console.log(number1 / number2);

// 나머지
console.log('-----------------');
const number3 = 10;
const number4 = 11;

console.log(number3 % 2);
console.log(number4 % 2);

// 배열 생성과 인덱싱
console.log('-----------------');
const number_arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

console.log(number_arr[0]);
console.log(number_arr[2]);
console.log(number_arr[8]);
console.log(number_arr[9]);

// 빈 배열과 원소 추가
console.log('-----------------');
let arr = [];
arr.push(10, 20, 30, 40, 50);

console.log(arr);

// 객체 값 접근
console.log('-----------------');
let todo = {
  userId: 1,
  id: 1,
  title: 'delectus aut autem',
  completed: false,
};

console.log(todo.userId);
console.log(todo.id);
console.log(todo.title);
console.log(todo.completed);

// 객체 생성
console.log('-----------------');

let person = {
  name: '정우영',
  age: 20,
  city: '서울',
  location: '성동',
  language: 'HTML, CSS, JavaScript',
};

console.log(person);
