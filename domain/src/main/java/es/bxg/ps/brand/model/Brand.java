package es.bxg.ps.brand.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Brand {
  private Long id;
  private String name;
}
