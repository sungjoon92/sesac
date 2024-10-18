// 숫자 크기 비교 1
const number_1 = 7;
const number_2 = 5;
if (number_1 < 10) {
  console.log('number_1은 10보다 작다.');
}

// 짝수
console.log('-----------------');
if (number_1 % 2 === 0) {
  console.log('짝수');
}
console.log();

// 자료형 확인1
console.log('-----------------');

const variable = 10;
console.log(variable);

// 자료형 확인
console.log('-----------------');

if (typeof variable === 'number') {
  console.log('숫자형');
}

// 숫자 크기 비교 2
console.log('-----------------');
if (number_1 < 10) {
  console.log('number_1은 10보다 작다.');
} else if (number_1 > 10) {
  console.log('number_1은 10보다 크다.');
}

// 합격 / 불합격
console.log('-----------------');
const score = 10;
if (score >= 60) {
  console.log('합격');
} else if (score < 60) {
  console.log('불합격');
}

// 숫자 크기 비교 3
console.log('-----------------');

if (number_1 < 10) {
  console.log('number_1은 10보다 작다.');
} else if (number_1 > 10) {
  console.log('number_1은 10보다 크다.');
} else if (number_1 === 10) {
  console.log('number_1은 10이다.');
}

// 숫자 크기 비교 4
console.log('-----------------');
if (typeof number_1 === 'number') {
  if (number_1 < 10) {
    console.log('number_1은 10보다 작다.');
  } else if (number_1 > 10) {
    console.log('number_1은 10보다 크다.');
  } else if (number_1 === 10) {
    console.log('number_1은 10이다.');
  }
} else {
  console.log('숫자가 아니다.');
}

// 짝수 / 홀수
console.log('-----------------');
if (number_1 === 0) {
  console.log('영');
} else if (number_1 % 2 === 0) {
  console.log('짝수');
} else if (number_1 % 2 === 1) {
  console.log('홀수');
}

console.log('-----------------');
// 아이디 / 비밀번호 확인

const username = 'beemo';
const password = '1234';

if (username === 'sesac' && password === 'sesac1234') {
  console.log('로그인 성공');
} else {
  console.log('로그인 실패');
}

// 두 수 비교
console.log('-----------------');

if (number_1 > number_2) {
  console.log(number_1);
} else if (number_2 > number_1) {
  console.log(number_2);
} else if (number_1 === number_2) {
  console.log('같다');
}

// 2와 3의 배수
console.log('-----------------');

if (number_1 % 2 === 0 && number_1 % 3 === 0) {
  console.log('6의 배수');
} else if (number_1 % 2 === 0 && !(number_1 % 3 === 0)) {
  console.log('2의 배수');
} else if (!(number_1 % 2 === 0) && number_1 % 3 === 0) {
  console.log('3의 배수');
} else {
  console.log('2의 배수도 아니고, 3의 배수도 아니다.');
}
