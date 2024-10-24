// let, const - block {}

if (true) {
  let value = 123;
  console.log(value);
}

// console.log(value);

for (let i = 0; i < 3; i++) {
  let value2 = 123;
}
// console.log(value2);

{
  let value3 = 123;
  var a = '블락 안에 있어';
}

// console.log(value3);
console.log(a);

const outerValue = '밖에 있는 값';

if (true) {
  console.log(outerValue); // 가능
  // const outerValue = '안에 있는 값'; // 불가능
  const innerValue = '안에 있는 값';
}

const innerValue = '밖에 있는 값';
console.log(innerValue);
