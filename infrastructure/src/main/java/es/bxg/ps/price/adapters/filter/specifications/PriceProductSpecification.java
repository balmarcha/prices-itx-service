package es.bxg.ps.price.adapters.filter.specifications;

import es.bxg.ps.price.adapters.entity.PriceEntity;
import es.bxg.ps.price.adapters.entity.PriceEntity_;
import es.bxg.ps.price.filter.PriceFilter;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PriceProductSpecification implements PriceSpecificationStrategy {

  @Override
  public Specification<PriceEntity> apply(PriceFilter filter) {
    return (root, query, cb) -> {
      List<Predicate> predicates = new ArrayList<>();

      if (filter.getProductId() != null) {
        predicates.add(cb.equal(root.get(PriceEntity_.PRODUCT).get(PriceEntity_.ID), filter.getProductId()));
      }

      return cb.and(predicates.toArray(new Predicate[0]));
    };
  }
}
