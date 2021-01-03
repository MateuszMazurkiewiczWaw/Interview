package POJOClasses.responses;


public class ExchangeRates {

    private String base;
    private Rates rates;
    private String date;

    /**
     * No args constructor for use in serialization
     */
    public ExchangeRates() {
    }

    /**
     * @param date
     * @param rates
     * @param base
     */
    public ExchangeRates(String base, Rates rates, String date) {
        super();
        this.base = base;
        this.rates = rates;
        this.date = date;
    }

    public String getBase() {
        return base;
    }

    /*
    public Rates getRates() {
        return rates;
    }
     */

    public String getDate() {
        return date;
    }

}