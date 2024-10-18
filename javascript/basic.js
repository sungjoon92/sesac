const name = '원성준';
const age = 18;
const str_age = '20';
let number = 10;
console.log(`string 값 안에 변수를 쓰려면 ${name + age + str_age} 백틱`);
console.log(age + str_age);

document.addEventListener('DOMContentLoaded', function () {
  document.querySelector('.javascript').innerHTML =
    '이름' + name + ' 나이 ' + age + 'string나이' + str_age;
});

console.log(number++);
console.log(++number);
console.log(number++);
console.log(number);
console.log(number >= 5);
console.log(number == 5);

console.log(1 <= undefined <= 5); /* true */
/* 
console.log(1 <= undefined <= 5);가 true인 이유는
자바스크립트에서 비교 연산자가 true인 이유는 자바스크립트에서 비교 연산자가 
왼쪽에서 오른쪽으로 평가되기 때문입니다. 이 식은 두 개의 연산으로 나누어집니다:

첫 번째 비교: 1 <= undefined
두 번째 비교: 그 결과와 5의 비교
1. 1 <= undefined
자바스크립트에서 비교 연산 시, undefined는 숫자로 변환됩니다. 이때 undefined는 NaN(Not-a-Number)로 변환됩니다.

javascript
코드 복사
1 <= NaN
NaN은 어떤 값과도 크기 비교가 불가능하며, 모든 비교 연산에서 false를 반환합니다. 즉, 1 <= NaN은 false입니다.

2. false <= 5
첫 번째 비교의 결과는 false입니다. 자바스크립트에서는 false가 숫자로 변환될 때 0으로 변환됩니다. 그러므로 두 번째 비교는:

javascript
코드 복사
0 <= 5
이 연산은 true입니다. */

let money = 100;
let hungry = 100;
/* 돈이 1000원보다 많으면 true */
console.log(money > 1000);
/* 배고픔이 50 보다 많으면 true */
console.log(hungry > 50);
/* 돈이 100원보다 많고 배고픔이 100보다 많으면 true */
console.log(money > 100 && hungry > 100);
/* 돈이 100원보 이상이거나 배고픔이 100보다 많으면 true */
console.log(money >= 100 || hungry > 100);
/* 돈이 200원 이상이 아니면  true */
console.log(!(money >= 200));

/* !money = false, 200은 1이상이기에 true  true와 false는 같지 않기에 false */
console.log(!money >= 200);
/* console.log(false > 200); 과 같은 결과 노출 */

/* !숫자값은 = 숫자값을 Truthy 값으로 변경되기에 1이상은 전부 true  */
/* !연산자로인해 그값을 false로 변경 */
console.log(!money >= !200);

/* false 와 false 는 같거나 이상이 붙어있기에 답은 true */
console.log(!true >= !true);

/* boolean값끼리는 ==제외 초과 값은 불가능하기에 false */
console.log(false > false);
