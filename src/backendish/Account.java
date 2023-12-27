package backendish;

public class Account {
    private Double sold;

    public Account(Double sold){
        this.setSold(sold);
    }
    public Double getSold() {
        return sold;
    }

    public void setSold(Double sold) {
        this.sold = sold;
    }
    public void updateSold(Double sold) {
        this.sold += sold;
    }
}
