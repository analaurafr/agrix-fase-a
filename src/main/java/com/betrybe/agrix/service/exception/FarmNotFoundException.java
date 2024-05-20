package com.betrybe.agrix.service.exception;

/**
 * The type Farm not found exception.
 */
public class FarmNotFoundException extends Exception {
  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}
