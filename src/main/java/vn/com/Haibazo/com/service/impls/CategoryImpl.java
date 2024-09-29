package vn.com.Haibazo.com.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.Haibazo.com.dto.response.ApiCustomize;
import vn.com.Haibazo.com.dto.response.CategoryResponse;
import vn.com.Haibazo.com.entity.Category;
import vn.com.Haibazo.com.repository.CategoryRepository;
import vn.com.Haibazo.com.service.services.CategoryService;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryImpl implements CategoryService {
    private CategoryRepository categoryRepository ;

    @Autowired
    public CategoryImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ApiCustomize<List<CategoryResponse>> categories() {
        List<Category> categories = this.categoryRepository.findAll();
        List<CategoryResponse> categoryResponseArrayList = new ArrayList<>();

        // Check if the categories list is null or empty
        if (categories == null || categories.isEmpty()) {
            String message = "No categories found!";
            ApiCustomize<List<CategoryResponse>> apiCustomize = new ApiCustomize<>();
            apiCustomize.setMessage(message);
            apiCustomize.setResult(categoryResponseArrayList); // Returning an empty list
            return apiCustomize; // Return early if no categories found
        } else {
            for (Category category : categories) {
                CategoryResponse categoryResponse = new CategoryResponse();
                categoryResponse.setId(category.getId());
                categoryResponse.setName(category.getName());
                categoryResponseArrayList.add(categoryResponse);
            }
            String message = "All categories retrieved successfully!";
            ApiCustomize<List<CategoryResponse>> apiCustomize = new ApiCustomize<>();
            apiCustomize.setMessage(message);
            apiCustomize.setResult(categoryResponseArrayList);
            return apiCustomize; // Return the populated response
        }
    }

}
