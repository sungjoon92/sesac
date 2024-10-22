// 1. 40 이하의 3의 배수를 출력하시오(3단의 확장).
for (let i = 0; i <= 40; i += 3) {
  console.log(i);
}
console.log('1 ~ 100 중에 7의 배수의 개수를 출력하세요.');

// 1. 1 ~ 100 중에 7의 배수의 개수를 출력하세요.
let count = 0;
for (let i = 7; i <= 100; i += 7) {
  count++;
}
console.log(count);

console.log(
  '1. `const arr = [1, 2, 4, 3, 3, 5, 5, 6, 9, 7]` 일 때,원소가  1, 4, 5, 7인 경우를 제외하고 출력하세요'
);
// 1. `const arr = [1, 2, 4, 3, 3, 5, 5, 6, 9, 7]` 일 때,
// 원소가  1, 4, 5, 7인 경우를 제외하고 출력하세요
const arr = [1, 2, 4, 3, 3, 5, 5, 6, 9, 7];
const notLog = [1, 4, 5, 7];

for (let num of arr) {
  let isInNotlog = false;
  for (let notLogNum of notLog) {
    if (num === notLogNum) {
      isInNotlog = true;
      break;
    }
  }

  if (isInNotlog) continue;
  console.log(num);
}
console.log(
  '1 ~ 9 까지의 자연수 중 제곱한 수가 10 이상 50 이하인 자연수의 리스트를 출력해보세요.'
);
// 1. 1 ~ 9 까지의 자연수 중 제곱한 수가 10 이상 50 이하인 자연수의 리스트를 출력해보세요.
const answer = [];
for (let num = 1; num <= 9; num++) {
  let square = num ** 2;
  if (square >= 10 && square <= 50) {
    answer.push(num);
  }
}
console.log(answer);

// 1. 두개의 숫자에 대해. 두 수 사이에 속한 모든 정수의 합을 구하시오. (ex. 2와 5를 입력받는다면 2 + 3 + 4 + 5 = 14)

// 1. 2의 배수 혹은 3의 배수를 제외하고 1~30까지 숫자를 출력하시오.
//  `1 5 7 11 13 17 19 23 25 29`

console.log(' 1. 자연수 n이 주어졌을 때, n이 소수인지 판단하시오.');
// 1. 자연수 n이 주어졌을 때, n이 소수인지 판단하시오.
// 소수 ?
// 1과 자기 자신으로만 나누어 떨어지는 수
// 1, 자기 자신 빼고는 나머지 싹다로는 나누어 떨어지지 않는 수

// 소수가 아닌 수?
// 1과 자기 자신 이외에 어떠한 수로 나누어 떨어지는 수
// 어떤한 수들로 나누어 보자. 나머지가 존재하지 않으면 넌 소수가 아니야.

// 어떤 수가 존재할 때, 넌 소수가 맞아.
// 2 ~ n-1로 나누어 볼게. 혹시 나누어 떨어지면 넌 소수가 아니야.

let num = 2;
let isPrime = true;
for (let i = 2; i < num; i++) {
  if (num % i === 0) {
    isPrime = false;
  }
}

console.log(isPrime);
console.log('------------------------');

let people = [
  { name: 'jun', age: 15, gender: 'M' },
  { name: 'ken', age: 36, gender: 'F' },
  { name: 'alex', age: 37, gender: null },
];

for (let person of people) {
  // console.log(person);
  // person =   { name: 'jun', age: 15, gender: 'M' },
  for (let key in person) {
    let value = person[key];
    console.log(key, value);
  }
}
console.log('----------------------------');

// 이름이 alex인 사람에 대한 정보를 출력하시오
// 이름이 alex인 사람의 나이를 출력하시오
for (let person of people) {
  let name = person.name;
  let age = person.age;
  if (name === 'alex') {
    console.log(name, age);
  }
}
console.log('----------------------------');

people = {
  jun: { name: 'jun', age: 15, gender: 'M' },
  ken: { name: 'ken', age: 36, gender: 'F' },
  alex: { name: 'alex', age: 37, gender: null },
};

for (person in people) {
  console.log(person.name);
  console.log('----------');
}

console.log(people.jun);

for (let name in people) {
  let person = people[name];
  console.log(person);
}
