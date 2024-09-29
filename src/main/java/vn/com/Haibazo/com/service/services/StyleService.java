package vn.com.Haibazo.com.service.services;

import org.springframework.stereotype.Service;
import vn.com.Haibazo.com.dto.response.ApiCustomize;
import vn.com.Haibazo.com.dto.response.ColorResponse;
import vn.com.Haibazo.com.dto.response.StyleResponse;

import java.util.List;

@Service
public interface StyleService {
    public ApiCustomize<List<StyleResponse>> styles();
}
