// const baseURL = 'https://apis.data.go.kr/B552584/ArpltnStatsSvc';
// const params = new URLSearchParams({
//   serviceKey:
//     'sU2jtPOTQI1lNQtQwwNH5FR2Rf0+l/AX9M4/A+L7/K1HAxybD0BVOVtotamccTeMgbws24Zq1At5koZUypbw4g==',
//   returnType: 'json',
//   numOfRows: 100,
//   pageNo: 1,
//   sidoName: '%EC%84%9C%EC%9A%B8',
//   searchCondition: 'DAILY',
// });

async function getRegion() {
  // const path = '/getCtprvnMesureSidoLIst';
  // let URL = `${baseURL}${path}?${params}`;

  const URL =
    'https://apis.data.go.kr/B552584/ArpltnStatsSvc/getCtprvnMesureSidoLIst?serviceKey=sU2jtPOTQI1lNQtQwwNH5FR2Rf0%2Bl%2FAX9M4%2FA%2BL7%2FK1HAxybD0BVOVtotamccTeMgbws24Zq1At5koZUypbw4g%3D%3D&returnType=json&numOfRows=100&pageNo=1&sidoName=%EC%84%9C%EC%9A%B8&searchCondition=DAILY';

  const response = await fetch(URL);
  const data = await response.json();
  const items = data.response.body.items;

  for (let item of items) {
    console.log(item.sidoName);
  }

  return items;
}

async function minpm() {
  // const path = '/getCtprvnMesureSidoLIst';
  // let URL = `${baseURL}${path}?${params}`;

  // const URL =
  //   'https://apis.data.go.kr/B552584/ArpltnStatsSvc/getCtprvnMesureSidoLIst?serviceKey=sU2jtPOTQI1lNQtQwwNH5FR2Rf0%2Bl%2FAX9M4%2FA%2BL7%2FK1HAxybD0BVOVtotamccTeMgbws24Zq1At5koZUypbw4g%3D%3D&returnType=json&numOfRows=100&pageNo=1&sidoName=%EC%84%9C%EC%9A%B8&searchCondition=DAILY';

  // const response = await fetch(URL);
  // const data = await response.json();
  const items = await getRegion();

  let minpm = Infinity;
  for (let item of items) {
    // console.log(item.pm10Value);
    if (item.pm10Value < minpm) {
      minpm = item.pm10Value;
      console.log(minpm);
    }
  }
}
minpm();
/*
- 영화의 리스트를 입력받아서 vote_average가 가장 높은 영화를 반환한다.
*/
// function getPopularMovie(movies) {
//   const maxVoteMovie = movies.reduce((acc, cur) => {
//     const accVoteAverage = acc.vote_average;
//     const curVoteAverage = cur.vote_average;

//     if (accVoteAverage > curVoteAverage) {
//       return acc;
//     } else if (accVoteAverage < curVoteAverage) {
//       return cur;
//     }
//   });
//   return maxVoteMovie;
// }

// async function getDetailMovie(movieID) {
//   const path = `/${movieID}`;
//   const URL = `${baseURL}${path}?${params}`;

//   const response = await fetch(URL);
//   const data = await response.json();
//   console.log(data);
//   return data;
// }

// async function main() {
//   // 1. 현재 상영중인 영화를 가져온다.
//   const movies = await getNowPlayingMovies();
//   // 2. 영화 중 가장 평점이 높은 영화를 가져온다.
//   const movie = getPopularMovie(movies);
//   // 3. 그 영화의 detail한 정보를 가져온다.
//   const movieId = movie.id;
//   const detailMovie = await getDetailMovie(movieId);

//   console.log(detailMovie.revenue);
// }

// main();
