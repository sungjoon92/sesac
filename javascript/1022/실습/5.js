// 두개의 숫자에 대해. 두 수 사이에 속한 모든 정수의 합을 구하시오. (ex. 2와 5를 입력받는다면 2 + 3 + 4 + 5 = 14)

let a = 5;
let b = 2;

// a의 값을 임시로 저장
let tmp = a;
// b의 값을 a에 넣고
a = b;
// b에 a의 예전 값을 넣습니다.
b = tmp;

console.log(a, b);

let num1 = 5;

let num2 = 2;

if (num1 > num2) {
  let tmp = num1;
  num1 = num2;
  num2 = tmp;
}

let total = 0;
for (let num = num1; num <= num2; num++) {
  total += num;
}

console.log(total);
