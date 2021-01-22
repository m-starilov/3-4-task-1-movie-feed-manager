package ru.netology.repository;

import ru.netology.domain.MovieFeed;

public class MovieFeedRepository {
    private MovieFeed[] movies = new MovieFeed[0];

    public MovieFeed[] findAll() {
        return movies;
    }

    public void save(MovieFeed movie) {
        int length = movies.length + 1;
        MovieFeed[] tmp = new MovieFeed[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public MovieFeed findById(int id) {
        for (MovieFeed movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = movies.length - 1;
        MovieFeed[] tmp = new MovieFeed[length];
        int index = 0;
        for (MovieFeed movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
        }
        movies = tmp;
    }

    public void removeAll(){
        movies = new MovieFeed[]{};
    }
}

