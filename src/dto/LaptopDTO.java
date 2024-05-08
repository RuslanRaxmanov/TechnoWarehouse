package src.dto;

public class LaptopDTO extends BaseDTO {
    private String color;
    private Integer memory;
    private String protsessor;
    private Double displey;
    public LaptopDTO() {
    }

    public LaptopDTO(String color, Integer memory, String protsessor, Double displey) {
        this.color = color;
        this.memory = memory;
        this.protsessor = protsessor;
        this.displey = displey;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public String getProtsessor() {
        return protsessor;
    }

    public void setProtsessor(String protsessor) {
        this.protsessor = protsessor;
    }

    public Double getDispley() {
        return displey;
    }

    public void setDispley(Double displey) {
        this.displey = displey;
    }

    @Override
    public String toString() {
        return "LaptopDTO{" +
                "color='" + color + '\'' +
                ", memory='" + memory + '\'' +
                ", protsessor='" + protsessor + '\'' +
                ", displey=" + displey +
                '}';
    }
}
