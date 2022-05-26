package katas;


import com.google.common.collect.ImmutableMap;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        /*
         * Obtiene un map inmutable con los datos de la descripción.
         * return: [{id=70111470, title=Die Hard, box art url=http://cdn-0.nflximg.com/images/2891/DieHard150.jpg},
         * {id=654356453, title=Bad Boys, box art url=http://cdn-0.nflximg.com/images/2891/BadBoys150.jpg},
         * {id=65432445, title=The Chamber, box art url=http://cdn-0.nflximg.com/images/2891/TheChamber150.jpg},
         * {id=675465, title=Fracture, box art url=http://cdn-0.nflximg.com/images/2891/Fracture150.jpg}]
         */
        return movieLists.stream().flatMap(movies ->
                movies.getVideos().stream().map(videos ->
                        ImmutableMap.of(
                                "id", videos.getId(),
                                "title", videos.getTitle(),
                                "boxart", videos.getBoxarts().stream()
                                        .filter(boxArt -> boxArt.getWidth() == 150 && boxArt.getHeight() == 200)
                                        .findAny().get().getUrl()))
        ).collect(Collectors.toList());
    }
}
