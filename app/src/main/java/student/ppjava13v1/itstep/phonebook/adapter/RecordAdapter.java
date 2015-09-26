package student.ppjava13v1.itstep.phonebook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import student.ppjava13v1.itstep.phonebook.R;
import student.ppjava13v1.itstep.phonebook.model.ModelRecord;

public class RecordAdapter extends ArrayAdapter<ModelRecord> {


    List<ModelRecord> records;

    public RecordAdapter(Context context, int resource, List<ModelRecord> records) {
        super(context, resource, records);
        this.records = records;
    }

    private LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View currentView;
        if (convertView == null) {
            currentView =  inflater.inflate(R.layout.model_record, null);
        } else {
            currentView = convertView;
        }

        TextView textViewName = (TextView) currentView.findViewById(R.id.tvNamePhone);
        TextView textViewNumber = (TextView) currentView.findViewById(R.id.tvNumberPhone);

        textViewName.setText( getItem(position).getContactName());
        textViewNumber.setText( getItem(position).getContactNumber());

        currentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return currentView;
    }

    public void addRecord(ModelRecord record) {
        records.add(record);
        notifyDataSetChanged();
    }

    public void removeRecord(ModelRecord record) {
        records.remove(record);
        notifyDataSetChanged();
    }

    public void removeAllItems() {
        if (getRecordCount()!= 0) {
            records = new ArrayList<>();
            notifyDataSetChanged();
        }
    }

    public void addItem(int location, ModelRecord record) {
        records.add(location, record);
        notifyDataSetChanged();
    }

    public void removeItem(int location) {
        if (location >= 0 && location <= records.size() - 1) {
            records.remove(location);
            notifyDataSetChanged();
        }
    }

    public ModelRecord getModelRecord(int position) {
        return records.get(position);
    }

    public int getRecordCount() {
        return records.size();
    }
}
