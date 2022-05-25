package katas;

import model.MovieList;
import util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        String variable = movieLists.stream().map(videos -> videos.getVideos().stream().map(
                                boxart -> boxart.getBoxarts().stream().reduce((acumulated, element) ->
                                        acumulated.getWidth() > element.getWidth() ? acumulated : element).get())
                        .reduce((acumulated, element) -> acumulated.getHeight() > element.getHeight() ? acumulated : element).get())
                .reduce((acumulated, element) -> acumulated.getWidth() > element.getWidth() ? acumulated : element).get().getUrl();

        return variable;
    }
}
