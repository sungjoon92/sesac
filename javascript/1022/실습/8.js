const jun = {
  name: 'jun',
  age: 15,
  gender: 'M',
};

jun['name'];
jun.name;

// 주어진 테이블의 데이터를 "people" 변수에 저장하시오.
let people = [
  {
    name: 'jun',
    age: 15,
    gender: 'M',
  },
  {
    name: 'ken',
    age: 36,
    gender: 'F',
  },
  {
    name: 'alex',
    age: 37,
    gender: null,
  },
];
// 사람에 대한 정보를 각각 출력하시오(형식은 자유롭게)
for (let person of people) {
  // console.log(person);
  for (let key in person) {
    let value = person[key];
    console.log(key, value);
  }
  console.log();
}

console.log();
// 이름이 alex인 사람에 대한 정보를 출력하시오
// 전체 사람에 대해 한사람씩 확인을 합니다.
for (let person of people) {
  // 그사람 'alex'인지 확인합니다.
  // 그사람의 이름이 alex인지를 확인합니다.
  const name = person.name;
  if (name === 'alex') {
    console.log(person);
  }
}

// 이름이 alex인 사람의 나이를 출력하시오
console.log();

for (let person of people) {
  const name = person.name;
  if (name === 'alex') {
    const age = person.age;
    console.log(age);
  }
}

// 이름을 활용하여 각 사람의 데이터에 쉽게 접근할 수 있도록 people 변수를 수정하시오.

people = {
  jun: {
    name: 'jun',
    age: 15,
    gender: 'M',
  },
  ken: {
    name: 'ken',
    age: 36,
    gender: 'F',
  },
  alex: {
    name: 'alex',
    age: 37,
    gender: null,
  },
};

people.jun
