package student.ppjava13v1.itstep.phonebook.model;

public class ModelContact {

    private long id;
    private String contactName;
    private String contactNumber;

    public ModelContact() {
    }

    public ModelContact(String contactName, String contactNumber) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }

    public ModelContact(long id, String contactName, String contactNumber) {
        this.id = id;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
