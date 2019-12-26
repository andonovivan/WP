package mk.finki.ukim.mk.lab.model.Requests;

import lombok.Data;

@Data
public class IngredientRequest {
    private String name;
    private Boolean spicy;
    private Float amount;

    public String getName() {
        return name;
    }

    public Boolean getSpicy() {
        return spicy;
    }

    public Float getAmount() {
        return amount;
    }
}
