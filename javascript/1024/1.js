console.log(this);

const person = {
  name: '철수',
  greet() {
    console.log(`안녕하세요. 저의 이름은 ${this.name} 입니다.`);
    // 안녕하세요. 저의 이름은 철수 입니다.
    // this는 객체 person을 참조한다.
  },
};

person.greet();

const test = [1, 2, 3, 4];

test.forEach(() => {});

const strNumbers = ['1', '2', '3', '4'];
let numNumbers = [];
// for (index of strNumbers) {
//   numNumbers.push(parseInt(index));
// }
// console.log(numNumbers);

const numbers = strNumbers.map((num) => {
  let int = parseInt(num);
  let numint = numNumbers.push(int);

  return numint;
});
console.log(numbers);
console.log(numNumbers);

numNumbers = [];
strNumbers.forEach((num) => {
  let int = parseInt(num);
  numNumbers.push(int);
});
console.log(numNumbers);
