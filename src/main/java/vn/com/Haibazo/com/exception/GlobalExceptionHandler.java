package vn.com.Haibazo.com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import vn.com.Haibazo.com.dto.response.ApiCustomize;
import vn.com.Haibazo.com.enums.ApiError;

@ControllerAdvice
public class GlobalExceptionHandler {
     @ExceptionHandler(value = Exception.class)
     public ResponseEntity<ApiCustomize<String>> handlingIllegalStateException(Exception ex){

          ApiCustomize apiCustomize = new ApiCustomize();
          apiCustomize.setCode(ErrorCode.HTTP_REQUEST_ENDPOINT_SUPPORT.getCode());
          apiCustomize.setMessage(ErrorCode.HTTP_REQUEST_ENDPOINT_SUPPORT.getMessage());
          apiCustomize.setResult(ex.getMessage());

          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiCustomize);
     }
     @ExceptionHandler(value = RuntimeException.class)
     public ResponseEntity<ApiCustomize<String>> handlingRuntimeExcetion(RuntimeException ex){

          ApiCustomize apiCustomize = new ApiCustomize();
          apiCustomize.setCode(ApiError.BAD_REQUEST.getCode());
          apiCustomize.setMessage(ApiError.BAD_REQUEST.getMessage());
          apiCustomize.setResult(ex.getMessage());

          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiCustomize);

     }
     @ExceptionHandler(value = ProductNotFound.class)
     public ResponseEntity<ApiCustomize<String>> handlingProductNotFound(ProductNotFound ex){
          ErrorCode errorCode = ex.getErrorCode();
          ApiCustomize apiCustomize = new ApiCustomize();
          apiCustomize.setCode(errorCode.getCode());
          apiCustomize.setMessage(errorCode.getMessage());
          apiCustomize.setResult(ex.getMessage());

          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiCustomize);

     }
}
