package katas;

import com.google.common.collect.ImmutableMap;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        //Retorna un map inmutable con los datos de la descripción del problema
        /*
         * return: [{id=70111470, title=Die Hard, box art url=http://cdn-0.nflximg.com/images/2891/DieHard150.jpg},
         * {id=654356453, title=Bad Boys, box art url=http://cdn-0.nflximg.com/images/2891/BadBoys150.jpg},
         * {id=65432445, title=The Chamber, box art url=http://cdn-0.nflximg.com/images/2891/TheChamber150.jpg},
         * {id=675465, title=Fracture, box art url=http://cdn-0.nflximg.com/images/2891/Fracture150.jpg}]>
         */
        return movieLists.stream().flatMap(movie -> movie.getVideos().stream().map(video -> ImmutableMap.of(
                        "id", video.getId(),
                        "title", video.getTitle(),
                        "box art url",
                        video.getBoxarts().stream()
                                .reduce((acumulated, element) ->
                                        acumulated.getWidth() < element.getWidth() ? acumulated : element).get().getUrl())))
                .collect(Collectors.toList());
    }
}
