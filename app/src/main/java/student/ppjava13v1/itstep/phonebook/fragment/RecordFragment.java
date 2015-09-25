package student.ppjava13v1.itstep.phonebook.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
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

        records = getRecords();

        View rootView = inflater.inflate(R.layout.activity_main, container, false);
        listView = (ListView) rootView.findViewById(R.id.list);

        adapter = new RecordAdapter(getActivity(), 0, records);
        listView.setAdapter(adapter);

        return rootView;
    }

    public Adapter getAdapter () {
        return adapter;
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
