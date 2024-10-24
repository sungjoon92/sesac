// and에 대한 상황
let money;
let hungry;

// 돈이 1000원 보다 많으면 돈이 충분
money > 1000;

// 배고픔이 50보다 많으면 배고픈 것
hungry > 50;

// && and 연산자 => 돈이 충분하고 배가 고플때 만 true

money = 10000;
hungry = 100;

console.log(money > 1000 && hungry > 50);

money = 100;
hungry = 100;

console.log(money > 1000 && hungry > 50);

money = 10000;
hungry = 0;

console.log(money > 1000 && hungry > 50);

money = 100;
hungry = 0;
console.log(money > 1000 && hungry > 50);
