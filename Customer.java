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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> enum_rentals = rentals.elements();
        String result = "Rental Record for " + getName() + "\n";

        while (enum_rentals.hasMoreElements()) {
            Rental each = enum_rentals.nextElement();

            // Aqui substitui o switch-case pelo método extraído
            double thisAmount = amountFor(each);

            // add frequent renter points
            frequentRenterPoints++;

            // add bonus for a two day new release rental
            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE
                    && each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }

            // show figures
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    thisAmount + "\n";
            totalAmount += thisAmount;
        }

        // add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints +
                " frequent renter points";
        return result;
    }

    
    // MÉTODO EXTRAÍDO NO REFACTORING 1
    private double amountFor(Rental aRental) {
    double thisAmount = 0;

    switch (aRental.getMovie().getPriceCode()) {
        case Movie.REGULAR:
            thisAmount += 2;
            if (aRental.getDaysRented() > 2)
                thisAmount += (aRental.getDaysRented() - 2) * 1.5;
            break;

        case Movie.NEW_RELEASE:
            thisAmount += aRental.getDaysRented() * 3;
            break;

        case Movie.CHILDRENS:
            thisAmount += 1.5;
            if (aRental.getDaysRented() > 3)
                thisAmount += (aRental.getDaysRented() - 3) * 1.5;
            break;
    }

        return thisAmount;
    }
}
