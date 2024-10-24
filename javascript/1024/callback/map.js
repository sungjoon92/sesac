const numbers = [1, 2, 3, 4];

const doubled = numbers.map((num) => {
  return num * 2;
});

console.log(doubled); // [2, 4, 6, 8]

// arr = [x, y, z]
// new_arr = [f(x), f(y), f(z)]

// strNumbers => numNumbers로 바꾸어 새로운 변수에 할당하여라
const strNumbers = ['1', '2', '3', '4'];
// const numNumbers = [1, 2, 3, 4];
console.log(parseInt('1'));
console.log('1');

// 하고 싶은 것 : ['1', '2', '3', '4']를 [1, 2, 3, 4]로 만들자.

// 바꿀 정수를 넣을 array
// '1' => 1 => 집어넣고
// '2' => 2 => 집어넣고

const intArray = [];
for (let strNum of ['1', '2', '3', '4']) {
  let intNum = parseInt(strNum);
  intArray.push(intNum);
}

console.log(intArray);

let intArray2 = strNumbers.map((num) => parseInt(num));
let intArray3 = strNumbers.map((num) => {
  return parseInt(num);
});

console.log(intArray2);
