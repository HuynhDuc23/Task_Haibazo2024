package vn.com.Haibazo.com.service.impls;
import org.springframework.stereotype.Service;
import vn.com.Haibazo.com.dto.response.ApiCustomize;
import vn.com.Haibazo.com.dto.response.ColorResponse;
import vn.com.Haibazo.com.entity.Color;
import vn.com.Haibazo.com.repository.ColorRepository;
import vn.com.Haibazo.com.service.services.ColorService;

import java.util.ArrayList;
import java.util.List;
@Service
public class ColorImpl implements ColorService {
    private ColorRepository colorRepository;

    public ColorImpl(ColorRepository colorRepository) {
       this.colorRepository = colorRepository ;
    }

    @Override
    public ApiCustomize<List<ColorResponse>> colors() {
        List<Color> colors = this.colorRepository.findAll();
        List<ColorResponse> colorResponseList = new ArrayList<>();
        // Check if the categories list is null or empty
        if (colors == null || colors.isEmpty()) {
            String message = "No colors found!";
            ApiCustomize<List<ColorResponse>> apiCustomize = new ApiCustomize<>();
            apiCustomize.setMessage(message);
            apiCustomize.setResult(colorResponseList); // Returning an empty list
            return apiCustomize; // Return early if no categories found
        } else {
            for (Color color : colors) {
                ColorResponse colorResponse = new ColorResponse();
                colorResponse.setId(color.getId());
                colorResponse.setName(color.getName());
                colorResponseList.add(colorResponse);
            }
            String message = "All color retrieved successfully!";
            ApiCustomize<List<ColorResponse>> apiCustomize = new ApiCustomize<>();
            apiCustomize.setMessage(message);
            apiCustomize.setResult(colorResponseList);
            return apiCustomize;
        }

    }
}
