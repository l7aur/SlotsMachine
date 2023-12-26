package backendish;

public class Account {
    private Integer sold;

    public Account(Integer sold){
        this.setSold(sold);
    }
    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }
    public void updateSold(Integer sold) {
        this.sold += sold;
    }
}
