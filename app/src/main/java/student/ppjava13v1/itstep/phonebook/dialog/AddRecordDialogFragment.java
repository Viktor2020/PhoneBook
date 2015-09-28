package student.ppjava13v1.itstep.phonebook.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import student.ppjava13v1.itstep.phonebook.R;
import student.ppjava13v1.itstep.phonebook.model.ModelContact;

public class AddRecordDialogFragment extends DialogFragment {

    private OnAddRecordListener onAddRecord;

    public AddRecordDialogFragment() {
        // Required empty public constructor
    }

    public static AddRecordDialogFragment newInstance(OnAddRecordListener onAddRecord) {
        AddRecordDialogFragment dialogFragment = new AddRecordDialogFragment();
        dialogFragment.setOnAddRecord(onAddRecord);

        return dialogFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.dialog_add_record);
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View container = inflater.inflate(R.layout.fragment_add_record, null);

        final EditText etName = (EditText) container.findViewById(R.id.etName);
        final EditText etNumber = (EditText) container.findViewById(R.id.etNumber);

        builder.setView(container);

        builder.setPositiveButton(R.string.btn_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ModelContact record = new ModelContact(etName.getText().toString(),
                        etNumber.getText().toString());
                onAddRecord.onAddRecord(record);
                dialog.dismiss();
            }
        });

        builder.setNegativeButton(R.string.btn_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });


        return builder.create();
    }


    public interface OnAddRecordListener {
        void onAddRecord(ModelContact record);
    }

    public void setOnAddRecord(OnAddRecordListener onAddRecord) {
        this.onAddRecord = onAddRecord;
    }
}
