// 글로벌 환경에 변수 선언 => 블럭에서 사용

const const_1 = 'const_1';
let let_1 = 'let_1';

{
  console.log(const_1);
  console.log(let_1);
}

// 블럭에서 변수 선언 => 글로벌

{
  const const_2 = 'const_2';
  let let_2 = 'let_2';
}
// console.log(const_2); // 불가능
// console.log(let_2);   // 불가능

// 글로벌 환경에 변수 선언 => 블럭에서 선언

const const_3 = 'const_3_outer';
let let_3 = 'let_3_outer';

{
  const const_3 = 'const_3_inner';
  let let_3 = 'let_3_inner';
}

console.log(const_3);
console.log(let_3);

// 글로벌 환경에 변수 선언 => 블럭에서 할당

let let_4 = 'let_4_outer';

{
  let_4 = 'let_4_inner';
  console.log(let_4);
}
console.log(let_4);

for (let i = 0; i < 3; i++) {
  // 3번을 따라 감.
  // let i = 10; // 가능 / 불가능 여부를 차치하고, 쓰면 안됨
  const value = i;
  console.log(value);
}


