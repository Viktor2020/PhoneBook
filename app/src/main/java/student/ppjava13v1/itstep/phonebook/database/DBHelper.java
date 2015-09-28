package student.ppjava13v1.itstep.phonebook.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import student.ppjava13v1.itstep.phonebook.model.ModelContact;

public class DBHelper extends SQLiteOpenHelper implements BaseColumns {

    public static final String DB_NAME = "phone-book.db";
    public static final String CONTACT_TABLE = "users";
    public static final String CONTACT_NAME_COLUMN = "name";
    public static final String CONTACT_NUMBER_COLUMN = "password"; 
    public static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + CONTACT_TABLE + " ( "
                + _ID + " integer primary key autoincrement, "
                + CONTACT_NAME_COLUMN + " text not null, "
                + CONTACT_NUMBER_COLUMN + " text not null )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CONTACT_TABLE);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public long insertContact(ModelContact Contact) {
        ContentValues values = new ContentValues();
        values.put(CONTACT_NAME_COLUMN, Contact.getContactName());
        values.put(CONTACT_NUMBER_COLUMN, Contact.getContactNumber());

        SQLiteDatabase db =  this.getWritableDatabase();
        return db.insert(
                CONTACT_TABLE,
                null,
                values);
    }

    public Cursor getAllContacts() {
        return this.getReadableDatabase().rawQuery("select * from " + CONTACT_TABLE, null);
    }

    public Cursor getContactByName(String name) {

        String[] projection = {
                _ID,
                CONTACT_NAME_COLUMN,
                CONTACT_NUMBER_COLUMN
        };
        String selection = CONTACT_NAME_COLUMN + " = ?";
        String[] selectionArgs = {name};
        String sortOrder = " DESC";

        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(
                CONTACT_TABLE,                            // The table to query
                projection,                               // The columns to return null
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );
    }
    
    public int updateContact(ModelContact Contact) {

        ContentValues values = new ContentValues();
        values.put(CONTACT_NAME_COLUMN, Contact.getContactName());
        values.put(CONTACT_NUMBER_COLUMN, Contact.getContactNumber());

        String selection = _ID + " LIKE ?";
        String[] selectionArgs = { String.valueOf(Contact.getId()) };

        SQLiteDatabase db = this.getReadableDatabase();
        return db.update(
                CONTACT_TABLE,
                values,
                selection,
                selectionArgs);
    }

    public void deleteContactById(long ContactId) {
        String selection = _ID + " LIKE ?";
        String[] selectionArgs = { String.valueOf(ContactId) };
        this.getWritableDatabase().delete(CONTACT_TABLE, selection, selectionArgs);
    }

}
