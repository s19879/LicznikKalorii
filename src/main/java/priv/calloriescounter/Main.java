package priv.calloriescounter;

import priv.calloriescounter.direct.forms.MainForm;
import priv.calloriescounter.indirect.entities.*;
import priv.calloriescounter.indirect.services.MealServiceImpl;
import priv.calloriescounter.indirect.services.ProductServiceImpl;

import javax.swing.*;
import java.io.File;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        File database = new File("./testdb");
        if(!database.exists())
            prepopulateDatabase();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainForm();
            }
        });

        System.out.println("Hello world!");


    }

    private static void prepopulateDatabase(){
        ProductServiceImpl ps = new ProductServiceImpl();
        NutritionalValues nutritionalValues = new NutritionalValues(1.3, 6.1, 3.6, 0.5, 1.3);
        ps.createLiquidProduct("Ajvar", "Home Garden", 65, nutritionalValues, true, true );

        NutritionalValues nutritionalValues2 = new NutritionalValues(17, 0.7, 23, 16, 2);
        SolidProduct solidProduct = ps.createSolidProduct("Feta", "Grikios", 276, nutritionalValues2, false);

        NutritionalValues nutritionalValues3 = new NutritionalValues(11, 2, 5, 3.5,0.2);
        LiquidProduct liquidProduct2 = ps.createLiquidProduct("Serek wiejski", "Piątnica", 97, nutritionalValues3, true, false);

        MealServiceImpl ml = new MealServiceImpl();
        Meal meal = ml.addMeal(MealType.BREAKFAST, new Date());
        ml.addProductToMeal(meal, solidProduct, 200);
        System.out.println(solidProduct.getNutritionalValues().getProduct().getId());
    }
}