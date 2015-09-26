package student.ppjava13v1.itstep.phonebook;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import student.ppjava13v1.itstep.phonebook.adapter.RecordAdapter;
import student.ppjava13v1.itstep.phonebook.dialog.AddRecordDialogFragment;
import student.ppjava13v1.itstep.phonebook.fragment.RecordFragment;
import student.ppjava13v1.itstep.phonebook.model.ModelRecord;

public class MainActivity extends AppCompatActivity implements AddRecordDialogFragment.OnAddRecordListener {

    private RecordAdapter adapter;
    private RecordFragment recordFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recordFragment = new RecordFragment();
        getFragmentManager().beginTransaction().add(R.id.target_frame_contact_list, recordFragment).commit();


        setUI();

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        adapter = (RecordAdapter) recordFragment.getAdapter();
    }

    private void setUI() {
        ImageButton btnAddRecord = (ImageButton) findViewById(R.id.btn_add_record);
        btnAddRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment addDialogFragment = new AddRecordDialogFragment();
                addDialogFragment.show(getFragmentManager(), "AddRecordDialogFragment");
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onAddRecord(ModelRecord record) {
        adapter.addRecord(record);
    }
}
