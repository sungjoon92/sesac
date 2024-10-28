async function getNowPlayingMovies() {
  try {
    const baseURL = 'https://api.themoviedb.org/3/movie';
    const path = '/now_playing';
    const params = new URLSearchParams({
      api_key: 'eab8c9893e725b2e167187cef66bae3d',
      language: 'ko',
    });

    let URL = `${baseURL}${path}?${params}`;

    const response = await fetch(URL);
    const data = await response.json();

    const movies = data.results;

    const maxVoteMovie = movies.reduce((acc, cur) => {
      const accVoteAverage = acc.vote_average;
      const curVoteAverage = cur.vote_average;

      if (accVoteAverage > curVoteAverage) {
        return acc;
      } else if (accVoteAverage < curVoteAverage) {
        return cur;
      }
    });
    const movieId = maxVoteMovie.id;
    console.log(movieId);

    URL = `${baseURL}/${movieId}?${params}`;

    const response2 = await fetch(URL);
    const data2 = await response2.json();
    console.log(data2);
    const revenue = data2.revenue;

    console.log(revenue);
    // ///////////////////////////
  } catch (error) {
    console.error('Error:', error);
  }
}

getNowPlayingMovies();
