package vn.com.Haibazo.com.specification;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import vn.com.Haibazo.com.entity.Product;
import vn.com.Haibazo.com.entity.Category;
import vn.com.Haibazo.com.entity.Style;
import java.util.Date;

public class ProductSpecification {

    public static Specification<Product> withName(String name) {
        return (root, query, criteriaBuilder) -> {
            return name == null ? null : criteriaBuilder.like(root.get("name"), "%" + name + "%");
        };
    }

    public static Specification<Product> withMinPrice(Double minPrice) {
        return (root, query, criteriaBuilder) -> {
            return minPrice == null ? null : criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
        };
    }

    public static Specification<Product> withMaxPrice(Double maxPrice) {
        return (root, query, criteriaBuilder) -> {
            return maxPrice == null ? null : criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
        };
    }

    public static Specification<Product> withMinStars(Double minStars) {
        return (root, query, criteriaBuilder) -> {
            return minStars == null ? null : criteriaBuilder.greaterThanOrEqualTo(root.get("average_stars"), minStars);
        };
    }

    public static Specification<Product> withSaleEndDate(Date saleEndDate) {
        return (root, query, criteriaBuilder) -> {
            return saleEndDate == null ? null : criteriaBuilder.lessThanOrEqualTo(root.get("saleEndDate"), saleEndDate);
        };
    }

    public static Specification<Product> withCategory(String categoryName) {
        return (root, query, criteriaBuilder) -> {
            if (categoryName == null) {
                return null;
            }
            Join<Product, Category> categoryJoin = root.join("category", JoinType.INNER);
            return criteriaBuilder.equal(categoryJoin.get("name"), categoryName);
        };
    }

    public static Specification<Product> withStyle(String styleName) {
        return (root, query, criteriaBuilder) -> {
            if (styleName == null) {
                return null;
            }
            Join<Product, Style> styleJoin = root.join("styles", JoinType.INNER);
            return criteriaBuilder.equal(styleJoin.get("name"), styleName);
        };
    }
}
