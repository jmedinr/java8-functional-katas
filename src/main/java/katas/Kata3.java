package katas;

import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Use map() and flatMap() to project and flatten the movieLists into an array of video ids (flatMap(c -> c.stream()))
    DataSource: DataUtil.getMovieLists()
    Output: List of Integers
*/
public class Kata3 {
    public static List<Integer> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        /*
         * Realiza in flatten de las películas ids con los ids de videos
         * return: <[70111470, 654356453, 65432445, 675465]>
         */
        List<Integer> variable = movieLists.stream().flatMap(movies -> movies.getVideos().stream())
                .map(videos -> videos.getId()).collect(Collectors.toList());

        return variable;
    }
}
