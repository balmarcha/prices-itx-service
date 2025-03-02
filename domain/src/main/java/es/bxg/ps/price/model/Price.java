package es.bxg.ps.price.model;

import es.bxg.ps.brand.model.Brand;
import es.bxg.ps.pricelist.model.PriceList;
import es.bxg.ps.product.model.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
public class Price {
  private Long id;
  private OffsetDateTime startDate;
  private OffsetDateTime endDate;
  private short priority;
  private BigDecimal price;
  private String currency;
  private Brand brand;
  private Product product;
  private PriceList priceList;
}