package backendish;

public class LNumber {
    protected Integer id;
    protected Integer uniqueIdentifier;
    protected Double multiplierx2;
    protected Double multiplierx3;
    LNumber(){
        this.id = 0;
        this.uniqueIdentifier = 0;
        this.multiplierx2 = 0.0;
        this.multiplierx3 = 0.0;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public Double getMultiplierx2() {
        return multiplierx2;
    }

    public Double getMultiplierx3() {
        return multiplierx3;
    }

    public Double getMultiplier(Integer number) {
        return switch (number) {
            case 2 -> 2 * this.getMultiplierx2();
            case 3 -> 3 * this.getMultiplierx3();
            default -> 0.0;
        };
    }
}
