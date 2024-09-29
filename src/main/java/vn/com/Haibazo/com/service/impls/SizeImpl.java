package vn.com.Haibazo.com.service.impls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.Haibazo.com.dto.response.ApiCustomize;
import vn.com.Haibazo.com.dto.response.SizeResponse;
import vn.com.Haibazo.com.entity.Size;
import vn.com.Haibazo.com.repository.SizeRepository;
import vn.com.Haibazo.com.service.services.SizeService;

import java.util.ArrayList;
import java.util.List;
@Service
public class SizeImpl implements SizeService {
    private SizeRepository sizeRepository;
    @Autowired
    public SizeImpl(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }


    @Override
    public ApiCustomize<List<SizeResponse>> sizes() {
        List<Size> sizes = this.sizeRepository.findAll();
        List<SizeResponse> sizeResponseList = new ArrayList<>();
        // Check if the categories list is null or empty
        if (sizes == null || sizes.isEmpty()) {
            String message = "No sizes found!";
            ApiCustomize<List<SizeResponse>> apiCustomize = new ApiCustomize<>();
            apiCustomize.setMessage(message);
            apiCustomize.setResult(sizeResponseList); // Returning an empty list
            return apiCustomize; // Return early if no categories found
        } else {
            for (Size size : sizes) {
                SizeResponse sizeResponse = new SizeResponse();
                sizeResponse.setId(size.getId());
                sizeResponse.setName(size.getName());
                sizeResponseList.add(sizeResponse);
            }
            String message = "All color retrieved successfully!";
            ApiCustomize<List<SizeResponse>> apiCustomize = new ApiCustomize<>();
            apiCustomize.setMessage(message);
            apiCustomize.setResult(sizeResponseList);
            return apiCustomize;
        }

    }
}

