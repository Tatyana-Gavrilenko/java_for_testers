package model;

public record ContactData(String firstname, String lastname, String address, String mobile) {

    public ContactData() {
        this("", "", "", "");
    }

    public ContactData withName(String firstname) {
        return new ContactData(firstname, this.lastname, this.address, this.mobile);
    }

    public ContactData withLastName(String lastName) {
        return new ContactData(this.firstname, lastname, this.address, this.mobile);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.firstname, this.lastname, address, this.mobile);
    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.firstname, this.lastname, this.address, mobile);
    }
}