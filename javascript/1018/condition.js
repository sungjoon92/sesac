// if (condition) {
//   condition이 true일 때 실행
// }

// if (condition) {
//   condition이 true일 때 실행
// } else {
//   condition이 false일 때 실행
// }

let money = 10000;

if (money > 1000) {
  console.log('충분한 돈이 있어');
}

money = 100;
if (money > 1000) {
  console.log('충분한 돈이 있어');
} else {
  console.log('나는 충분한 돈이 없어');
}

let temperature = 20;

if (temperature <= 22) {
  console.log('보일러 틀어');
}

if (temperature > 22) {
  console.log('에어컨 틀어');
}

if (temperature <= 22) {
  console.log('보일러 틀어');
} else {
  console.log('에어컨 틀어');
}

// 돈이 10000원보다 많으면 치킨
// 돈이 5000원보다 많으면 라면
// 돈이 1000원보다 많으면 과자
// 돈이 100원보다 많으면 추파춥스
if (money > 10000) {
  console.log('치킨');
} else {
  // if money <= 10000 라는 의미가 내포됩니다.
  if (money > 5000) {
    console.log('라면');
  } else {
    // if money <= 10000
    // if money <= 5000
    // 라는 의미가 내포됩니다.
    if (money > 1000) {
      console.log('과자');
    }
  }
}

if (money > 10000) {
  console.log('치킨');
} else {
  if (money > 5000) {
    console.log('라면');
  } else {
    if (money > 1000) {
      console.log('과자');
    }
  }
}

if (money > 10000) {
  console.log('치킨');
} else if (money > 5000) {
  console.log('라면');
} else if (money > 1000) {
  console.log('과자');
} else {
}


