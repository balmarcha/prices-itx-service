package es.bxg.ps.price.exception;

public class PriceNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private String errorMessage;

  public PriceNotFoundException() {
  }

  public PriceNotFoundException(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
}