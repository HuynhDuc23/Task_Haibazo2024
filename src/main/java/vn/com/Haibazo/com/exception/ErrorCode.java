package vn.com.Haibazo.com.exception;

public enum ErrorCode {

    PRODUCT_NOT_FOUND("404","User Not Found"),
    HTTP_REQUEST_ENDPOINT_SUPPORT("9999","BAD ENDPOINT"),
    AVARAGE_STARS("400", "Rating must be at least 1 star and Rating must not exceed 5 stars"),
    HTTP_MESSAGE_NOTREADABLE_EXCEPTION("400","Please enter the correct data type"),
    FIELD_("400","Trường này phải có cả chữ và số và độ dài tối thiểu là 4 ký tự");
    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code = "9999";
    private String message ;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
