package priv.calloriescounter.indirect.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity(name = "MEAL")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Basic
    @Enumerated(EnumType.STRING)
    MealType mealType;

    @NotNull
    Date date;

    @OneToMany(mappedBy = "meal", cascade = { CascadeType.ALL})
    private List<MealProduct> mealProducts = new ArrayList<>();

    public Meal(MealType mealType, Date date){
        this.mealType = mealType;
        this.date = date;
    }
}
