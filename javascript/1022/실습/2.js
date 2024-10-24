// 1 ~ 100 중 7의 배수의 개수 찾기

// 1이 7의 배수가 맞나?
// 2가 7의 배수가 맞나?
// 3이 7의 배수가 맞나?
// ...
// 7이 7의 배수가 맞다! => 개수를 늘려준다.
let count = 0;
for (let num = 1; num <= 100; num++) {
  // if (!(num % 7)) { 나머지가 존재하지 않을 때
  if (num % 7 === 0) {
    // 나머지가 0일 때
    count++;
  }
}

count = 0;
for (let num = 1; num <= 100; num++) {
  if (num % 7) continue;
  count++;
}

count = 0;
for (let num = 7; num <= 100; num += 7) {
  count++;
}

count = Math.floor(100 / 7);
