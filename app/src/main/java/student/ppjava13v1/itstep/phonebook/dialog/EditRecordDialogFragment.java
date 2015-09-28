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

public class EditRecordDialogFragment extends DialogFragment {


    private OnEditRecordListener editRecord;

    public interface OnEditRecordListener {
        void onEditRecord(ModelContact record);
    }

    public EditRecordDialogFragment() {
    }

    public static EditRecordDialogFragment newInstance(ModelContact contact, OnEditRecordListener editRecord) {
        EditRecordDialogFragment myFragment = new EditRecordDialogFragment();

        Bundle args = new Bundle();
        args.putLong("contactId", contact.getId());
        args.putString("contactName", contact.getContactName());
        args.putString("contactNumber", contact.getContactNumber());
        myFragment.setArguments(args);
        myFragment.setEditRecord(editRecord);

        return myFragment;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Edit");

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View container = inflater.inflate(R.layout.fragment_add_record, null);

        final EditText etName = (EditText) container.findViewById(R.id.etName);
        final EditText etNumber = (EditText) container.findViewById(R.id.etNumber);
        etName.setText(getArguments().getString("contactName"));
        etNumber.setText(getArguments().getString("contactNumber"));

        builder.setView(container);

        builder.setPositiveButton(R.string.btn_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ModelContact contact = new ModelContact();
                contact.setId(getArguments().getLong("contactId"));
                contact.setContactName(etName.getText().toString());
                contact.setContactNumber(etNumber.getText().toString());
                editRecord.onEditRecord(contact);
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

    public void setEditRecord(OnEditRecordListener editRecord) {
        this.editRecord = editRecord;
    }
}
