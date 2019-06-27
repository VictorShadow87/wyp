package com.alpha.heroku.test.exception;

/**
 * @author huiyan.yao
 * @Description:
 * @date 2018/10/6 22:44
 **/
public class ValidateException extends RuntimeException {

  private String errorCode;

  public ValidateException(final String errorCode) {
    super(errorCode);
    this.errorCode = errorCode;
  }

  public ValidateException(final String message, final String errorCode) {
    super(message);
    this.errorCode = errorCode;
  }

  public String getErrorCode() {
    return errorCode;
  }
}