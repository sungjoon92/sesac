// const person = {
//   name: '철수',
//   greet() {
//     console.log(`안녕하세요. 저의 이름은 ${this.name} 입니다.`);
//     // 안녕하세요. 저의 이름은 철수 입니다.
//     // this는 객체 person을 참조한다.
//   },
// };

// person.greet();

function greet() {
  console.log(`안녕하세요. 저의 이름은 ${this.name} 입니다.`);
}

const boy = {
  name: '철수',
  greet_boy: greet,
};

const girl = {
  name: '영희',
  greet_girl: greet,
};

boy.greet_boy();
girl.greet_girl();

// const person = {
//   name: '철수',
//   greet: () => {
//     console.log(`안녕하세요. 저의 이름은 ${this.name} 입니다.`);
//     // 화살표 함수의 this는 상위 컨텍스트의 this를 참조하므로 undefined이 출력된다.
//     // 이 코드에서는 전역 컨텍스트 this를 참조한다.
//   },
// };

// person.greet(); // 안녕하세요. 저의 이름은 undefined 입니다.

// const person = {
//   name: '철수',
//   greet() {
//     sayHi = () => {
//       console.log(`안녕하세요. 저의 이름은 ${this.name} 입니다.`);
//     };
//     sayHi();
//   },
// };

// person.greet(); // 안녕하세요. 저의 이름은 undefined 입니다.

const person = {
  name: 'John',
  friends: ['Jane', 'Mike'],

  printFriends_wrong() {
    this.friends.forEach(function (friend) {
      console.log(this.name + ' knows ' + friend); // this는 window
    });
  },

  printFriends_right() {
    this.friends.forEach((friend) => {
      console.log(this.name + ' knows ' + friend); // 정상 작동
    });
  },
};

person.printFriends_wrong();
person.printFriends_right();
