package vn.com.Haibazo.com.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(nullable = false)
    @NotNull
    private String name ;
    @OneToMany(mappedBy = "color", cascade = CascadeType.ALL)
    private Set<ProductColorSize> productColorSizes = new HashSet<>();



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

    public Set<ProductColorSize> getProductColorSizes() {
        return productColorSizes;
    }

    public void setProductColorSizes(Set<ProductColorSize> productColorSizes) {
        this.productColorSizes = productColorSizes;
    }

    @Override
    public String toString() {
        return "Color{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productColorSizes=" + productColorSizes +
                '}';
    }
}
