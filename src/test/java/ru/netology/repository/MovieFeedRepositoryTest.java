package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieFeed;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieFeedRepositoryTest {
    MovieFeedRepository repository = new MovieFeedRepository();
    private MovieFeed first = new MovieFeed(1, "url1", "Movie 1", "Genre 1");
    private MovieFeed second = new MovieFeed(2, "url2", "Movie 2", "Genre 2");
    private MovieFeed third = new MovieFeed(3, "url3", "Movie 3", "Genre 3");

    @Test
    public void shouldShowNoneFromZero() {
        MovieFeed[] actual = repository.findAll();
        MovieFeed[] expected = new MovieFeed[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowOneFromOne() {
        repository.save(first);

        MovieFeed[] actual = repository.findAll();
        MovieFeed[] expected = new MovieFeed[]{first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowThreeFromThree() {
        repository.save(first);
        repository.save(second);
        repository.save(third);

        MovieFeed[] actual = repository.findAll();
        MovieFeed[] expected = new MovieFeed[]{first, second, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByIdFromZero() {

        MovieFeed[] actual = new MovieFeed[]{repository.findById(1)};
        MovieFeed[] expected = new MovieFeed[]{null};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdFromOne() {
        repository.save(first);

        MovieFeed[] actual = new MovieFeed[]{repository.findById(1)};
        MovieFeed[] expected = new MovieFeed[]{first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdFromThree() {
        repository.save(first);
        repository.save(second);
        repository.save(third);

        MovieFeed[] actual = new MovieFeed[]{repository.findById(3)};
        MovieFeed[] expected = new MovieFeed[]{third};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByFalseIdFromZero() {

        MovieFeed[] actual = new MovieFeed[]{repository.findById(0)};
        MovieFeed[] expected = new MovieFeed[]{null};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByFalseIdFromOne() {
        repository.save(first);

        MovieFeed[] actual = new MovieFeed[]{repository.findById(0)};
        MovieFeed[] expected = new MovieFeed[]{null};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByFalseIdFromThree() {
        repository.save(first);
        repository.save(second);
        repository.save(third);

        MovieFeed[] actual = new MovieFeed[]{repository.findById(0)};
        MovieFeed[] expected = new MovieFeed[]{null};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdFromOne() {
        repository.save(first);

        repository.removeById(1);
        MovieFeed[] actual = repository.findAll();
        MovieFeed[] expected = new MovieFeed[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdFromThree() {
        repository.save(first);
        repository.save(second);
        repository.save(third);

        repository.removeById(1);
        MovieFeed[] actual = repository.findAll();
        MovieFeed[] expected = new MovieFeed[]{second, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        repository.save(first);
        repository.save(second);
        repository.save(third);

        repository.removeAll();
        MovieFeed[] actual = repository.findAll();
        MovieFeed[] expected = new MovieFeed[]{};

        assertArrayEquals(expected, actual);
    }
}
