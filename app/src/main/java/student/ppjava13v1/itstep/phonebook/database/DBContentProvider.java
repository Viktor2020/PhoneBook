package student.ppjava13v1.itstep.phonebook.database;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class DBContentProvider extends ContentProvider {

    private SQLiteOpenHelper helper;

    @Override
    public boolean onCreate() {
        helper = new DBHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] columns, String selection,
                        String[] selectionArgs, String sortOrder) {
        Cursor cursor = helper.getWritableDatabase().query(PhoneBookColumns.CONTACT_TABLE, columns
                , selection, selectionArgs, null, null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(), PhoneBookProviderFields.CONTENT_URI);
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowID = helper.getWritableDatabase().insert(PhoneBookColumns.CONTACT_TABLE, null, values);
        Uri resultUri = ContentUris.withAppendedId(uri, rowID);
        getContext().getContentResolver().notifyChange(resultUri, null);
        return resultUri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int cnt = helper.getWritableDatabase().delete(PhoneBookColumns.CONTACT_TABLE, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return cnt;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int cnt = helper.getWritableDatabase().update(PhoneBookColumns.CONTACT_TABLE, values, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return cnt;
    }
}
