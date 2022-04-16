
package Movies.tables;

public class Actor_Table {
    String Actor_id, First_name , Last_name, Gender, Dob, Address, Phone_number, Country;

    public Actor_Table(String Actor_id, String First_name, String Last_name, String Gender, String Dob, String Address, String Phone_number, String Country) {
        this.Actor_id = Actor_id;
        this.First_name = First_name;
        this.Last_name = Last_name;
        this.Gender = Gender;
        this.Dob = Dob;
        this.Address = Address;
        this.Phone_number = Phone_number;
        this.Country = Country;
    }

    public String getActor_id() {
        return Actor_id;
    }

    public void setActor_id(String Actor_id) {
        this.Actor_id = Actor_id;
    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String First_name) {
        this.First_name = First_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String Last_name) {
        this.Last_name = Last_name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String Dob) {
        this.Dob = Dob;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(String Phone_number) {
        this.Phone_number = Phone_number;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }
    
}
