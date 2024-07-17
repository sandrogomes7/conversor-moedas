package modelos;

public class Moeda {
    String base_code;
    private String result;
    private Cotacao conversion_rates;

    public class Cotacao {
        private double BRL;
        private double EUR;
        private double KRW;
        private double ARS;
        private double USD;

        public double getGeral(String moeda) {
            switch (moeda) {
                case "BRL":
                    return BRL;
                case "EUR":
                    return EUR;
                case "KRW":
                    return KRW;
                case "ARS":
                    return ARS;
                case "USD":
                    return USD;
                default:
                    return 0;
            }
        }
    }

    public String getBaseCode() {
        return base_code;
    }

    public String getResult() {
        return result;
    }

    public Cotacao getConversionRates() {
        return conversion_rates;
    }

}
