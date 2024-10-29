var _ = require('lodash');

async function fetchDustInfo() {
  const URL =
    'https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty?serviceKey=%2BiEaRW7xrORUYANDjKPrnvW9DAAqDJNKv3E4sm3Vwbes8db4rFSa%2FTnEVPEmaCWv1BzeVE2ek9Fv8onYt9obpQ%3D%3D&returnType=json&numOfRows=30&pageNo=1&stationName=%EC%A2%85%EB%A1%9C%EA%B5%AC&dataTerm=MONTH&ver=1.0';
  const res = await fetch(URL);
  let data = await res.json();

  data = data.response.body.items;

  averageData = {};
  for (let datum of data) {
    // 날짜 - 시간으로 나누기
    let dataTime = datum.dataTime.split(' ')[0];
    let pm25Value = parseInt(datum.pm25Value);
    // averageData 날짜에 맞는 array가 있으면 push하고
    // 없으면 array 만들어주기
    if (Object.keys(averageData).includes(dataTime)) {
      averageData[dataTime].push(pm25Value);
    } else {
      averageData[dataTime] = [pm25Value];
    }
  }
  // 평균으로 바꿔주기
  for (let key in averageData) {
    let value = averageData[key];
    value = _.mean(value);
    averageData[key] = value;
  }
  console.log(averageData);
}

fetchDustInfo();
