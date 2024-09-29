package vn.com.Haibazo.com.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.Haibazo.com.dto.response.ApiCustomize;
import vn.com.Haibazo.com.dto.response.ColorResponse;
import vn.com.Haibazo.com.dto.response.SizeResponse;
import vn.com.Haibazo.com.service.services.SizeService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/sizes")
public class SizeController {
    private SizeService sizeService ;
    public SizeController(SizeService sizeService){
        this.sizeService = sizeService ;
    }
    @GetMapping("/")
    public ResponseEntity<ApiCustomize<List<SizeResponse>>> colors() {
        ApiCustomize<List<SizeResponse>> sizes = this.sizeService.sizes();
        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Value"); // Add your custom headers here
        return new ResponseEntity<>(sizes, headers, HttpStatus.OK);
    }
}
