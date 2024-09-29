package vn.com.Haibazo.com.service.services;

import org.springframework.stereotype.Service;
import vn.com.Haibazo.com.dto.response.ApiCustomize;
import vn.com.Haibazo.com.dto.response.SizeResponse;

import java.util.List;

@Service
public interface SizeService {
    public ApiCustomize<List<SizeResponse>> sizes();
}
