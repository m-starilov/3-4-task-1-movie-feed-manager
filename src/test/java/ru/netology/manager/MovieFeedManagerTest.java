package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieFeed;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieFeedManagerTest {
    MovieFeedManager manager = new MovieFeedManager();
    private MovieFeed first = new MovieFeed(1, "url1", "Movie 1", "Genre 1");
    private MovieFeed second = new MovieFeed(2, "url2", "Movie 2", "Genre 2");
    private MovieFeed third = new MovieFeed(3, "url3", "Movie 3", "Genre 3");
    private MovieFeed fourth = new MovieFeed(4, "url4", "Movie 4", "Genre 4");
    private MovieFeed fifth = new MovieFeed(5, "url5", "Movie 5", "Genre 5");
    private MovieFeed sixth = new MovieFeed(6, "url6", "Movie 6", "Genre 6");
    private MovieFeed seventh = new MovieFeed(7, "url7", "Movie 7", "Genre 7");
    private MovieFeed eighth = new MovieFeed(8, "url8", "Movie 8", "Genre 8");
    private MovieFeed ninth = new MovieFeed(9, "url9", "Movie 9", "Genre 9");
    private MovieFeed tenth = new MovieFeed(10, "url10", "Movie 10", "Genre 10");
    private MovieFeed eleventh = new MovieFeed(11, "url11", "Movie 11", "Genre 11");

    @Test
    public void shouldShowNoneFromTen() {
        MovieFeed[] actual = manager.getAll();
        MovieFeed[] expected = new MovieFeed[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowOneFromTen() {
        manager.add(first);

        MovieFeed[] actual = manager.getAll();
        MovieFeed[] expected = new MovieFeed[]{first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowThreeFromTen() {
        manager.add(first);
        manager.add(second);
        manager.add(third);

        MovieFeed[] actual = manager.getAll();
        MovieFeed[] expected = new MovieFeed[]{third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowTenFromTen() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        MovieFeed[] actual = manager.getAll();
        MovieFeed[] expected = new MovieFeed[]{tenth, ninth, eighth, seventh, sixth, fifth,fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowTenFromEleven() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        MovieFeed[] actual = manager.getAll();
        MovieFeed[] expected = new MovieFeed[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth,fourth, third, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowNoneFromFive() {
        MovieFeedManager manager = new MovieFeedManager(5);

        MovieFeed[] actual = manager.getAll();
        MovieFeed[] expected = new MovieFeed[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowOneFromFive() {
        MovieFeedManager manager = new MovieFeedManager(5);

        manager.add(first);

        MovieFeed[] actual = manager.getAll();
        MovieFeed[] expected = new MovieFeed[]{first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowThreeFromFive() {
        MovieFeedManager manager = new MovieFeedManager(5);

        manager.add(first);
        manager.add(second);
        manager.add(third);

        MovieFeed[] actual = manager.getAll();
        MovieFeed[] expected = new MovieFeed[]{third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowFiveFromFive() {
        MovieFeedManager manager = new MovieFeedManager(5);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        MovieFeed[] actual = manager.getAll();
        MovieFeed[] expected = new MovieFeed[]{fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowFiveFromNine() {
        MovieFeedManager manager = new MovieFeedManager(5);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);

        MovieFeed[] actual = manager.getAll();
        MovieFeed[] expected = new MovieFeed[]{ninth, eighth, seventh, sixth, fifth};

        assertArrayEquals(expected, actual);
    }
}
