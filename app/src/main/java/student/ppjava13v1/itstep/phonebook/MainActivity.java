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

    private ListView listView;
    private List<ModelRecord> records;
    private RecordAdapter adapter;
    private RecordFragment recordFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        records = getRecords();

        listView = (ListView) findViewById(R.id.list);
        adapter = new RecordAdapter(this, 0, records);
        listView.setAdapter(adapter);



        setUI();

    }

    private void setUI() {
        ImageButton btnAddRecord = (ImageButton) findViewById(R.id.btn_add_record);
//        Button btnAdd = (Button) findViewById(R.id.btn_add_record);
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

    public List<ModelRecord> getRecords() {
        records = new ArrayList<>();
        records.add(new ModelRecord("Vasy", "+3809584985"));
        records.add(new ModelRecord("Alex", "+3809585987"));
        records.add(new ModelRecord("Ivan", "+3809888985"));
        records.add(new ModelRecord("Oleg", "+3899999985"));
        records.add(new ModelRecord("Pety", "+7709584985"));
        records.add(new ModelRecord("Vasy", "+3809584985"));
        records.add(new ModelRecord("Alex", "+3809585987"));
        records.add(new ModelRecord("Ivan", "+3809888985"));
        records.add(new ModelRecord("Oleg", "+3899999985"));
        records.add(new ModelRecord("Pety", "+7709584985"));
        records.add(new ModelRecord("Vasy", "+3809584985"));
        records.add(new ModelRecord("Alex", "+3809585987"));
        records.add(new ModelRecord("Ivan", "+3809888985"));
        records.add(new ModelRecord("Oleg", "+3899999985"));
        records.add(new ModelRecord("Pety", "+7709584985"));
        records.add(new ModelRecord("Vasy", "+3809584985"));
        records.add(new ModelRecord("Alex", "+3809585987"));
        records.add(new ModelRecord("Ivan", "+3809888985"));
        records.add(new ModelRecord("Oleg", "+3899999985"));
        records.add(new ModelRecord("Pety", "+7709584985"));
        records.add(new ModelRecord("Vasy", "+3809584985"));
        records.add(new ModelRecord("Alex", "+3809585987"));
        records.add(new ModelRecord("Ivan", "+3809888985"));
        records.add(new ModelRecord("Oleg", "+3899999985"));
        records.add(new ModelRecord("Pety", "+7709584985"));
        records.add(new ModelRecord("Vasy", "+3809584985"));
        records.add(new ModelRecord("Alex", "+3809585987"));
        records.add(new ModelRecord("Ivan", "+3809888985"));
        records.add(new ModelRecord("Oleg", "+3899999985"));
        records.add(new ModelRecord("Pety", "+7709584985"));
        records.add(new ModelRecord("Vasy", "+3809584985"));
        records.add(new ModelRecord("Alex", "+3809585987"));
        records.add(new ModelRecord("Ivan", "+3809888985"));
        records.add(new ModelRecord("Oleg", "+3899999985"));
        records.add(new ModelRecord("Pety", "+7709584985"));
        records.add(new ModelRecord("Vasy", "+3809584985"));
        records.add(new ModelRecord("Alex", "+3809585987"));
        records.add(new ModelRecord("Ivan", "+3809888985"));
        records.add(new ModelRecord("Oleg", "+3899999985"));
        records.add(new ModelRecord("Pety", "+7709584985"));
        records.add(new ModelRecord("Vasy", "+3809584985"));
        records.add(new ModelRecord("Alex", "+3809585987"));
        records.add(new ModelRecord("Ivan", "+3809888985"));
        records.add(new ModelRecord("Oleg", "+3899999985"));
        records.add(new ModelRecord("Pety", "+7709584985"));
        return records;
    }

    @Override
    public void onAddRecord(ModelRecord record) {
        adapter.addRecord(record);
    }
}
