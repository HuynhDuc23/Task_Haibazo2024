package vn.com.Haibazo.com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import vn.com.Haibazo.com.dto.response.ApiCustomize;
import vn.com.Haibazo.com.enums.ApiError;

@ControllerAdvice
public class GlobalExceptionHandler {
     @ExceptionHandler(value = Exception.class)
     public ResponseEntity<ApiCustomize<String>> handlingIllegalStateException(Exception ex){

          ApiCustomize apiCustomize = new ApiCustomize();
          apiCustomize.setCode(ApiError.BAD_REQUEST.getCode());
          apiCustomize.setMessage(ApiError.BAD_REQUEST.getMessage());
          apiCustomize.setResult(ex.getMessage());

          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiCustomize);
     }

     @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
     public ResponseEntity<ApiCustomize<String>> handlingMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException exception){
          ApiCustomize apiCustomize = new ApiCustomize() ;
          apiCustomize.setCode(ApiError.BAD_REQUEST.getCode());
          apiCustomize.setMessage(ApiError.BAD_REQUEST.getMessage());
          apiCustomize.setResult("Failed to convert value of parameter");
          return ResponseEntity.status(400).body(apiCustomize);
     }

     @ExceptionHandler(value = ProductNotFound.class)
     public ResponseEntity<ApiCustomize<String>> handlingProductNotFound(ProductNotFound ex){
          ErrorCode errorCode = ex.getErrorCode();
          ApiCustomize apiCustomize = new ApiCustomize();
          apiCustomize.setCode(errorCode.getCode());
          apiCustomize.setMessage(errorCode.getMessage());
          apiCustomize.setResult("Product Not Found");

          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiCustomize);

     }
     @ExceptionHandler(value = NoHandlerFoundException.class)
     public ResponseEntity<ApiCustomize<String>> handlingNoHandlerFoundException(NoHandlerFoundException exception){
          ApiCustomize apiCustomize = new ApiCustomize();
          apiCustomize.setCode(ApiError.BAD_REQUEST.getCode());
          apiCustomize.setMessage(ApiError.BAD_REQUEST.getMessage());
          apiCustomize.setResult("No handler found for the requested URL");
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiCustomize);
     }
     @ExceptionHandler(value = MethodArgumentNotValidException.class)
     public ResponseEntity<ApiCustomize<String>> handlingMethodArgumentNotValidException(MethodArgumentNotValidException exception){
          ApiCustomize apiCustomize = new ApiCustomize() ;
          String err = exception.getFieldError().getDefaultMessage();
          ErrorCode errorCode = ErrorCode.valueOf(err);
          apiCustomize.setCode(errorCode.getCode());
          apiCustomize.setMessage(errorCode.getMessage());
          return ResponseEntity.badRequest().body(apiCustomize);
     }
     @ExceptionHandler(CustomException.class)
     public ResponseEntity<String> handleCustomException(CustomException ex) {
          return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
     }
     @ExceptionHandler(HttpMessageNotReadableException.class)
     public ResponseEntity<ApiCustomize<String>> handlingHttpMessageNotReadbleException(HttpMessageNotReadableException exception){
          ApiCustomize apiCustomize = new ApiCustomize();
          apiCustomize.setCode(ErrorCode.HTTP_MESSAGE_NOTREADABLE_EXCEPTION.getCode());
          apiCustomize.setResult(ErrorCode.HTTP_MESSAGE_NOTREADABLE_EXCEPTION.getMessage());
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiCustomize);
     }


}
