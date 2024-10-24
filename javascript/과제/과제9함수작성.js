// 더하기 함수
let x1 = 1;
let x2 = 2;

function add(x1, x2) {
  let sum = x1 + x2;
  console.log(x1, x2);

  console.log(sum);
  return sum;
}
add(x1, x2);

console.log('------크기 비교 함수-------');

// 크기 비교 함수

function compare(x1, x2) {
  if (x1 > x2) {
    console.log(x1);
  } else if (x1 < x2) {
    console.log(x2);
  } else {
    console.log(null);
  }
}

compare(x1, x2);

console.log('-------양수, 음수, 0------');

// 양수, 음수, 0
function determine(x1) {
  let result;
  if (x1 > 0) {
    result = 1;
  } else if (x1 < 0) {
    result = -1;
  } else {
    result = 0;
  }

  console.log(result);
}

determine(x1);

console.log('-------가장 큰 값------');

// 가장 큰 값
const nums = [1, 2, 3, 4, 5];

maxNumber(nums);
function maxNumber(arr) {
  console.log(arr);
  let max = -Infinity;
  for (let i of arr) {
    if (i > max) {
      max = i;
    }
  }
  console.log(max);
  return max;
}
console.log('-------------가장 작은 값---------------');

minNumber(nums);
function minNumber(arr) {
  let min = Infinity;
  for (let index of arr) {
    if (index < min) {
      min = index;
    }
  }
  console.log(min);
}

// 짝수
console.log('-------------짝수---------------');

evenNumber(nums);
function evenNumber(arr) {
  console.log(arr);
  let new_arr = [];
  for (let index of arr) {
    if (index % 2 === 0) {
      new_arr.push(index);
    }
  }
  console.log(new_arr);
}
