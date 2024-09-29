package vn.com.Haibazo.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.Haibazo.com.entity.Size;
@Repository
public interface SizeRepository extends JpaRepository<Size,Integer> {
}
