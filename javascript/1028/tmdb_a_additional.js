async function getNowPlayingMovies() {
  try {
    const baseURL = 'https://api.themoviedb.org/3/movie';
    const path = '/now_playing';
    const params = new URLSearchParams({
      api_key: '3b7e5eb620d6d28a0a820a15350f2989',
      language: 'ko',
    });

    const URL = `${baseURL}${path}?${params}`;

    const response = await fetch(URL);
    const data = await response.json();

    const movies = data.results;
    const my_movie = {
      title: 'sesac the movie',

      vote_average: 10.0,
      vote_count: 1,
    };

    movies.push(my_movie);

    let maxVoteAverage = 0;
    let maxVoteMovie = null;
    let minVoteCount = 100;

    for (let movie of movies) {
      let voteAverage = movie.vote_average;
      let voteCount = movie.vote_count;

      if (voteCount < minVoteCount) continue;

      if (voteAverage > maxVoteAverage) {
        maxVoteAverage = voteAverage;
        maxVoteMovie = movie;
      }
      // if (voteAverage > maxVoteAverage) {
      //   if (voteCount < minVoteCount) continue;
      //   maxVoteAverage = voteAverage;
      //   maxVoteMovie = movie;
      // }
      // if (voteAverage > maxVoteAverage && voteCount > minVoteCount) {
      //   maxVoteAverage = voteAverage;
      //   maxVoteMovie = movie;
      // }
      // if (voteAverage > maxVoteAverage) {
      //   if (voteCount > minVoteCount){
      //     maxVoteAverage = voteAverage;
      //     maxVoteMovie = movie;
      //   }
      // }
    }

    console.log(maxVoteAverage);
    console.log(maxVoteMovie.title);
  } catch (error) {
    console.error('Error:', error);
  }
}

getNowPlayingMovies();
