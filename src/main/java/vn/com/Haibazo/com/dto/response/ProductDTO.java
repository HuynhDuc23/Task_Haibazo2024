package vn.com.Haibazo.com.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.util.Date;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class ProductDTO {
    private int id;
    private String name;
    private String description;
    private double averageStars;
    private double price;
    private int view;
    private Date saleEndDate;
    private double discount;
    private String image;
    private String category ;

    // Constructor
    public ProductDTO(int id, String name, String description, double averageStars,
                      double price, int view, Date saleEndDate, double discount, String image , String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.averageStars = averageStars;
        this.price = price;
        this.view = view;
        this.saleEndDate = saleEndDate;
        this.discount = discount;
        this.image = image;
        this.category = category;
    }

    public ProductDTO() {

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAverageStars() {
        return averageStars;
    }

    public void setAverageStars(double averageStars) {
        this.averageStars = averageStars;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
