package priv.calloriescounter.direct.forms;

import priv.calloriescounter.direct.forms.product.AddUpdateProductPanel;
import priv.calloriescounter.direct.forms.product.ProductPanel;
import priv.calloriescounter.indirect.entities.Product;

import javax.swing.*;

public class MainForm extends JFrame {
    protected JPanel currentPanel;
    public MainForm(){
        super("Licznik kalorii");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        changePanel(createMainPanel());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public JPanel createMainPanel(){
        return new MainPanel(this);
    }

    public JPanel createProductPanel(){
        return new ProductPanel(this);
    }

    public JPanel createAddProductPanel(){
        return new AddUpdateProductPanel(this);
    }

    public JPanel createUpdateProductPanel(Product product){
        return new AddUpdateProductPanel(this, product);
    }

    public void changePanel(JPanel newPanel) {
        currentPanel = newPanel;
        setContentPane(currentPanel);
        invalidate();
        validate();
    }
}
