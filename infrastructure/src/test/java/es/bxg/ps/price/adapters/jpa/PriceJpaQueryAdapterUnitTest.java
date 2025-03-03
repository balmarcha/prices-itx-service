package es.bxg.ps.price.adapters.jpa;

import es.bxg.ps.price.adapters.entity.PriceEntity;
import es.bxg.ps.price.adapters.filter.PriceFilterAdapter;
import es.bxg.ps.price.adapters.mapper.IPriceDboMapper;
import es.bxg.ps.price.adapters.repository.IPriceRepository;
import es.bxg.ps.price.filter.PriceFilter;
import es.bxg.ps.price.model.Price;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class PriceJpaQueryAdapterUnitTest {

  @InjectMocks
  private PriceJpaQueryAdapter priceJpaQueryAdapter;

  @Mock
  private IPriceDboMapper mapper;

  @Mock
  private IPriceRepository repository;

  @Mock
  private PriceFilterAdapter jpaFilter;

  @Test
  void findByFiltersEmpty() {
    Sort sort = Sort.unsorted();
    Specification<PriceEntity> spec = Mockito.mock(Specification.class);

    Mockito.when(mapper.toPojo(Mockito.anyList())).thenReturn(List.of());
    Mockito.when(jpaFilter.buildSpecification(Mockito.any())).thenReturn(spec);
    Mockito.when(jpaFilter.getSort(Mockito.any())).thenReturn(sort);
    Mockito.when(repository.findAll(spec, sort)).thenReturn(List.of());

    List<Price> result = priceJpaQueryAdapter.findByFilters(PriceFilter.builder().build());

    Assertions.assertTrue(result.isEmpty());

    Mockito.verify(mapper, Mockito.times(1)).toPojo(Mockito.anyList());
    Mockito.verify(jpaFilter, Mockito.times(1)).buildSpecification(Mockito.any());
    Mockito.verify(jpaFilter, Mockito.times(1)).getSort(Mockito.any());
    Mockito.verify(repository, Mockito.times(1)).findAll(spec, sort);
  }

  void findByFiltersNoEmpty() {
    Sort sort = Sort.unsorted();
    Specification<PriceEntity> spec = Mockito.mock(Specification.class);

    Mockito.when(mapper.toPojo(Mockito.anyList())).thenReturn(List.of(Price.builder().id(1L).build()));
    Mockito.when(jpaFilter.buildSpecification(Mockito.any())).thenReturn(spec);
    Mockito.when(jpaFilter.getSort(Mockito.any())).thenReturn(sort);
    Mockito.when(repository.findAll(spec, sort)).thenReturn(List.of());

    List<Price> result = priceJpaQueryAdapter.findByFilters(PriceFilter.builder().build());

    Assertions.assertFalse(result.isEmpty());
    Assertions.assertEquals(1L, result.getFirst().getId());

    Mockito.verify(mapper, Mockito.times(1)).toPojo(Mockito.anyList());
    Mockito.verify(jpaFilter, Mockito.times(1)).buildSpecification(Mockito.any());
    Mockito.verify(jpaFilter, Mockito.times(1)).getSort(Mockito.any());
    Mockito.verify(repository, Mockito.times(1)).findAll(spec, sort);
  }
}