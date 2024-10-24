// 2의 배수 혹은 3의 배수를 제외하고 1~30까지 숫자를 출력하시오.
// 2의 배수가 아니고 3의 배수도 아닌 녀석을 출력하라.
//  1 5 7 11 13 17 19 23 25 29

for (let num = 1; num <= 30; num++) {
  if (!(num % 2)) continue;
  // if (num % 2 === 0) continue;

  if (!(num % 3)) continue;
  // if (num % 3 === 0) continue;

  console.log(num);
}

for (let num = 1; num <= 30; num++) {
  if (num % 2 === 0 || num % 3 === 0) continue;

  console.log(num);
}

for (let num = 1; num <= 30; num++) {
  // if (2의 배수가 아니고 / 3의 배수가 아니야)
  if (num % 2 && num % 3) {
    console.log(num);
  }
}
