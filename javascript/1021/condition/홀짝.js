// 짝수
//   2의 배수
//     2로 나누었을 때 나머지가 0인 것
//      만약 2로 나눈 나머지가 0이면 넌 짝수야

// if (숫자를 2로 나눈 나머지가 0이야){
//   너는 짝수야
// }

const num = 20;

if (num % 2 == 0) {
  console.log('짝수야');
}

if (num % 2 == 1) {
  console.log('홀수야');
}

if (!(num % 2)) {
  // 나머지가 존재하지 않아.
  console.log('짝수야');
}

if (num % 2) {
  // 나머지가 존재해.
  // 숫자는 0이 아니면 true
  console.log('홀수야');
}

// 나머지가 존재해 == 0이 아니란

// if (num %2 != 0)

// ---------------------------------------------------------------------------------------

const number = 20;
let status;

if (num % 2) {
  status = '홀수';
} else {
  status = '짝수';
}

console.log(status);

let status2 = num % 2 ? '홀수' : '짝수';
