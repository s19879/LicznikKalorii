package priv.calloriescounter.indirect.repositories;

import priv.calloriescounter.indirect.entities.Meal;
import priv.calloriescounter.indirect.entities.MealType;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

public class MealRepository extends AbstractRepository<Meal, Long> implements IMealRepository{
    public MealRepository(){super(Meal.class);}

    @Override
    public Meal findByMealTypeAndDate(MealType mealType, Date date) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Meal> criteriaQuery = criteriaBuilder.createQuery(Meal.class);
        Root<Meal> root = criteriaQuery.from(Meal.class);
        criteriaQuery.select(root)
                .where(criteriaBuilder.equal(root.<Date>get("date"), date),
                        criteriaBuilder.equal(root.get("mealType"), mealType));

        return (!session.createQuery(criteriaQuery).getResultList().isEmpty()) ?
                    session.createQuery(criteriaQuery).getResultList().get(0) : null;
    }

    @Override
    public List<Meal> findAllByDate(Date date) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Meal> criteriaQuery = criteriaBuilder.createQuery(Meal.class);
        Root<Meal> root = criteriaQuery.from(Meal.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("date"), date));
        return session.createQuery(criteriaQuery).getResultList();
    }
}
