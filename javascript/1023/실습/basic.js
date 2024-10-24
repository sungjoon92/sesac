// 주어진 테이블의 데이터를 "people" 변수에 저장하시오.
let people = [
  {
    name: 'jun',
    age: 15,
    gender: 'M',
  },
  {
    name: 'ken',
    age: 36,
    gender: 'F',
  },
  {
    name: 'alex',
    age: 37,
    gender: null,
  },
];
const names = ['j', 'k', 'a'];
const ages = [10, 20, 30];
const genders = ['m', 'f', null];

// const arrayPeople = [names, ages, genders];

const arrayPeople = [
  ['j', 'k', 'a'],
  [10, 20, 30],
  ['m', 'f', null],
];

names < -arrayPeople[0];
'k' < -names[1] < -arrayPeople[0][1];
