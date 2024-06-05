package priv.calloriescounter.direct.forms.product;

import priv.calloriescounter.direct.forms.CustomPanel;
import priv.calloriescounter.direct.forms.MainForm;
import priv.calloriescounter.indirect.entities.Product;

public class AddUpdateProductPanel extends CustomPanel {

    private Product product;
    public AddUpdateProductPanel(MainForm mainForm){
        this(mainForm, null);
    }
    public AddUpdateProductPanel(MainForm mainForm, Product product){
        super(mainForm);
        this.product = product;

    }
}
