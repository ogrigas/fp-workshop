package movies.fp;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import movies.Director;
import movies.Movie;

public final class MovieFunctions {

    private MovieFunctions() {}

    public static final Function<Movie, String> MOVIE_TITLE = null; // TODO

    public static final Function<Movie, Integer> MOVIE_YEAR = null; // TODO

    public static final Function<Movie, Director> MOVIE_DIRECTOR = null; // TODO

    public Predicate<Movie> directedBy(Director director) {
        return null; // TODO
    }

    public Predicate<Movie> releasedAfter(int year) {
        return null; // TODO
    }

    public Predicate<Movie> releasedBefore(int year) {
        return null; // TODO
    }

}
