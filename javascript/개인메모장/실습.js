// 현재 상영 중인 영화 목록을 가져오는 비동기 함수 정의
// https://api.themoviedb.org/3/movie/now_playing?api_key=3b7e5eb620d6d28a0a820a15350f2989&language=ko
async function getNowPlayingMovies() {
  try {
    // API의 기본 URL과 경로 설정
    const baseURL = 'https://api.themoviedb.org/3/movie';
    const path = '/now_playing';

    // URLSearchParams 객체를 이용해 요청에 필요한 쿼리 매개변수 설정
    const params = new URLSearchParams({
      api_key: '3b7e5eb620d6d28a0a820a15350f2989',
      language: 'ko',
    });

    // 완성된 API 요청 URL 생성
    const URL = `${baseURL}${path}?${params}`;

    // fetch를 이용해 API 요청 보내고 응답을 JSON 형태로 파싱
    const response = await fetch(URL);
    const data = await response.json();

    // 응답 데이터에서 영화 목록을 가져옴
    const movies = data.results;

    // 영화 목록을 추가할 .movie-list 요소를 선택
    const movieBox = document.querySelector('.movie-box');

    // 기존 영화 목록을 초기화 (기존 요소가 남아있지 않도록 하기 위함)
    movieBox.innerHTML = '';

    // 각 영화 정보를 반복문으로 순회
    for (let movie of movies) {
      // 각 영화의 배경 이미지 경로를 변수에 저장
      const movieImg = movie.backdrop_path;
      // 각 영화의 제목을 변수에 저장
      const movieTitle = movie.title;
      // 각 영화의 평점을 변수에 저장
      const popularity = movie.popularity;
      let maxpopularity = popularity;
      console.log(maxpopularity);

      // movieList 변수에 <li></li>태그 넣을준비
      const movieList = document.createElement('li');
      // movieRank 변수에 <h3></h3>태그 넣을준비
      const movieRank = document.createElement('h3');
      // movieLink 변수에 <a></a>태그 넣을준비
      const movieLink = document.createElement('a');
      // span 변수에 <span></span>태그 넣을준비
      const span = document.createElement('span');
      // movieImage 변수에 <img></img>태그 넣을준비
      const movieImage = document.createElement('img');

      // movieBox자식요소로 movieList(<li></li>)넣기
      movieBox.appendChild(movieList);
      // movieList자식요소로 movieImage(h3></h3>)을 넣으면서 태그안에 API에서 뽑아온 평점출력
      movieList.appendChild(movieRank).innerText = '평점: ' + maxpopularity;
      // movieList자식요소로 movieImage(<a></a>)넣기
      movieList.appendChild(movieLink);
      // movieLink자식요소로 movieImage(<img></img>)넣기
      movieLink.appendChild(movieImage);
      // movieList자식요소로 movieImage(<span></span>)을 넣으면서 태그안에 API에서 뽑아온 title넣기
      movieLink.appendChild(span).innerText = movieTitle;

      // a태그의 href속성 안에 api에서 뽑아온 이미지 넣기
      (movieLink.href = `https://image.tmdb.org/t/p/w500/${movieImg}`),
        (target = '_blank');
      // console.log(movieLink);

      // const div = document.createElement('div')
      // div.innerHTML = `<li><a href="${}" target="_blank"><img src="https://image.tmdb.org/t/p/w500/xlkclSE4aq7r3JsFIJRgs21zUew.jpg"><span>테리파이어 3</span></a></li>`

      // https://image.tmdb.org/t/p/w500/kX9gzHyfwXCkTszBcPekQZxPnzP.jpg
      // https://image.tmdb.org/t/p/original/wwemzKWzjKYJFfCeiB57q3r4Bcm.svg
      // https://image.tmdb.org/t/p/original/wwemzKWzjKYJFfCeiB57q3r4Bcm.png
      // https://image.tmdb.org/t/p/w500/wwemzKWzjKYJFfCeiB57q3r4Bcm.png
      // 이미지 요소에 src 속성을 설정하여 해당 영화의 배경 이미지가 표시되도록 함
      movieImage.setAttribute(
        'src',
        `https://image.tmdb.org/t/p/w500${movieImg}`
      );
    } // for end
  } catch (error) {
    console.error('Error:', error);
  }
}

getNowPlayingMovies();

// 배열을 정렬해서
// 2의 점수와 2, 3,4,5,6,7,8,
// 정렬된 배열에서 꺼내야됨
