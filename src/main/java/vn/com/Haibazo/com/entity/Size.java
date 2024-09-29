package vn.com.Haibazo.com.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(nullable = false)
    private String name ;

    @OneToMany(mappedBy = "size", cascade = CascadeType.ALL)
    private Set<ProductColorSize> productColorSizes = new HashSet<>();

    public int getId() {
        return id;
    }

    public Set<ProductColorSize> getProductColorSizes() {
        return productColorSizes;
    }

    public void setProductColorSizes(Set<ProductColorSize> productColorSizes) {
        this.productColorSizes = productColorSizes;
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

    @Override
    public String toString() {
        return "Size{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productColorSizes=" + productColorSizes +
                '}';
    }
}
