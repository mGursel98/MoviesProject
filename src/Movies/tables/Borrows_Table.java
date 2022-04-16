
package Movies.tables;

public class Borrows_Table {
    String Actor_id , First_name , Last_name , Title, Director, Start_date, End_date, Borrow_id;

    public Borrows_Table(String Actor_id, String First_name, String Last_name, String Title, String Director, String Start_date, String End_date,String Borrow_id) {
        this.Actor_id = Actor_id;
        this.First_name = First_name;
        this.Last_name = Last_name;
        this.Title = Title;
        this.Director = Director;
        this.Start_date = Start_date;
        this.End_date = End_date;
        this.Borrow_id = Borrow_id;
    }

    public String getBorrow_id() {
        return Borrow_id;
    }

    public void setBorrow_id(String Borrow_id) {
        this.Borrow_id = Borrow_id;
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

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String Director) {
        this.Director = Director;
    }

    public String getStart_date() {
        return Start_date;
    }

    public void setStart_date(String Start_date) {
        this.Start_date = Start_date;
    }

    public String getEnd_date() {
        return End_date;
    }

    public void setEnd_date(String End_date) {
        this.End_date = End_date;
    }
    
    
    
}
