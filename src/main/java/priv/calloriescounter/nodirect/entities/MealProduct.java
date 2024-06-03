package priv.calloriescounter.nodirect.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity(name = "PRODUCT_MEAL")
public class MealProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int amount;

    @ManyToOne
    private Meal meal;

    @ManyToOne
    private Product product;

    public MealProduct(@NonNull Meal meal, @NonNull Product product, int amount){
        this.meal = meal;
        this.product = product;
        this.amount = amount;
    }
}
