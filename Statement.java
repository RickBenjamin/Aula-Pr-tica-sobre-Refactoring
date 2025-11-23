import java.util.Enumeration;

public abstract class Statement {

    public String value(Customer aCustomer) {
        String result = header(aCustomer);
        Enumeration<Rental> rentals = aCustomer.getRentals();

        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += eachRental(each);
        }

        result += footer(aCustomer);
        return result;
    }

    protected abstract String header(Customer aCustomer);
    protected abstract String eachRental(Rental each);
    protected abstract String footer(Customer aCustomer);
}
