let money = 10000;

if (money > 1000) {
  console.log('나 돈 많아');
} else {
  console.log('나 거지야');
}

let ondo = 20;
if (ondo < 22) {
  console.log('보일러 틀어');
} else {
  console.log('에어컨 틀어');
}

if (money > 10000) {
  console.log('치킨'); 
} else if (money > 5000) {
  console.log('라면');
} else if (money > 1000) {
  console.log('과자');
} else if (money > 100) {
  console.log('추파춥스');
} else {
  console.log('돈좀 주세요');
}

if (money > 10000) {
  console.log('치킨');
  if (money > 5000) {
    console.log('라면');
  }
}
