const numbers = [1, 2, 3, 4];

const evenNumbers = numbers.filter((num) => {
  return num % 2 === 0;
});

console.log(evenNumbers); // [2, 4]

const nums = [2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13];

// filter를 가지고 소수 만 모아보기

function checkPrime(num) {
  let isPrime = true;
  for (let i = 2; i < num; i++) {
    if (num % i === 0) {
      isPrime = false;
      return isPrime;
    }
  }

  return isPrime;
}

const primeNums = nums.filter((num) => checkPrime(num));
console.log(primeNums);
