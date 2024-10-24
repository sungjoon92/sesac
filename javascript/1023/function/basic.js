// function 함수이름(입력값){
//   입력값을 사용한 기능

//   return 출력값
// }

// 숫자를 입력 받아서, 1을 더하는 기능을 만들고 싶어요.

function plusOne(num) {
  let plusOneNumber = num + 1;

  return plusOneNumber;
}

let x = 10; // y -> 11
let y = plusOne(x);
// let y = plusOne(10)

// 1. 2를 곱하는 함수를 만들어보자.
// 숫자를 입력 받아서 2를 곱한 값을 return

function mul2(num) {
  let mul2num = num * 2;
  return mul2num;
}

// 2. 소수를 판별하는 함수를 만들어보자.
// 숫자를 입력 받아서 소수 여부를 return하고 싶다.

function checkPrime(num) {
  let isPrime = true;
  for (let i = 2; i < num; i++) {
    if (num % i === 0) {
      isPrime = false;
      return isPrime;
    }
  }

  return isPrime;
}

// 3. 구구단 중 n단을 return하는 함수를 만들어보자.

function nDan(n) {
  let n_dan = [];
  for (let i = 1; i <= 9; i++) {
    n_dan.push(n * i);
  }
  return n_dan;
}

// 구구단 만들기
const gugudan = [];
for (let i = 1; i <= 9; i++) {
  gugudan.push(nDan(i));
}
console.log(gugudan);
// console.log(nDan(3));
// gugudan.push(nDan(1))
// gugudan.push(nDan(2))
// gugudan.push(nDan(3))
// gugudan.push(nDan(4))
