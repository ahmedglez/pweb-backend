package cu.edu.cujae.pwebjsf.services.dto;


public class BillDto {
    private int code;
    private float amount;
    private float specialAmount;
    
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }
    public float getSpecialAmount() {
        return specialAmount;
    }
    public void setSpecialAmount(float specialAmount) {
        this.specialAmount = specialAmount;
    }

}
