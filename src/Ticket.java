import java.io.FileWriter;
import java.io.IOException;

//attributes
public class Ticket {
    private char rowNum;
    private int seatNum;
    private int price;
    private Person person;

    //constructor
    public Ticket(char rowNum, int seatNum, int price, Person person) {
        this.rowNum = rowNum;
        this.seatNum = seatNum;
        this.price = price;
        this.person = person;
    }

    // Getters and setters

    public void setRow(char row) {
        this.rowNum = row;
    }

    public char getRow() {
        return rowNum;
    }

    public void setSeat(int seatNum) {
        this.seatNum = seatNum;
    }

    public int getSeat() {
        return seatNum;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    // Method to display ticket information
    public void TicketInfo() {
        System.out.println("Ticket Details\n" +"\n"+
                "Row: " + rowNum + "\nSeat: " + seatNum +
                "\nPrice: £" + price +
                "\n"+
        "\nPerson information"+"\n");person.personInfo();
        System.out.println("-----------------------------------------");
    }
    public void saveFile() {
        try {

            String path = getRow() + "" + getSeat() + ".txt";

            FileWriter newfile = new FileWriter(path);
            newfile.write("--------------------------------------------\n");
            newfile.write("Ticket Info\n");
            newfile.write("--------------------------------------------\n");
            newfile.write("Row:" + getRow() + "\tSeat: " + getSeat());
            newfile.write("\nPrice: " + getPrice());
            newfile.write("--------------------------------------------\n");
            newfile.write("\nPerson Info");
            newfile.write("\n--------------------------------------------\n");
            newfile.write("\nName: " + person.getName());
            newfile.write("\nSurname: " + person.getSurname());
            newfile.write("\nEmail: " + person.getEmail());

            newfile.close();



        } catch (IOException e) {
            System.out.println("Error occured");
        }
    }
}
