package student.ppjava13v1.itstep.phonebook.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import student.ppjava13v1.itstep.phonebook.R;
import student.ppjava13v1.itstep.phonebook.adapter.RecordAdapter;
import student.ppjava13v1.itstep.phonebook.model.ModelRecord;

public class RecordFragment extends Fragment {

    private ListView listView;
    private List<ModelRecord> records;
    private RecordAdapter adapter;

    public RecordFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.record_fragment, container, false);
        listView = (ListView) rootView.findViewById(R.id.list);

        records = getRecords();

        adapter = new RecordAdapter(getActivity(), 0, records);

        listView.setAdapter(adapter);

        registerForContextMenu(listView);

        return rootView;
    }

    public Adapter getAdapter() {
        return adapter;
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
                adapter.removeItem(info.position);
                return true;
            case R.id.menu_edit:
                return true;
            default:
                return super.onContextItemSelected(item);
        }
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
        return records;
    }
}
