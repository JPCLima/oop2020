package wsb;

public enum Country {
    ARGENTINA (	"AR", "Spanish", 445445.18),
    POLAND ("PL", "Polish", 595858.21),
    PORTUGAL ("PT", "Portuguese", 238785.09),
    SPAIN ("ES", "Spanish", 1393490.52);

    private final String countryCode;
    private final String language;
    private final Double gdp;
    private static Double PLN_RATE = 3.71;

    Country(String countryCode, String language, Double gdp) {
        this.countryCode = countryCode;
        this.language = language;
        this.gdp = gdp;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public Double getGdpInUSD() {
        return gdp;
    }

    public Double getGdpInPLN() {
        return gdp*PLN_RATE;
    }

}
