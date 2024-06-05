package priv.calloriescounter.direct.forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends CustomPanel{
    public MainPanel(MainForm mainForm){
        super(mainForm);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setTitle("Licznik kalorii");
        setProductButton();
        setVisible(true);
    }

    private void setProductButton(){
        JPanel panel = createNewPanel();
        JButton productButton = new JButton("Produkty");
        panel.add(productButton);
        add(panel);
        productButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainForm.changePanel(mainForm.createProductPanel());
            }
        });
    }
}
