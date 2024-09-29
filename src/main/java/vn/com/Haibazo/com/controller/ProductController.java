package vn.com.Haibazo.com.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.Haibazo.com.dto.response.*;
import vn.com.Haibazo.com.entity.Product;
import vn.com.Haibazo.com.service.services.ProductService;
import vn.com.Haibazo.com.specification.ProductSpecification;

import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public ResponseEntity<ApiCustomize<List<ProductResponse>>> products() {
        ApiCustomize<List<ProductResponse>> products = this.productService.products();
        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Value"); // Add your custom headers here

        return new ResponseEntity<>(products, headers, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ApiCustomize<ProductDetailResponse>> product(@PathVariable("productId") int id) {
        ApiCustomize<ProductDetailResponse> apiCustomize = this.productService.product(id);
        if (apiCustomize.getResult() != null) {
            return ResponseEntity.ok(apiCustomize);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiCustomize);
        }
    }
    @GetMapping("/search")
    public ResponseEntity<ApiCustomize<Page<ProductDTO>>> getProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Double minStars,
            @RequestParam(required = false) Date saleEndDate,
            @RequestParam(required = false) String categoryName,
            @RequestParam(required = false) String styleName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size) {
        Specification<Product> spec = Specification.where(ProductSpecification.withName(name))
                .and(ProductSpecification.withMinPrice(minPrice))
                .and(ProductSpecification.withMaxPrice(maxPrice))
                .and(ProductSpecification.withMinStars(minStars))
                .and(ProductSpecification.withSaleEndDate(saleEndDate))
                .and(ProductSpecification.withCategory(categoryName))
                .and(ProductSpecification.withStyle(styleName));
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productService.findAll(spec,pageable);
        // Chuyển đổi sang DTO
        Page<ProductDTO> productDTOPage = productPage.map(product -> new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getAverage_stars(),
                product.getPrice(),
                product.getView(),
                product.getSaleEndDate(),
                product.getDiscount(),
                product.getImage()

        ));

        // Tạo đối tượng ApiCustomize cho phản hồi
        ApiCustomize<Page<ProductDTO>> apiCustomize = new ApiCustomize<>();
        apiCustomize.setResult(productDTOPage);
//        apiCustomize.setTotalCount(productDTOPage.getTotalElements());
//        apiCustomize.setPageSize(productDTOPage.getSize());
//        apiCustomize.setCurrentPage(productDTOPage.getNumber());
        return ResponseEntity.ok(apiCustomize);
    }
    @GetMapping("/price-range")
    public ResponseEntity<ApiCustomize<PriceResponse>> MinandMaxPriceInAllProduct() {
        Product productPriceMin = productService.findCheapestProduct();
        Product productPriceMax = productService.findMostExpensiveProduct();
        PriceResponse priceResponse = new PriceResponse();
        priceResponse.setPriceMin(productPriceMin.getPrice());
        priceResponse.setPriceMax(productPriceMax.getPrice());
        ApiCustomize<PriceResponse> apiCustomize = new ApiCustomize<>();
        apiCustomize.setCode("1000");
        apiCustomize.setResult(priceResponse);
        apiCustomize.setMessage("Successfully retrieved price range");
        return ResponseEntity.ok(apiCustomize);
    }

}
