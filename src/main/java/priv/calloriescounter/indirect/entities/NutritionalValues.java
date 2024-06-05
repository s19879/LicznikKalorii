package priv.calloriescounter.indirect.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "NUTRITIONAL_VALUES")
public class NutritionalValues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double protein;

    private double carbohydrates;

    private double totalFat;

    private double saturatedFat;

    private double salt;

    @OneToOne(mappedBy = "nutritionalValues", cascade = CascadeType.ALL)
    private Product product;

    public NutritionalValues(double protein, double carbohydrates, double totalFat, double saturatedFat, double salt){
        this.protein = protein;
        this.carbohydrates = carbohydrates;
        this.totalFat = totalFat;
        this.saturatedFat = saturatedFat;
        this.salt = salt;
    }

    @Override
    public String toString(){
        return "Białko: " + protein + "\nWęglowodany: " + carbohydrates + "\nTłuszcz calkowity: " + totalFat +
                "\n w tym tłuszcze nasycone: " + saturatedFat +
                "\n Sól: " + salt;
    }
}
