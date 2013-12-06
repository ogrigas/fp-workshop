package movies

import movies.oop.MovieLibrary
import org.junit.Test

class MovieLibraryTest {

    private MovieLibrary library = new MovieLibrary(
        new Movie("Spartacus",         1960, new Director("Stanley Kubrick", 1928), 9),
        new Movie("The Shining",       1980, new Director("Stanley Kubrick", 1928), 9),
        new Movie("Full Metal Jacket", 1987, new Director("Stanley Kubrick", 1928), 8),

        new Movie("Mortal Combat",     1995, new Director("Paul Anderson", 1965),   6),
        new Movie("Event Horizon",     1997, new Director("Paul Anderson", 1965),   4),

        new Movie("BloodRayne",        2005, new Director("Uwe Boll", 1965),        1),
        new Movie("Postal",            2007, new Director("Uwe Boll", 1965),        2),

        new Movie("Boogie Nights",     1997, new Director("Paul Anderson", 1970),  10),
        new Movie("Magnolia",          1999, new Director("Paul Anderson", 1970),   9),
        new Movie("The Master",        2012, new Director("Paul Anderson", 1970),   8));

    @Test
    public void findsMoviesByDirector() {
        assert library.directedBy(new Director("Paul Anderson", 1970)).titles() ==
               ["Boogie Nights", "Magnolia", "The Master"] as Set

        assert library.directedBy(new Director("Paul Anderson", 1965)).titles() ==
               ["Mortal Combat", "Event Horizon", "Resident Evil"] as Set
    }

    @Test
    public void findsDirectorsOfThe90ies() {
        assert library.releasedAfter(1990).releasedBefore(2000).directors() ==
               [new Director("Paul Anderson", 1965), new Director("Paul Anderson", 1970)] as Set
    }

    @Test
    public void findsHighestAndLowestRatedMovies() {
        assert library.highestRated().title == "Boogie Nights"
        assert library.lowestRated().title == "BloodRayne"

        assert library.directedBy(new Director("Uwe Boll", 1965)).highestRated().rating == 2
    }

    @Test
    public void calculatesAverageRating() {
        assert library.directedBy(new Director("Paul Anderson", 1970)).averageRating() == 9

        assert library.releasedAfter(2000).averageRating() == 9
    }
}
