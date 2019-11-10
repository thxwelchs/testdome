import java.util.*;
import java.text.SimpleDateFormat;

/**
 * 영화를 겹치지 않게 모두 볼 수 있는지 체크
 */
public class MovieNight {
    public static Boolean canViewAll(Collection<Movie> movies) {
        List<Movie> movieList = (List<Movie>) movies;

        if(movieList.size() == 1) return true;

        movieList.sort(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getStart().compareTo(o2.getStart());
            }
        });

        Movie currentShow = movieList.get(0);

        for (Movie nextMovie : movieList) {
            if(!canViewNext(currentShow, nextMovie ))
            {
                return false;
            }

            currentShow = nextMovie;

        }

        return true;
    }

    public static boolean canViewNext(Movie current, Movie next)
    {
        return next.getStart().compareTo(current.getEnd()) > 0;
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");

        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(sdf.parse("2015-01-01 20:00"), sdf.parse("2015-01-01 21:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 23:10"), sdf.parse("2015-01-01 23:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 21:30"), sdf.parse("2015-01-01 23:00")));

        System.out.println(MovieNight.canViewAll(movies));
    }
}

class Movie {
    private Date start, end;

    public Movie(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return this.start;
    }

    public Date getEnd() {
        return this.end;
    }
}