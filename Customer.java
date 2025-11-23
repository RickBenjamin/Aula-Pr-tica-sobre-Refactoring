import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private String name;
    private Vector<Rental> rentals = new Vector<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return new TextStatement().value(this);
    }

    public String htmlStatement() {
        return new HtmlStatement().value(this);
    }

    public Enumeration getRentals() {
        return rentals.elements();
    }

    public double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> enum_rentals = rentals.elements();
        while (enum_rentals.hasMoreElements()) {
            Rental each = enum_rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    public int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration<Rental> enum_rentals = rentals.elements();
        while (enum_rentals.hasMoreElements()) {
            Rental each = enum_rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}
