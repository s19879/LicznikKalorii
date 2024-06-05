package priv.calloriescounter.indirect.entities;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "SOLID_PRODUCT")
public class SolidProduct extends Product{

    boolean isShortTerm;

    public SolidProduct(@NonNull String name, @NonNull String producer, double kcalAmount, @NonNull NutritionalValues nutritionalValues, boolean isShortTerm){
        super(name, producer, kcalAmount, nutritionalValues);
        this.isShortTerm = isShortTerm;
    }

    @Override
    public String getUnitType(){
        return "g";
    }
}
