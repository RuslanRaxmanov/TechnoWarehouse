package src.dto;

public class PhoneDTO extends BaseDTO {
    private Integer memory;
    private String color;

    public PhoneDTO(Integer memory, String color) {
        this.memory = memory;
        this.color = color;
    }

    public PhoneDTO() {
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
