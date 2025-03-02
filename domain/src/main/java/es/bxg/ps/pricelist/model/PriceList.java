package es.bxg.ps.pricelist.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PriceList {
  private Long id;
  private String name;
}
