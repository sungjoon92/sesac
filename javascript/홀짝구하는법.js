const number = 20;
let status;
if (number % 2) {
  status = '홀수';
} else {
  status = '짝수';
}

console.log(status);

let status2 = number % 2 ? '홀수' : '짝수';
console.log(status2);

let money = true;
let car = true;

if (money === true && car === true) {
  console.log(false);
} else if (money === false && car === false) {
  console.log(false);
} else {
  console.log(true);
}

let a;

(money === true && car === true) || (money === false && car === false)
  ? (a = false)
  : (a = true);

console.log(a);

console.log((money || car) && !(money && car));

true && false;

// t t f
// t f t
// f t t
// f f f
// 점수 구하기
const score = 39;
let A = 'A';
let B = 'B';
let C = 'C';

if (score >= 90) {
  console.log(A);
  if (score === 100) {
    console.log('교수님의 총애');
  }
} else if (score >= 80) {
  console.log(B);
} else {
  console.log(C);
  if (score < 40) {
    console.log(C + '교수님의 총애');
  }
}

const isWeekend = true;
const nowTime = 15;
//일과 시간
let isworkingHour = true;

if (9 <= nowTime && nowTime <= 18) {
  isworkingHour = true;
} else {
  isworkingHour = false;
}

let toDo;
if (isWeekend) {
  if (isworkingHour) {
    toDo = '휴식';
    console.log(toDo);
  } else {
    toDo = '자기개발';
    console.log(toDo);
  }
} else {
  //주말이 아닌 경우
  if (isworkingHour) {
    toDo = '일`';
    console.log(toDo);
  } else {
    toDo = '휴식';
    console.log(toDo);
  }
}

isWeekend && isworkingHour ? (toDo = '휴식') : (toDo = '자기개발');

console.log(b);
