function filterNetworkError(data) {
  const result = data.filter((el) => {
    if (el.pm25Flag === '통신장애') return false;

    return true;
  });
  return result;
}

async function fetchDustInfo() {
  const URL =
    'https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKey=%2BiEaRW7xrORUYANDjKPrnvW9DAAqDJNKv3E4sm3Vwbes8db4rFSa%2FTnEVPEmaCWv1BzeVE2ek9Fv8onYt9obpQ%3D%3D&returnType=json&numOfRows=100&pageNo=1&sidoName=%EC%84%9C%EC%9A%B8&ver=1.0';
  const res = await fetch(URL);
  let data = await res.json();

  data = data.response.body.items;

  // 통신장애 데이터를 거르고 싶다.
  data = filterNetworkError(data);

  let minPm25Value = Infinity;
  let minPm25StationName = '';

  for (let datum of data) {
    const pm25Value = parseInt(datum.pm25Value);

    // console.log(pm25Value);
    if (pm25Value < minPm25Value) {
      minPm25Value = pm25Value;
      minPm25StationName = datum.stationName;
    }
  }
  console.log(minPm25Value);
  console.log(minPm25StationName);
}

fetchDustInfo();
