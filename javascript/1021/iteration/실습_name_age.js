const names = ['jun', 'beemo', 'ken'];
const ages = [18, 28, 37];
//
// 18살 jun
// 28살 beemo
// 37살 ken
// 을 출력하시오.

// ages[0]살 names[0]
// ages[1]살 names[1]
// ages[2]살 names[2]

for (let index in names){
  let age = ages[index]
  let name = names[index]

  console.log(`${age}살 ${name}`)
}