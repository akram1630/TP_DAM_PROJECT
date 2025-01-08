package com.example.projet_tp_dam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    // Database Version and Name
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "moduleManager";

    // Table Name
    private static final String TABLE_MODULE = "module";

    // Table Columns
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_NOTE_TP = "note_tp";
    private static final String KEY_NOTE_TD = "note_td";
    private static final String KEY_NOTE_CONTROL = "note_control";
    private static final String KEY_TYPE = "type";
    private static final String KEY_COEFFICIENT = "coefficient";
    private static final String KEY_POIDS_CONTROL = "poids_control";
    private static final String KEY_POIDS_TD_AND_TP = "poids_td_and_tp";
    private static final String KEY_MOYENNE = "moyenne";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MODULE_TABLE = "CREATE TABLE " + TABLE_MODULE + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_TYPE + " TEXT,"
                + KEY_COEFFICIENT + " INTEGER,"
                + KEY_POIDS_CONTROL + " INTEGER,"
                + KEY_POIDS_TD_AND_TP + " INTEGER"
                + ")";
        db.execSQL(CREATE_MODULE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MODULE);
        // Create tables again
        onCreate(db);
    }

    void addModule(Module module) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, module.getName()); // Contact Name
        //int:
        values.put(KEY_COEFFICIENT, module.getCoefficient()); // Contact Phone
        values.put(KEY_TYPE, module.getType()); // Contact Phone
        values.put(KEY_POIDS_CONTROL, module.getPoidsControl()); // Contact Phone
        values.put(KEY_POIDS_TD_AND_TP, module.getPoidsTdAndTp()); // Contact Phone
        // Inserting Row
        db.insert(TABLE_MODULE, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public List<Module> getAllModule() {
        List<Module> contactList = new ArrayList<Module>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_MODULE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Module module = new Module();
                module.setId(Integer.parseInt(cursor.getString(0)));
                module.setName(cursor.getString(1));
                module.setType(cursor.getString(2));
                module.setCoefficient(Integer.parseInt(cursor.getString(3)));
                module.setPoidsControl(Integer.parseInt(cursor.getString(4)));
                module.setPoidsTdAndTp(Integer.parseInt(cursor.getString(5)));

                // Adding contact to list
                contactList.add(module);
            } while (cursor.moveToNext());
        }
        // return contact list
        return contactList;
    }
    public void deleteModule(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MODULE, KEY_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    public void updateModule(int id, String newName, int newCoefficient) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a ContentValues object to hold the updated values
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, newName);
        values.put(KEY_COEFFICIENT, newCoefficient);

        // Update the table with the new values
        db.update(TABLE_MODULE, values, KEY_ID + " = ?", new String[]{String.valueOf(id)});
        db.close(); // Close the database connection
    }

}
