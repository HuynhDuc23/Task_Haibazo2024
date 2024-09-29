package vn.com.Haibazo.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.Haibazo.com.entity.ProductImage;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage ,Integer> {
    @Query("SELECT i FROM ProductImage i WHERE i.product.id = :productId")
    List<ProductImage> findAllImagesByProductId(@Param("productId") int productId);
}
