import java.math.BigDecimal;

public class Product {
    private int id;
    private String title;
    private BigDecimal cost;

    public Product(int id, String title, BigDecimal cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public String getInfo() {
        return id + ". " + title + ", " + cost.setScale(2) + "руб.";
    }
}
