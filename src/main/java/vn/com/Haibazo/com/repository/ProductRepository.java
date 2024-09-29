package vn.com.Haibazo.com.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import vn.com.Haibazo.com.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product , Integer>, JpaSpecificationExecutor<Product> {

}
