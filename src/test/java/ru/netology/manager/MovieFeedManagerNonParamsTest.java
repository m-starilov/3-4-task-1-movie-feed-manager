package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieFeed;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieFeedManagerNonParamsTest {

    @Test
    public void shouldShowAllMovieFeed() {
        MovieFeedManager manager = new MovieFeedManager();

        MovieFeed first = new MovieFeed(1, "url1", "Movie 1", "Genre 1");
        MovieFeed second = new MovieFeed(2, "url2", "Movie 2", "Genre 2");
        MovieFeed third = new MovieFeed(3, "url3", "Movie 3", "Genre 3");

        manager.add(first);
        manager.add(second);
        manager.add(third);

        MovieFeed[] actual = manager.getAll();
        MovieFeed[] expected = new MovieFeed[]{third, second, first};

        assertArrayEquals(expected, actual);
    }
}
