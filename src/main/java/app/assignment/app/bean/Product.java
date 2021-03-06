package app.assignment.app.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
@Entity
@Table(name = "products")
/**
 * POJO Class
 */
public class Product {

    @Id
    private int id;
    private String name;
    private String brand;
    private String color;
    private double price;
    private Date creationDate;
    private Date modifyDate;
    @Transient
    private boolean isExpensive;

    public Product(int id, String name, String brand, String color, double price, Date creationDate, Date modifyDate, boolean isExpensive) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.creationDate = creationDate;
        this.modifyDate = modifyDate;
        this.isExpensive = isExpensive;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public boolean isExpensive() {
        return getPrice() > Constant.ISEXPENSIVE ? true : false;
    }

    public void setExpensive(boolean expensive) {
        isExpensive = expensive;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", creationDate=" + creationDate +
                ", modifyDate=" + modifyDate +
                ", isExpensive=" + isExpensive +
                '}';
    }
}