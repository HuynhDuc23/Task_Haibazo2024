package vn.com.Haibazo.com.service.services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import vn.com.Haibazo.com.dto.response.ApiCustomize;
import vn.com.Haibazo.com.dto.response.ProductDetailResponse;
import vn.com.Haibazo.com.dto.response.ProductResponse;
import vn.com.Haibazo.com.entity.Product;

import java.util.Date;
import java.util.List;

@Service
public interface ProductService {
    public ApiCustomize<List<ProductResponse>> products();

    public ApiCustomize<ProductDetailResponse> product(int id);
    public Page<Product> findAll(Specification<Product> spec, Pageable pageable);
    public Product findCheapestProduct();
    public Product findMostExpensiveProduct();
}