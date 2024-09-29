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
import vn.com.Haibazo.com.dto.response.StyleResponse;
import vn.com.Haibazo.com.service.services.CategoryService;
import vn.com.Haibazo.com.service.services.StyleService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/styles")
public class StyleController {
    private StyleService styleService ;

    @Autowired
    public StyleController(StyleService styleService) {
      this.styleService = styleService;
    }
    @GetMapping("/")
    public ResponseEntity<ApiCustomize<List<StyleResponse>>> styles() {
        ApiCustomize<List<StyleResponse>> styles = this.styleService.styles();
        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Value"); // Add your custom headers here

        return new ResponseEntity<>(styles, headers, HttpStatus.OK);
    }
}
