package com.qoolqas.moviesql.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.qoolqas.moviesql.Data.Movie;

import java.util.ArrayList;

import static android.provider.BaseColumns._ID;
import static com.qoolqas.moviesql.Database.FavoriteContract.MovieColumns.COLUMN_MOVIEID;
import static com.qoolqas.moviesql.Database.FavoriteContract.MovieColumns.COLUMN_POSTER_PATH;
import static com.qoolqas.moviesql.Database.FavoriteContract.MovieColumns.COLUMN_RELEASE;
import static com.qoolqas.moviesql.Database.FavoriteContract.MovieColumns.COLUMN_SYNOPSIS;
import static com.qoolqas.moviesql.Database.FavoriteContract.MovieColumns.COLUMN_TITLE;
import static com.qoolqas.moviesql.Database.FavoriteContract.MovieColumns.COLUMN_USER_RATING;
import static com.qoolqas.moviesql.Database.FavoriteContract.MovieColumns.TABLE_MOVIE;
import static com.qoolqas.moviesql.Database.FavoriteContract.TvColumns.TABLE_TV;


public class FavoriteHelper {
    private static final String DATABASE_TABLE = TABLE_MOVIE;
    private static final String DATABASE_TABLE_TV = TABLE_TV;
    private static FavoriteDbHelper favoriteDbHelper;
    private static FavoriteHelper INSTANCE;
    private static SQLiteDatabase db;

    public FavoriteHelper(Context context) {
        favoriteDbHelper = new FavoriteDbHelper(context);
    }

    public static FavoriteHelper getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (SQLiteOpenHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FavoriteHelper(context);
                }
            }
        }
        return INSTANCE;
    }

    public void open() throws SQLException {
        db = favoriteDbHelper.getWritableDatabase();
    }

    public void close() {
        favoriteDbHelper.close();
        if (db.isOpen())
            db.close();
    }

    public ArrayList<Movie> getAllMovie() {
        ArrayList<Movie> arrayList = new ArrayList<>();
        Cursor cursor = db.query(DATABASE_TABLE, null,
                null,
                null,
                null,
                null,
                _ID + " ASC",
                null);
        cursor.moveToFirst();
        Movie movie;
        if (cursor.getCount() > 0) {
            do {
                movie= new Movie();
                movie.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_MOVIEID)));
                movie.setPosterPath(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_POSTER_PATH)));
                movie.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE)));
                movie.setVoteAverage( cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_USER_RATING)));
                movie.setOverview(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_SYNOPSIS)));
                movie.setReleaseDate(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_RELEASE)));

                arrayList.add(movie);
                cursor.moveToNext();

            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return arrayList;
    }
    public long insertMovie(Movie movie) {
        ContentValues conts = new ContentValues();
        conts.put(COLUMN_MOVIEID, movie.getId());
        conts.put(COLUMN_POSTER_PATH, movie.getPosterPath());
        conts.put(COLUMN_TITLE, movie.getTitle());
        conts.put(COLUMN_USER_RATING, movie.getVoteAverage());
        conts.put(COLUMN_SYNOPSIS, movie.getOverview());
        conts.put(COLUMN_RELEASE, movie.getReleaseDate());

        return db.insert(DATABASE_TABLE, null, conts);
    }
    public int deleteMovie(int id) {
        return db.delete(TABLE_MOVIE, COLUMN_MOVIEID + " = '" + id + "'", null);
    }
}
