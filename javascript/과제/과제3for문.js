let N = 10;
// 1부터 N까지 출력 1
for (i = 0; i < N; i++) {
  console.log(i);
}

console.log('---------------------');
// 1부터 N까지 출력 2
let num = 0;
while (num < N) {
  num++;
  console.log(num);
}

console.log('---------------------');
// 1부터 N까지의 합
N = 5;
let total = 0;
for (let i = 1; i < N; i++) {
  total += i;
  console.log(total);
}

console.log('---------------------');
// 짝수의 합
N = 10;
total = 0;
for (let i = 1; i < N; i++) {
  if (i % 2 === 0) {
    total += i;
    console.log(total);
  }
}

console.log('---------------------');
// 짝수의 개수
N = 10;
let count = 0;
for (let i = 1; i <= N; i++) {
  if (i % 2 === 0) {
    count++;
  }
}
console.log(count);
console.log('-------반복문제어----------');
// 반복문 제어

const arr = [1, 9, 3, 11, 4, 5, 2, 7];
for (let number of arr) {
  if (number % 2 === 0) {
    continue;
  }
  console.log(number);
}

console.log('---------------------');
console.log('---------------------');
