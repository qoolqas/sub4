package com.qoolqas.moviesql.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FavoriteDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "favorite.db";
    private static final int DATABASE_VERSION = 1;

    public FavoriteDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_MOVIE_TABLE = String.format("CREATE TABLE %s"
                        + " (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " %s INTEGER NOT NULL," +
                        " %s TEXT NOT NULL," +
                        " %s TEXT NOT NULL," +
                        " %s TEXT NOT NULL," +
                        " %s TEXT NOT NULL," +
                        " %s TEXT NOT NULL)",
                FavoriteContract.MovieColumns.TABLE_MOVIE,
                FavoriteContract.MovieColumns._ID,
                FavoriteContract.MovieColumns.COLUMN_MOVIEID,
                FavoriteContract.MovieColumns.COLUMN_POSTER_PATH,
                FavoriteContract.MovieColumns.COLUMN_TITLE,
                FavoriteContract.MovieColumns.COLUMN_USER_RATING,
                FavoriteContract.MovieColumns.COLUMN_SYNOPSIS,
                FavoriteContract.MovieColumns.COLUMN_RELEASE
        );
        final String SQL_CREATE_TV_TABLE = String.format("CREATE TABLE %s"
                        + " (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " %s INTEGER NOT NULL," +
                        " %s TEXT NOT NULL," +
                        " %s TEXT NOT NULL," +
                        " %s TEXT NOT NULL," +
                        " %s TEXT NOT NULL," +
                        " %s TEXT NOT NULL)",
                FavoriteContract.TvColumns.TABLE_TV,
                FavoriteContract.TvColumns._ID,
                FavoriteContract.TvColumns.COLUMN_TVID,
                FavoriteContract.TvColumns.COLUMN_TITLE_TV,
                FavoriteContract.TvColumns.COLUMN_RELEASE_TV,
                FavoriteContract.TvColumns.COLUMN_USER_RATING_TV,
                FavoriteContract.TvColumns.COLUMN_SYNOPSIS_TV,
                FavoriteContract.TvColumns.COLUMN_POSTER_PATH_TV
        );
        sqLiteDatabase.execSQL(SQL_CREATE_MOVIE_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_TV_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + FavoriteContract.MovieColumns.TABLE_MOVIE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + FavoriteContract.TvColumns.TABLE_TV);
        onCreate(sqLiteDatabase);
    }
}
