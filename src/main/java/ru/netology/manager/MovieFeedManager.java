package ru.netology.manager;

import ru.netology.domain.MovieFeed;
import ru.netology.repository.MovieFeedRepository;

public class MovieFeedManager {

    private MovieFeedRepository repository;
    private int feedLength = 10;

    public MovieFeedManager(MovieFeedRepository repository) {
        this.repository = repository;
    }
    public int getFeedLength() {
        return feedLength;
    }

    public void setFeedLength(int feedLength) {
        this.feedLength = feedLength;
    }

    public void add(MovieFeed movie) {
        repository.save(movie);
    }

    public MovieFeed[] getAll() {
        MovieFeed[] movies = repository.findAll();
        if (movies.length < feedLength) {
            feedLength = movies.length;
        }
        MovieFeed[] result = new MovieFeed[feedLength];
        for (int i = 0; i < feedLength; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}