package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.MovieFeed;
import ru.netology.repository.MovieFeedRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MovieFeedManagerTest {
    @Mock
    private MovieFeedRepository repository;
    @InjectMocks
    private MovieFeedManager manager;
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
        MovieFeed[] returned = new MovieFeed[]{};
        doReturn(returned).when(repository).findAll();

        MovieFeed[] actual = manager.getAll();
        MovieFeed[] expected = new MovieFeed[]{};

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldShowOneFromTen() {
        MovieFeed[] returned = new MovieFeed[]{first};
        doReturn(returned).when(repository).findAll();

        MovieFeed[] actual = manager.getAll();
        MovieFeed[] expected = new MovieFeed[]{first};

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldShowThreeFromTen() {
        MovieFeed[] returned = new MovieFeed[]{first, second, third};
        doReturn(returned).when(repository).findAll();

        MovieFeed[] actual = manager.getAll();
        MovieFeed[] expected = new MovieFeed[]{third, second, first};

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldShowTenFromTen() {
        MovieFeed[] returned = new MovieFeed[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();

        MovieFeed[] actual = manager.getAll();
        MovieFeed[] expected = new MovieFeed[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldShowTenFromEleven() {
        MovieFeed[] returned = new MovieFeed[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        doReturn(returned).when(repository).findAll();

        MovieFeed[] actual = manager.getAll();
        MovieFeed[] expected = new MovieFeed[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth,fourth, third, second};

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldShowNoneFromFive() {
        manager.setFeedLength(5);
        MovieFeed[] returned = new MovieFeed[]{};
        doReturn(returned).when(repository).findAll();

        MovieFeed[] actual = manager.getAll();
        MovieFeed[] expected = new MovieFeed[]{};

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldShowOneFromFive() {
        manager.setFeedLength(5);
        MovieFeed[] returned = new MovieFeed[]{first};
        doReturn(returned).when(repository).findAll();

        MovieFeed[] actual = manager.getAll();
        MovieFeed[] expected = new MovieFeed[]{first};

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldShowThreeFromFive() {
        manager.setFeedLength(5);
        MovieFeed[] returned = new MovieFeed[]{first, second, third};
        doReturn(returned).when(repository).findAll();

        MovieFeed[] actual = manager.getAll();
        MovieFeed[] expected = new MovieFeed[]{third, second, first};

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldShowFiveFromFive() {
        manager.setFeedLength(5);
        MovieFeed[] returned = new MovieFeed[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();

        MovieFeed[] actual = manager.getAll();
        MovieFeed[] expected = new MovieFeed[]{fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    public void shouldShowFiveFromNine() {
        manager.setFeedLength(5);
        MovieFeed[] returned = new MovieFeed[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth};
        doReturn(returned).when(repository).findAll();

        MovieFeed[] actual = manager.getAll();
        MovieFeed[] expected = new MovieFeed[]{ninth, eighth, seventh, sixth, fifth};

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }
}
