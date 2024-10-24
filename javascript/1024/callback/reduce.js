const nums = [1, 2, 3, 4, 5, 6, 7];

const mulNums = nums.reduce((acc, cur) => {
  console.log(acc, cur);
  return acc * cur;
}, 1);

// const mulNums2 = nums.reduce((acc, cur) => acc * cur, 1);
console.log(mulNums);

const numbers = [5, 8, 2, 5, 1, 4];
// minValue를 reduce를 통해 계산하시오.

// let minNum = Infinity;
let minNum = nums[0];

for (num of nums) {
  if (minNum > num) {
    minNum = num;
  }
}

const minValue = numbers.reduce((acc, cur) => {
  if (acc > cur) {
    acc = cur;
  }
  return acc;
}, Infinity);

console.log(minValue);

const minValue2 = numbers.reduce(
  (acc, cur) => (acc > cur ? cur : acc),
  Infinity
);

console.log(minValue2);
