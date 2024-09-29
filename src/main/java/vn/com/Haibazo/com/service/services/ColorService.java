package vn.com.Haibazo.com.service.services;

import org.springframework.stereotype.Service;
import vn.com.Haibazo.com.dto.response.ApiCustomize;
import vn.com.Haibazo.com.dto.response.CategoryResponse;
import vn.com.Haibazo.com.dto.response.ColorResponse;

import java.util.List;

@Service
public interface ColorService {
    public ApiCustomize<List<ColorResponse>> colors();
}
