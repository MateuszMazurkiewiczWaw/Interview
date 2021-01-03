package POJOClasses.responses;


import com.fasterxml.jackson.annotation.JsonProperty;

public class ExchangeRates {

    private String base;
    @JsonProperty("rates")
    private Rates rates;
    private String date;

    public String getBase() {
        return base;
    }

    public Rates getRates() {
        return rates;
    }

    public String getDate() {
        return date;
    }

}