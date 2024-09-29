package vn.com.Haibazo.com.exception;

public class ProductNotFound extends RuntimeException{
    private ErrorCode errorCode ;


    public ProductNotFound(ErrorCode errorCode) {
        super(errorCode.getMessage());// data send runtimeexception
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
