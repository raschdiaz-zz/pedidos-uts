package co.edu.uts.sistemas.pedidosuts.model;

public class Product {
    private int id;
    private String code;
    private String name;
    private int price;
    private String image;

    public Product(String code, String name, int price) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.image = "http://i.imgur.com/DvpvklR.png";
    }

    public Product(int id, String code, String name, int price, String image) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}
