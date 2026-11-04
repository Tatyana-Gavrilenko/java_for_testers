package model;

public record ContactData(String id, String firstname, String lastname, String address, String email, String mobile) {

    public ContactData() {
        this("", "", "", "","", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.lastname, this.address, this.email, this.mobile);
    }

    public ContactData withName(String firstname) {
        return new ContactData(this.id, firstname, this.lastname, this.address, this.email, this.mobile);
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.id, this.firstname, lastname, this.address, this.email, this.mobile);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstname, this.lastname, address, this.email, this.mobile);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.firstname, this.lastname, this.address, email, this.mobile);
    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.firstname, this.lastname, this.address, this.email, mobile);
    }
}