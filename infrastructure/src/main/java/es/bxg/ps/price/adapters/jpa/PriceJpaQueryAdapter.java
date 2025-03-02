package es.bxg.ps.price.adapters.jpa;

import es.bxg.ps.price.adapters.filter.PriceFilterAdapter;
import es.bxg.ps.price.adapters.mapper.IPriceDboMapper;
import es.bxg.ps.price.adapters.repository.IPriceRepository;
import es.bxg.ps.price.filter.PriceFilter;
import es.bxg.ps.price.model.Price;
import es.bxg.ps.price.port.IPriceQueryPort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PriceJpaQueryAdapter implements IPriceQueryPort {

  private final IPriceDboMapper mapper;
  private final IPriceRepository repository;
  private final PriceFilterAdapter jpaFilter;

  public PriceJpaQueryAdapter(IPriceDboMapper mapper, IPriceRepository repository, PriceFilterAdapter jpaFilter) {
    this.mapper = mapper;
    this.jpaFilter = jpaFilter;
    this.repository = repository;
  }

  @Override
  public List<Price> findByFilters(PriceFilter filter) {
    return mapper.toPojo(
        repository.findAll(jpaFilter.buildSpecification(filter)));
  }
}
