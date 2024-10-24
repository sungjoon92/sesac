// function 함수이름(매개변수){
//   기능
//   return 결과값
// }

// a, b 두개를 더하는 함수를 만든다.

function add(a, b) {
  return a + b;
}

console.log(add(1, 2));
console.log(add(4, 10));

function greet(name = 'Guest') {
  console.log(`안녕하세요, ${name}님!`);
}

greet('유창준');
greet(); // 안녕하세요, ${Guest}님!

function sum(...nums) {
  let total = 0;
  // nums 더하기
  console.log(nums);
  return;
}

sum(1, 2, 3, 4, 5, 6, 7);
