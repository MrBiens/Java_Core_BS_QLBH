package src.main.java.model;

public class Product {
    private Integer id;
    private String name;
    private Integer quantity; // so luong
    private float price;
    private String description; // mo ta

    //khoi tao khong tham so -- Product product = new Product();
    public Product() {
    }

    public Product(Integer id, String name, Integer quantity, float price, String description) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price=price;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
