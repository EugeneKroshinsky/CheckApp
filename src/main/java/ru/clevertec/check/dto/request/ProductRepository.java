package main.java.ru.clevertec.check.dto.request;

public class ProductRepository extends Product{
    double price;
    boolean wholesale;
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public ProductRepository() {
    }

    public ProductRepository(int id, int quantity, double price, boolean wholesale, String name) {
        super(id, quantity);
        this.price = price;
        this.wholesale = wholesale;
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setWholesale(boolean wholesale) {
        this.wholesale = wholesale;
    }

    public double getPrice() {
        return price;
    }

    public boolean isWholesale() {
        return wholesale;
    }

    public String getName() {
        return name;
    }
}
