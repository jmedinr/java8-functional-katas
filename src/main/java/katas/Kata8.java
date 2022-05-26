package katas;

import com.codepoetics.protonpack.StreamUtils;
import model.Bookmark;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    Goal: Combine videos and bookmarks by index (StreamUtils.zip) (https://github.com/poetix/protonpack)
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("videoId", "5", "bookmarkId", "3")
*/
public class Kata8 {
    public static List<String> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<Bookmark> bookMarks = DataUtil.getBookMarks();

        //Obtiene y ordena los ids de los videos.
        Stream<Integer> variable1 = movieLists.stream().flatMap(movies ->
                movies.getVideos().stream().map(videos -> videos.getId()).sorted());

        //Obtiene y ordena los ids de los books.
        Stream<Integer> variable2 = bookMarks.stream().map(bookmark -> bookmark.getId()).sorted();

        /*
         * Realiza un zip de los videos junto con los bookmarks
         * return: [videoId 70111470 , bookmarkId 445,
         * videoId 654356453 , bookmarkId 453,
         * videoId 675465 , bookmarkId 470]
         */
        List<String> zipped = StreamUtils.zip(variable1,
                        variable2,
                        (a, b) -> "videoId " + a + " , bookmarkId " + b)
                .collect(Collectors.toList());


        return zipped;
    }
}
