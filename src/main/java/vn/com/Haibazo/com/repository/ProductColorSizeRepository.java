package vn.com.Haibazo.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.Haibazo.com.entity.ProductColorSize;
@Repository
public interface ProductColorSizeRepository extends JpaRepository<ProductColorSize , Integer> {
}
