package es.bxg.ps.price.exception;

import java.util.NoSuchElementException;

public class PriceNotFoundException extends NoSuchElementException {

  private static final long serialVersionUID = 1L;

  public PriceNotFoundException() {
  }

  public PriceNotFoundException(String errorMessage) {
    super(errorMessage);
  }
}