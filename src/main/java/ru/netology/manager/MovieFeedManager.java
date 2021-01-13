package ru.netology.manager;

import ru.netology.domain.MovieFeed;

public class MovieFeedManager {

  private MovieFeed[] movies = new MovieFeed[0];
  private int feedLength = 10;

  public MovieFeedManager() {
  }

  public MovieFeedManager(int feedLength) {
    this.feedLength = feedLength;
  }

  public void add(MovieFeed movie) {
    int length = movies.length + 1;
    MovieFeed[] tmp = new MovieFeed[length];
    System.arraycopy(movies, 0, tmp, 0, movies.length);
    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = movie;
    movies = tmp;
  }

  public MovieFeed[] getAll() {
    if (movies.length < feedLength) {
      MovieFeed[] result = new MovieFeed[movies.length];
      for (int i = 0; i < movies.length; i++) {
        int index = movies.length - i - 1;
        result[i] = movies[index];
      }
      return result;
    } else {
      MovieFeed[] result = new MovieFeed[feedLength];
      for (int i = 0; i < feedLength; i++) {
        int index = movies.length - i - 1;
        result[i] = movies[index];
      }
      return result;
    }
  }
}

