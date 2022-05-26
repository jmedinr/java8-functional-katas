package katas;

import com.google.common.collect.ImmutableMap;
import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: use map() to project an array of videos into an array of {id, title}-pairs
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys")
*/
public class Kata1 {
    public static List<Map> execute() {
        List<Movie> movies = DataUtil.getMovies();

        /*
         * Retorna las películas en un map inmutable con el id y el tittle.
         * return: [{id=70111470, title=Die Hard}, {id=654356453, title=Bad Boys}, {id=65432445, title=The Chamber},
         * {id=675465, title=Fracture}]
         */
        return movies.stream().map(movie ->
                        ImmutableMap.of("id", movie.getId(), "title", movie.getTitle()))
                .collect(Collectors.toList());
    }
}
