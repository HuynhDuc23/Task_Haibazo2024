package vn.com.Haibazo.com.service.impls;

import org.springframework.stereotype.Service;
import vn.com.Haibazo.com.dto.response.ApiCustomize;
import vn.com.Haibazo.com.dto.response.StyleResponse;
import vn.com.Haibazo.com.entity.Style;
import vn.com.Haibazo.com.repository.StyleRepository;
import vn.com.Haibazo.com.service.services.StyleService;

import java.util.ArrayList;
import java.util.List;
@Service
public class StyleImpl implements StyleService {
    private StyleRepository styleRepository ;
    public StyleImpl(StyleRepository styleRepository){
        this.styleRepository = styleRepository ;
    }
    @Override
    public ApiCustomize<List<StyleResponse>> styles() {
        List<Style> styles = this.styleRepository.findAll();
        List<StyleResponse> styleResponseList = new ArrayList<>();
        // Check if the categories list is null or empty
        if (styles == null || styles.isEmpty()) {
            String message = "No styles found!";
            ApiCustomize<List<StyleResponse>> apiCustomize = new ApiCustomize<>();
            apiCustomize.setMessage(message);
            apiCustomize.setResult(styleResponseList); // Returning an empty list
            return apiCustomize; // Return early if no categories found
        } else {
            for (Style style : styles) {
                StyleResponse styleResponse = new StyleResponse();
                styleResponse.setId(style.getId());
                styleResponse.setName(style.getName());
                styleResponseList.add(styleResponse);
            }
            String message = "All color retrieved successfully!";
            ApiCustomize<List<StyleResponse>> apiCustomize = new ApiCustomize<>();
            apiCustomize.setMessage(message);
            apiCustomize.setResult(styleResponseList);
            return apiCustomize;
        }
    }
}
