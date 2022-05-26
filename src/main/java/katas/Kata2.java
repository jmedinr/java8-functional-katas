package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Chain filter() and map() to collect the ids of videos that have a rating of 5.0
    DataSource: DataUtil.getMovies()
    Output: List of Integers
*/
public class Kata2 {
    public static List<Integer> execute() {
        List<Movie> movies = DataUtil.getMovies();

        /*
         * Devuelve una lista con los Ids de las películas que tienen Rating >= 5
         * return: [654356453, 675465]
         */
        List<Integer> variable = movies.stream().filter(movie ->
                movie.getRating() == 5.0).map(movie -> movie.getId()).collect(Collectors.toList());

        return variable;
    }
}
