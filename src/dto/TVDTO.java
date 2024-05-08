package src.dto;

public class TVDTO extends BaseDTO {
    private Double displey;

    public TVDTO(Double displey) {
        this.displey = displey;
    }

    public TVDTO() {

    }

    public Double getDispley() {
        return displey;
    }

    public void setDispley(Double displey) {
        this.displey = displey;
    }
}
