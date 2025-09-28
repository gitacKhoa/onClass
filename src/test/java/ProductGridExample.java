import javax.swing.*;
import java.awt.*;

class Product {
    private String name;
    private double price;
    private ImageIcon image;

    public Product(String name, double price, ImageIcon image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public ImageIcon getImage() { return image; }
}

class ProductRenderer extends JPanel implements ListCellRenderer<Product> {
    private JLabel lblImage = new JLabel();
    private JLabel lblName = new JLabel();
    private JLabel lblPrice = new JLabel();

    public ProductRenderer() {
        setLayout(new BorderLayout());
        lblImage.setHorizontalAlignment(JLabel.CENTER);

        JPanel textPanel = new JPanel(new GridLayout(2, 1));
        textPanel.add(lblName);
        textPanel.add(lblPrice);

        add(lblImage, BorderLayout.CENTER);
        add(textPanel, BorderLayout.SOUTH);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Product> list,
                                                  Product product,
                                                  int index,
                                                  boolean isSelected,
                                                  boolean cellHasFocus) {
        lblImage.setIcon(product.getImage());
        lblName.setText(product.getName());
        lblPrice.setText("$" + product.getPrice());

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setOpaque(true);
        return this;
    }
}

public class ProductGridExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Product Grid");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            DefaultListModel<Product> model = new DefaultListModel<>();
            model.addElement(new Product("Laptop", 1200.0, new ImageIcon("laptop.png")));
            model.addElement(new Product("Phone", 800.0, new ImageIcon("phone.png")));
            model.addElement(new Product("Headphones", 150.0, new ImageIcon("headphones.png")));
            model.addElement(new Product("Camera", 600.0, new ImageIcon("camera.png")));

            JList<Product> productList = new JList<>(model);
            productList.setCellRenderer(new ProductRenderer());

            // chuyển sang dạng grid
            productList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
            productList.setVisibleRowCount(-1);
            productList.setFixedCellWidth(300);
            productList.setFixedCellHeight(200);

            frame.add(new JScrollPane(productList));
            frame.setSize(800, 600);
            frame.setVisible(true);
        });
    }
}