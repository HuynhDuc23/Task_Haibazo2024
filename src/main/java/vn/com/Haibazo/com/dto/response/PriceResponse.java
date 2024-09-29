package vn.com.Haibazo.com.dto.response;

public class PriceResponse {
    private double priceMin;
    private double priceMax;

    public double getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(double priceMax) {
        this.priceMax = priceMax;
    }

    public double getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(double priceMin) {
        this.priceMin = priceMin;
    }
}
