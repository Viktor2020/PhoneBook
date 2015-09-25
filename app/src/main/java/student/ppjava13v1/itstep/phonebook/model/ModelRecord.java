package student.ppjava13v1.itstep.phonebook.model;

public class ModelRecord {

    private String contactName;
    private String contactNumber;

    public ModelRecord() {
    }

    public ModelRecord(String contactName, String contactNumber) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

}
