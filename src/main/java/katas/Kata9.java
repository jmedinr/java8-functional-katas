package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.MovieList;
import util.DataUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream().flatMap(movies ->
                movies.getVideos().stream().map(videos ->
                        ImmutableMap.of("id", videos.getId(), "title", videos.getTitle(),
                                " middle interesting moment time",
                                videos.getInterestingMoments().stream()
                                        .filter(moment -> moment.getType().equals("Middle")).findAny().get().getTime(),
                                "box art",
                                videos.getBoxarts().stream()
                                        .reduce((acumulated, element) ->
                                                acumulated.getWidth() < element.getWidth() ? acumulated : element).get().getUrl())
                )).collect(Collectors.toList());
    }
}
