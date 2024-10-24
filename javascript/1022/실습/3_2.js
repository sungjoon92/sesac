const arr = [1, 2, 4, 3, 3, 5, 5, 6, 9, 7];
//  일 때,원소가  1, 4, 5, 7인 경우를 제외하고 출력하세요

const notLog = [1, 4, 5, 7];

let num = 1;
// not log에 들어잇니?
// 들어있으면 출력하지 않겠어.

// 들어있지 않은 것을 체크하기 위해서는 모든 리스트를 뒤져봐야 함.
// 들어있는 경우를 체크하기 위해서는 (우연이든 어쨋든) 한번이면 충분함.
// 모든 경우를 돌면서 한번이라도 만나면 걔는 들어있는 것.
let isInNotLog = false;

// not log에 안들어있니
// 들어있지 않다면 출력하지 않겠어.

// let num = 2;
// not log에 들어잇니?
// 들어있으면 출력하지 않겠어.

// not log에 안들어있니?
// 들어있지 않다면 출력하지 않겠어.

// let num = 4;
// not log에 들어잇니?
// 들어있으면 출력하지 않겠어.

// not log에 안들어있니?
// 들어있지 않다면 출력하지 않겠어.

// let num = 5;
// not log에 들어잇니?
// 들어있으면 출력하지 않겠어.

// not log에 안들어있니?
// 들어있지 않다면 출력하지 않겠어.

for (let num of arr) {
  let isInNotLog = false;

  for (let notLogNum of notLog) {
    if (num === notLogNum) {
      isInNotLog = true;
      break;
    }
  }

  if (isInNotLog) continue;
  console.log(num);

  // if (!isInNotLog){
  //   console.log(num)
  // }
}
