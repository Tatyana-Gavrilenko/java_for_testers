package model;

public record ContactData(String firstname, String middlename, String lastname, String numberPhone) {

    public ContactData() {
        this("", "", "", "");
    }

    public ContactData withName(String firstname) {
        return new ContactData(firstname, this.middlename, this.lastname, this.numberPhone);
    }
}