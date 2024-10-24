const arr = [1, 2, 4, 3, 3, 5, 5, 6, 9, 7];
//  일 때,원소가  1, 4, 5, 7인 경우를 제외하고 출력하세요

for (let num of arr) {
  if (num === 1 || num === 4 || num === 5 || num === 7) {
    continue;
  }
  console.log(num);
}

// const arr = [1, 2, 4, 3, 3, 5, 5, 6, 9, 7];
// const notLog = [1, 4, 5, 7]
const notLogSet = new Set([1, 4, 5, 7]);

for (let num of arr) {
  // if (num set에 들어있어?) continue
  if (notLogSet.has(num)) continue;

  console.log(num);
}
