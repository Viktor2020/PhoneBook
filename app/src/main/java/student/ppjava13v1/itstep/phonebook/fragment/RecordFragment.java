package student.ppjava13v1.itstep.phonebook.fragment;

import android.app.DialogFragment;
import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import student.ppjava13v1.itstep.phonebook.R;
import student.ppjava13v1.itstep.phonebook.adapter.RecordAdapter;
import student.ppjava13v1.itstep.phonebook.database.DBHelper;
import student.ppjava13v1.itstep.phonebook.dialog.EditRecordDialogFragment;
import student.ppjava13v1.itstep.phonebook.model.ModelContact;

public class RecordFragment extends Fragment implements EditRecordDialogFragment.OnEditRecordListener {

    private ListView listView;
    private RecordAdapter adapter;
    private DBHelper dbHelper;

    public RecordFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.record_fragment, container, false);
        listView = (ListView) rootView.findViewById(R.id.list);


        dbHelper = new DBHelper(getActivity());
        adapter = new RecordAdapter(getActivity(), R.layout.model_record
                , dbHelper.getAllContacts()
                , new String[]{DBHelper.CONTACT_NAME_COLUMN, DBHelper.CONTACT_NUMBER_COLUMN}
                , new int[]{R.id.tvNamePhone, R.id.tvNumberPhone}
                , 1);

        listView.setAdapter(adapter);

        registerForContextMenu(listView);

        return rootView;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getActivity().getMenuInflater().inflate(R.menu.my_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.menu_delete:
                removeRecord(adapter.getItemId(info.position));
                return true;
            case R.id.menu_edit:
                editContactDialog(info.position);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void editContactDialog(long contactId) {
        Cursor cursor = (Cursor) adapter.getItem((int) contactId);
        long id = cursor.getLong(cursor.getColumnIndex(DBHelper._ID));
        String name = cursor.getString(cursor.getColumnIndex(DBHelper.CONTACT_NAME_COLUMN));
        String number = cursor.getString(cursor.getColumnIndex(DBHelper.CONTACT_NUMBER_COLUMN));

        ModelContact contact = new ModelContact(id, name, number);

        DialogFragment dialogFragment = EditRecordDialogFragment.newInstance(contact, this);
        dialogFragment.show(getFragmentManager(), "EditRecordDialogFragment");
    }

    public void addRecord(ModelContact contact) {
        dbHelper.insertContact(contact);
        adapter.changeCursor(dbHelper.getAllContacts());
    }

    public void removeRecord(long contactId) {
        dbHelper.deleteContactById(contactId);
        adapter.changeCursor(dbHelper.getAllContacts());
    }

    public void editRecord(ModelContact contact) {
        dbHelper.updateContact(contact);
        adapter.changeCursor(dbHelper.getAllContacts());
    }

    @Override
    public void onEditRecord(ModelContact record) {
        editRecord(record);
    }
}
