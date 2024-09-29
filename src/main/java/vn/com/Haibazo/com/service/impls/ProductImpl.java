package vn.com.Haibazo.com.service.impls;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import vn.com.Haibazo.com.dto.response.*;
import vn.com.Haibazo.com.entity.Color;
import vn.com.Haibazo.com.entity.Product;
import vn.com.Haibazo.com.entity.ProductImage;
import vn.com.Haibazo.com.entity.Size;
import vn.com.Haibazo.com.enums.ApiError;
import vn.com.Haibazo.com.exception.ErrorCode;
import vn.com.Haibazo.com.exception.ProductNotFound;
import vn.com.Haibazo.com.repository.*;
import vn.com.Haibazo.com.service.services.ProductService;
import vn.com.Haibazo.com.specification.ProductSpecification;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductImpl implements ProductService {
    @Autowired
    private EntityManager entityManager;
    private ProductRepository productRepository ;
    private ColorRepository colorRepository ;
    private ProductImageRepository productImageRepository;
    private SizeRepository sizeRepository;

    @Autowired
    public ProductImpl(ProductRepository productRepository , ColorRepository colorRepository , StyleRepository styleRepository,SizeRepository sizeRepository , ProductImageRepository productImageRepository) {
        this.productRepository = productRepository;
        this.colorRepository = colorRepository ;
        this.productImageRepository = productImageRepository;
        this.sizeRepository = sizeRepository;
    }

    @Override
    public ApiCustomize<List<ProductResponse>> products() {
        List<Product> products = this.productRepository.findAll();
        List<ProductResponse> productResponseList = new ArrayList<>();
        // Check if the categories list is null or empty
        if (products == null || products.isEmpty()) {
            String message = "No product found!";
            ApiCustomize<List<ProductResponse>> apiCustomize = new ApiCustomize<>();
            apiCustomize.setMessage(message);
            apiCustomize.setResult(productResponseList); // Returning an empty list
            return apiCustomize; // Return early if no categories found
        } else {
            for (Product product : products) {
                ProductResponse productResponse = new ProductResponse();
                productResponse.setId(product.getId());
                productResponse.setName(product.getName());
                productResponse.setDiscount(product.getDiscount());
                productResponse.setPrice(product.getPrice());
                productResponse.setAverage_stars(product.getAverage_stars());
                productResponse.setImage(product.getImage());

                productResponseList.add(productResponse);
            }
            String message = "All product retrieved successfully!";
            ApiCustomize<List<ProductResponse>> apiCustomize = new ApiCustomize<>();
            apiCustomize.setMessage(message);
            apiCustomize.setResult(productResponseList);
            return apiCustomize;
        }

    }
    @Override
    public ApiCustomize<ProductDetailResponse> product(int id) {
         Product product = this.productRepository.findById(id).orElseThrow(()->  new ProductNotFound(ErrorCode.PRODUCT_NOT_FOUND));;
         List<Color> colors = this.colorRepository.findAll();
         List<Size> sizes = this.sizeRepository.findAll();
         List<ProductImage> images = this.productImageRepository.findAllImagesByProductId(id);
         ProductDetailResponse productDetailResponse = new ProductDetailResponse();
         if(product != null && colors !=null && sizes!=null && images !=null) {
             productDetailResponse.setId(product.getId());
           productDetailResponse.setName(product.getName());
           productDetailResponse.setDescription(product.getDescription());
           productDetailResponse.setAverage_stars(product.getAverage_stars());
           productDetailResponse.setDiscount(product.getDiscount());
           productDetailResponse.setDate(product.getSaleEndDate());
           productDetailResponse.setPrice(product.getPrice());
           productDetailResponse.setView(product.getView());
           List<ImageResponse> imageResponseList = new ArrayList<>();
           List<ColorResponse> colorResponseList = new ArrayList<>();
           List<SizeResponse> sizeResponseList = new ArrayList<>();

           for(ProductImage image : images){
               ImageResponse imageResponse = new ImageResponse();
               imageResponse.setId(image.getId());
               imageResponse.setImage(image.getUrl());
               imageResponseList.add(imageResponse);
           }

           for(Color color : colors){
               ColorResponse colorResponse = new ColorResponse();
               colorResponse.setId(color.getId());
               colorResponse.setName(color.getName());
               colorResponseList.add(colorResponse);
           }
             for(Size size : sizes){
                 SizeResponse sizeResponse = new SizeResponse();
                 sizeResponse.setId(size.getId());
                 sizeResponse.setName(size.getName());
                 sizeResponseList.add(sizeResponse);
             }
             productDetailResponse.setImgs(imageResponseList);
             productDetailResponse.setColors(colorResponseList);
             productDetailResponse.setSizes(sizeResponseList);
         }
         ApiCustomize<ProductDetailResponse> apiCustomize = new ApiCustomize<>();
         apiCustomize.setMessage("User found with id " + id);
         apiCustomize.setCode(ApiError.OK.getCode());
         apiCustomize.setResult(productDetailResponse);
         return apiCustomize;
    }

    @Override
    public Page<Product> findAll(Specification<Product> spec, Pageable pageable) {
        return productRepository.findAll(spec, pageable);
    }

    @Override
    public Product findCheapestProduct() {
        return entityManager.createQuery("SELECT p FROM Product p ORDER BY p.price ASC", Product.class)
                .setMaxResults(1)
                .getSingleResult();
    }

    @Override
    public Product findMostExpensiveProduct() {
        return entityManager.createQuery("SELECT p FROM Product p ORDER BY p.price DESC", Product.class)
                .setMaxResults(1)
                .getSingleResult();
    }


}
