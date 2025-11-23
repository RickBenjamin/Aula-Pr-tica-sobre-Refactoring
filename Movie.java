public class Movie {

    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;

    private String _title;
    private Price _price;

    public Movie(String name, int priceCode) {
        _title = name;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return _title;
    }

    public int getPriceCode() {
        return _price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDRENS:
                _price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    // ✔️ Após o passo 4 — Agora apenas delega para Price
    public double getCharge(int daysRented) {
        return _price.getCharge(daysRented);
    }

    // ✔️ Ainda não será movido no passo 4, isso é só depois
    public int getFrequentRenterPoints(int daysRented) {
        if ((this.getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
            return 2;
        return 1;
    }
}
