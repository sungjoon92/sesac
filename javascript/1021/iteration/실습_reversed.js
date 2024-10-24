const nums = [10, 6, 8, 5, 4];

// 결과

// const reversedNum = [4, 5, 8, 6, 10]
const reversedNum = [];

for (let index in nums) {
  // let newIndex = 4 - index;
  let newIndex = nums.length - 1 - index;

  let newValue = nums[newIndex];
  reversedNum.push(newValue);
}

console.log(reversedNum);

// let num;

// num = 4;
// reversedNum.push(num);

// num = 5;
// reversedNum.push(num);

const reversedNum2 = [];
for (num of nums) {
  reversedNum2.unshift(num);
}

console.log(reversedNum2);

// num = 10
// reversedNum 왼쪽에 넣겠어

// num = 6
// reversedNum 왼쪽에 넣겠어
