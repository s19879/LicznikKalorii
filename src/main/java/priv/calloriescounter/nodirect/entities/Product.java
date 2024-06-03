package priv.calloriescounter.nodirect.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name = "PRODUCT")
public abstract class Product {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String producer;

    private double kcalAmount;

    private boolean isActive;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nutritional_values_id", referencedColumnName = "id")
    private NutritionalValues nutritionalValues;

    @OneToMany(mappedBy = "product", cascade = { CascadeType.ALL})
    private List<MealProduct> mealProducts = new ArrayList<>();

    public Product(@NonNull String name, @NonNull String producer, double kcalAmount, @NonNull NutritionalValues nutritionalValues) {
        this.name = name;
        this.producer = producer;
        this.kcalAmount = kcalAmount;
        this.nutritionalValues = nutritionalValues;
        isActive = true;
    }

    public abstract String getUnitType();
}
