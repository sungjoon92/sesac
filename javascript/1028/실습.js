// 현재 상영 중인 영화 목록을 가져오는 비동기 함수 정의
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

      // movieList 변수에 <li></li>태그 넣을준비
      const movieList = document.createElement('li');
      // movieLink 변수에 <a></a>태그 넣을준비
      const movieLink = document.createElement('a');
      // movieImage 변수에 <img></img>태그 넣을준비
      const movieImage = document.createElement('img');

      // movieBox자식요소로 movieList(<li></li>)넣기
      movieBox.appendChild(movieList);
      // movieList자식요소로 movieImage(<a></a>)넣기
      movieList.appendChild(movieLink);
      // movieList자식요소로 movieImage(<img></img>)넣기
      movieLink.appendChild(movieImage);
      movieLink.href = movieImg;
      // 이미지 요소에 src 속성을 설정하여 해당 영화의 배경 이미지가 표시되도록 함
      movieImage.setAttribute(
        'src',
        `https://image.tmdb.org/t/p/w500${movieImg}`
      );

      // movieImage.src = `https://image.tmdb.org/t/p/w500${movieImg}`
    }
  } catch (error) {
    console.error('Error:', error);
  }
}

getNowPlayingMovies();
