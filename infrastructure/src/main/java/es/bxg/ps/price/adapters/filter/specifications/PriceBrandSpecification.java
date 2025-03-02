package es.bxg.ps.price.adapters.filter.specifications;

import es.bxg.ps.brand.adapters.entity.BrandEntity_;
import es.bxg.ps.price.adapters.entity.PriceEntity;
import es.bxg.ps.price.adapters.entity.PriceEntity_;
import es.bxg.ps.price.filter.PriceFilter;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PriceBrandSpecification implements PriceSpecificationStrategy {

  @Override
  public Specification<PriceEntity> apply(PriceFilter filter) {
    return (root, query, cb) -> {
      List<Predicate> predicates = new ArrayList<>();

      if (filter.getBrandId() != null) {
        predicates.add(cb.equal(root.get(PriceEntity_.BRAND).get(BrandEntity_.ID), filter.getBrandId()));
      }

      return cb.and(predicates.toArray(new Predicate[0]));
    };
  }
}
