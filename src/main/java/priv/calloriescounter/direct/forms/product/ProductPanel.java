package priv.calloriescounter.direct.forms.product;

import priv.calloriescounter.direct.forms.CustomPanel;
import priv.calloriescounter.direct.forms.MainForm;
import priv.calloriescounter.indirect.entities.LiquidProduct;
import priv.calloriescounter.indirect.entities.Product;
import priv.calloriescounter.indirect.services.ProductService;
import priv.calloriescounter.indirect.services.ProductServiceImpl;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ProductPanel extends CustomPanel {
    ProductService productService;
    List<Product> products;
    JPanel productPanel;
    ListSelectionModel listSelectionModel;
    public ProductPanel(MainForm mainForm){
        super(mainForm);
        productService = new ProductServiceImpl();

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setTitle("Produkty");
        addActionButtons();
        setProductTable();
        setVisible(true);
    }

    private void setProductTable(){
        products =  productService.getAllProducts();

        productPanel = createNewPanel();
        productPanel.setLayout(new BorderLayout());
        productPanel.setPreferredSize(new Dimension(300,200));

        String[] columnNames = {"Nazwa produktu", "Producent", "Ilość kalorii", "Typ produktu", "Status"};
        Object[][] rowData = new Object[products.size()][5];

        for(int i = 0; i < products.size(); i++){
            Product product = products.get(i);

            rowData[i][0] = product.getName();
            rowData[i][1] = product.getProducer();
            rowData[i][2] = product.getKcalAmount();
            rowData[i][3] = (product instanceof LiquidProduct) ? "płynne" : "stałe";
            rowData[i][4] = product.isActive() ? "Aktywny" : "Nieaktywny";

        }

        DefaultTableModel model = new DefaultTableModel(rowData, columnNames);
        JTable productTable = new JTable(model);
        listSelectionModel = productTable.getSelectionModel();
        JScrollPane scrollPane = new JScrollPane(productTable);
        productPanel.add(scrollPane, BorderLayout.CENTER);
        add(productPanel);
    }

    private void addActionButtons(){
        JPanel actionButtonsPanel = createNewPanel();
        actionButtonsPanel.add(createBackButton());
        actionButtonsPanel.add(createDeactiveButton());
        actionButtonsPanel.add(createActiveButton());
        actionButtonsPanel.add(createDetailsButton());
        add(actionButtonsPanel);
    }

    private JButton createBackButton(){
        JButton backButton = new JButton("Powrót");
        backButton.addActionListener(e ->{
            mainForm.changePanel(mainForm.createMainPanel());
        });
        return backButton;
    }

    private JButton createDeactiveButton(){
        JButton deactiveButton = new JButton("Dezaktywuj produkt");
        deactiveButton.addActionListener(e ->{
            if(!listSelectionModel.isSelectionEmpty()) {
                productService.deactivateProduct(products.get(listSelectionModel.getMinSelectionIndex()));
                refreshTable();
            } else JOptionPane.showMessageDialog(null, "Żaden produkt nie został wybrany");
        });

        return deactiveButton;
    }

    private JButton createActiveButton(){
        JButton activeButton = new JButton("Aktywuj produkt");
        activeButton.addActionListener(e ->{
            if(!listSelectionModel.isSelectionEmpty()) {
                productService.activateProduct(products.get(listSelectionModel.getMinSelectionIndex()));
                refreshTable();
            } else JOptionPane.showMessageDialog(null, "Żaden produkt nie został wybrany");
        });

        return activeButton;
    }

    private JButton createDetailsButton(){
        JButton detailsButton = new JButton("Szczegóły produktu");
        detailsButton.addActionListener(e ->{
            if(!listSelectionModel.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, products.get(listSelectionModel.getMinSelectionIndex()).toString());
            } else JOptionPane.showMessageDialog(null, "Żaden produkt nie został wybrany");
        });
        return detailsButton;
    }

    private void refreshTable() {
        remove(productPanel);
        //setOrderTable();
        setProductTable();
        revalidate();
        repaint();
    }
}
