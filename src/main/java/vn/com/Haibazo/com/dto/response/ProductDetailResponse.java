package vn.com.Haibazo.com.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDetailResponse {
     private int id ;
     private String name ;
     private String description ;
     private double average_stars ;
     private int view ;
     private double discount ;
     private double price ;
     private Date date ;
     private List<ColorResponse> colors ;
     private List<ImageResponse> imgs ;
     private List<SizeResponse> sizes;

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

     public int getView() {
          return view;
     }

     public void setView(int view) {
          this.view = view;
     }

     public double getDiscount() {
          return discount;
     }

     public void setDiscount(double discount) {
          this.discount = discount;
     }

     public double getPrice() {
          return price;
     }

     public void setPrice(double price) {
          this.price = price;
     }

     public Date getDate() {
          return date;
     }

     public void setDate(Date date) {
          this.date = date;
     }

     public List<ColorResponse> getColors() {
          return colors;
     }

     public void setColors(List<ColorResponse> colors) {
          this.colors = colors;
     }

     public List<ImageResponse> getImgs() {
          return imgs;
     }

     public void setImgs(List<ImageResponse> imgs) {
          this.imgs = imgs;
     }

     public List<SizeResponse> getSizes() {
          return sizes;
     }

     public void setSizes(List<SizeResponse> sizes) {
          this.sizes = sizes;
     }
}
