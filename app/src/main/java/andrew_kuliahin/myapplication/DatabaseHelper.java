package andrew_kuliahin.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "usernotes.db"; // название бд
    private static final int SCHEMA = 1; // версия базы данных
    public static final String TABLE = "notes"; // название таблицы в бд
    // названия столбцов
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NOTE = "note";
    public static final String COLUMN_DATECATEGORY = "datecategory";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE notes (" + COLUMN_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NOTE
                + " TEXT, " + COLUMN_DATECATEGORY + " TEXT);");

        db.execSQL("INSERT INTO "+ TABLE +" (" + COLUMN_DATECATEGORY
                + ", " + COLUMN_NOTE  + ") VALUES ('dd.MM.yy  HH:mm          Без категории', 'ККК Ку-Клукс-Клан');");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }
}