package priv.calloriescounter.nodirect.entities;

public enum MealType {
    BREAKFAST("Śniadanie"),
    SECOND_BREAKFAST("Drugie śniadanie"),
    LUNCH("Obiad"),
    AFTERNOON_SNACK("Podwieczorek"),
    DINNER("Kolacja");

    private final String description;

    MealType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
