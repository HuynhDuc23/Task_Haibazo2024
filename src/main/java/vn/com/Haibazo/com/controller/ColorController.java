package vn.com.Haibazo.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.Haibazo.com.dto.response.ApiCustomize;
import vn.com.Haibazo.com.dto.response.CategoryResponse;
import vn.com.Haibazo.com.dto.response.ColorResponse;
import vn.com.Haibazo.com.service.services.ColorService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/colors")
public class ColorController {
    private ColorService colorService ;
    @Autowired
    public ColorController(ColorService colorService) {
        this.colorService = colorService ;
    }
    @GetMapping("/")
    public ResponseEntity<ApiCustomize<List<ColorResponse>>>colors() {
        ApiCustomize<List<ColorResponse>> colors = this.colorService.colors();
        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Value"); // Add your custom headers here
        return new ResponseEntity<>(colors, headers, HttpStatus.OK);
    }
}
