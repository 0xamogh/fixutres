package amoghjapps.com.worldymouldy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "fixtures.db";
    private static final int DATABASE_VERSION = 1 ;
    public static final String TABLE_NAME = "fixes";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TEAM1N = "t1n";
    public static final String COLUMN_TEAM2N = "t2n";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_TIME = "time";
    public static final String COLUMN_VENUE = "venue";
    public static final String COLUMN_TEAM1I = "image1";
    public static final String COLUMN_TEAM2I = "image2";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
