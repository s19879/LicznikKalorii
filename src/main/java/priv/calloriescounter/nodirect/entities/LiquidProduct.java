package priv.calloriescounter.nodirect.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "LIQUID_PRODUCT")
public class LiquidProduct extends Product{
    private boolean isSuitableForMixing;
    private boolean isSauce;

    public LiquidProduct(@NotNull String name, @NotNull String producer,  double kcalAmount, NutritionalValues nutritionalValues, boolean isSuitableForMixing, boolean isSauce) {
        super(name, producer, kcalAmount, nutritionalValues);
        this.isSuitableForMixing = isSuitableForMixing;
        this.isSauce = isSauce;
    }

    @Override
    public String getUnitType(){
        return "ml";
    }
}
