const nums = [10, 6, 8, 5, 4, 2, 3, 11];
// const nums = [];

// let minNum = Infinity;
let minNum = nums[0];

for (num of nums) {
  if (minNum > num) {
    minNum = num;
  }
}

console.log(minNum);

for (num of nums) {
  console.log('초기값');
  console.log(`minNum : ${minNum}`);
  console.log(`num : ${num}`);
  if (minNum > num) {
    minNum = num;
  }
  console.log('결과값');
  console.log(`minNum : ${minNum}`);
  console.log();
}

// let minNum
// let b

// if (minNum > b){
//   minNum = b
// }

// if (minNum < b){
//   minNum
// }

// if (minNum === b){
//   minNum
//   b
// }
