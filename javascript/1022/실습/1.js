// 40 이하의 3의 배수 출력

// 3 6 9 12 15 ...

// 1. 시작은 3으로
// 2. 3씩 커짐
// 3. 40에서 멈춤

for (let num = 3; num <= 40; num += 3) {
  console.log(num);
}

for (let num = 1; num * 3 <= 40; num++) {
  console.log(num * 3);
}
