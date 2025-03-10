package es.bxg.ps.product.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Product {
  private Long id;
  private String name;
}
