package vn.com.Haibazo.com.dto.request;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import vn.com.Haibazo.com.validator.DoubleValidator;
import vn.com.Haibazo.com.validator.ValidString;

public class CreateProductRequest {
    @NotNull
    @Min(value = 1, message = "AVARAGE_STARS")
    @Max(value = 5, message = "AVARAGE_STARS")
    private double  avarage_stars ;
    private String description ;
    private double discount ;
    private String image ;
    @NotNull
    @ValidString(message = "FIELD_")
    private String name ;
    private double price ;
    private int view ;
    private int id ;

    public CreateProductRequest() {
    }

    public CreateProductRequest(double avarage_stars, int id, int view, double price, String name, String image, double discount, String description) {
        this.avarage_stars = avarage_stars;
        this.id = id;
        this.view = view;
        this.price = price;
        this.name = name;
        this.image = image;
        this.discount = discount;
        this.description = description;
    }

    public double getAvarage_stars() {
        return avarage_stars;
    }

    public void setAvarage_stars(double avarage_stars) {
        this.avarage_stars = avarage_stars;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
