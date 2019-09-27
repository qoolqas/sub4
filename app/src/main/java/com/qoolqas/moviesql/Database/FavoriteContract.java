package com.qoolqas.moviesql.Database;

import android.provider.BaseColumns;

public class FavoriteContract {
    public static final class MovieColumns implements BaseColumns {

        public static final String TABLE_MOVIE = "favorite";
        public static final String COLUMN_MOVIEID = "movieid";
        public static final String COLUMN_POSTER_PATH = "posterpath";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_USER_RATING = "userrating";
        public static final String COLUMN_SYNOPSIS = "overview";
        public static final String COLUMN_RELEASE = "releasedate";
    }
    public static final class TvColumns implements BaseColumns{
        public static final String TABLE_TV = "favoritetv";
        public static final String COLUMN_TVID = "tvid";
        public static final String COLUMN_POSTER_PATH_TV = "posterpath";
        public static final String COLUMN_TITLE_TV = "title";
        public static final String COLUMN_USER_RATING_TV = "userrating";
        public static final String COLUMN_SYNOPSIS_TV = "overview";
        public static final String COLUMN_RELEASE_TV = "first_air_date";
    }
}
