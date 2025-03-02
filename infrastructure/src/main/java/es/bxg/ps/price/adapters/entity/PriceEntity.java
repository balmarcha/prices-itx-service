package es.bxg.ps.price.adapters.entity;

import es.bxg.ps.brand.adapters.entity.BrandEntity;
import es.bxg.ps.pricelist.adapters.entity.PriceListEntity;
import es.bxg.ps.product.adapters.entity.ProductEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "prices")
public class PriceEntity {

  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "start_date")
  private OffsetDateTime startDate;

  @Column(name = "end_date")
  private OffsetDateTime endDate;

  @Column(name = "priority")
  private short priority;

  @Column(name = "price")
  private BigDecimal price;

  @Column(name = "currency")
  private String currency;

  @ManyToOne
  @JoinColumn(name = "brand_id")
  private BrandEntity brand;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private ProductEntity product;

  @ManyToOne
  @JoinColumn(name = "price_list_id")
  private PriceListEntity priceList;
}