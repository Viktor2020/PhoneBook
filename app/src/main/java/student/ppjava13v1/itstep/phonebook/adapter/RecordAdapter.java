package student.ppjava13v1.itstep.phonebook.adapter;

import android.content.Context;
import android.database.Cursor;
import android.widget.SimpleCursorAdapter;

public class RecordAdapter extends SimpleCursorAdapter {

    public RecordAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
    }



}
