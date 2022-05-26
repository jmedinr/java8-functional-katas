package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5 {
    public static Double execute() {
        List<Movie> movies = DataUtil.getMovies();

        //Retorna el Rating más alto = 5.0
        Double variable = movies.stream()
                .reduce((acomulated, element) -> acomulated.getRating() > element.getRating() ? acomulated : element)
                .get().getRating();

        return variable;
    }
}
