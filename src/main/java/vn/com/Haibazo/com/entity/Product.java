package vn.com.Haibazo.com.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String name ;
    private String description ;
    private double average_stars ;
    private double price ;
    private int view ;
    private Date saleEndDate ;
    private double discount ;
    @Lob
    private String image ;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<ProductImage> images = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<ProductColorSize> productColorSizes = new HashSet<>();


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "product_style", // Tên bảng trung gian
            joinColumns = @JoinColumn(name = "product_id"), // Khóa chính của bảng Product
            inverseJoinColumns = @JoinColumn(name = "style_id") // Khóa chính của bảng Style
    )
    private Set<Style> styles = new HashSet<>();

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAverage_stars() {
        return average_stars;
    }

    public void setAverage_stars(double average_stars) {
        this.average_stars = average_stars;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public Date getSaleEndDate() {
        return saleEndDate;
    }

    public void setSaleEndDate(Date saleEndDate) {
        this.saleEndDate = saleEndDate;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ProductImage> getImages() {
        return images;
    }

    public void setImages(List<ProductImage> images) {
        this.images = images;
    }

    public Set<ProductColorSize> getProductColorSizes() {
        return productColorSizes;
    }

    public void setProductColorSizes(Set<ProductColorSize> productColorSizes) {
        this.productColorSizes = productColorSizes;
    }

    public Set<Style> getStyles() {
        return styles;
    }

    public void setStyles(Set<Style> styles) {
        this.styles = styles;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", average_stars=" + average_stars +
                ", price=" + price +
                ", view=" + view +
                ", saleEndDate=" + saleEndDate +
                ", discount=" + discount +
                ", image='" + image + '\'' +
                ", category=" + category +
                ", images=" + images +
                ", productColorSizes=" + productColorSizes +
                ", styles=" + styles +
                '}';
    }
}
