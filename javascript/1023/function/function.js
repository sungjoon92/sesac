function plusone(num) {
  let plusoneNumber = num + 1;

  return plusoneNumber;
}

let x = 3;
let y = plusone(x);

console.log(y);
y = gop(x);
//1. 2를 곱하는 함수만들기
function gop(x) {
  let num = x * 2;

  return num;
}

console.log(y);

//1. 소수를 판별하는 함수만들기
y = prime(x);

function prime(x) {
  let isPrime = true;
  for (let i = 2; i < x; i++) {
    if (x % i === 0) {
      isPrime = false;
      return isPrime;
    }
  }

  return isPrime;
}

console.log(y);

//1. 구구단 중 n단을 return하는 함수만들기
y = nDan(x);

function nDan(x) {
  let gugudan = [];
  for (let i = 1; i <= 9; i++) {
    gugu = x * i;
    console.log(gugu);
    gugudan.push(gugu);
  }

  return gugudan;
}
console.log(y);

const names = [];

function greetAll(...names) {
  for (name of names) {
    console.log(`안녕하세요, ${name}님!`);
  }

  for (name in names) {
    let index = names[name];
    console.log(`안녕하세요, ${index}님!`);
  }
}
greetAll('철수', '영희', '짱구');

