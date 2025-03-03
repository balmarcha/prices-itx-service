package es.bxg.ps.price.adapters.filter;

import es.bxg.ps.price.adapters.entity.PriceEntity;
import es.bxg.ps.price.adapters.filter.order.PriceOrderStrategy;
import es.bxg.ps.price.adapters.filter.specifications.PriceSpecificationStrategy;
import es.bxg.ps.price.filter.PriceFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.stream.Stream;

public class PriceFilterAdapterTest {

  @ParameterizedTest
  @MethodSource("strategyDataProvider")
  void buildSpecification(List<PriceSpecificationStrategy> strategies, Specification<PriceEntity> expected) {

    PriceFilterAdapter adapter = new PriceFilterAdapter(List.of(), strategies);

    Specification<PriceEntity> result = adapter.buildSpecification(PriceFilter.builder().build());

    Assertions.assertEquals(expected, result);
  }

  @ParameterizedTest
  @MethodSource("sortDataProvider")
  void getSort(List<PriceOrderStrategy> sorts, Sort expected) {

    PriceFilterAdapter adapter = new PriceFilterAdapter(sorts, List.of());

    Sort sort = adapter.getSort(PriceFilter.builder().build());

    Assertions.assertEquals(expected, sort);
  }

  static Stream<Arguments> strategyDataProvider() {

    PriceSpecificationStrategy strategy = Mockito.mock(PriceSpecificationStrategy.class);
    Specification<PriceEntity> specification = (root, query, cb) -> cb.equal(root.get("brandId"), 1);

    Mockito.when(strategy.apply(Mockito.any())).thenReturn(specification);

    return Stream.of(
        Arguments.of(List.of(), null),
        Arguments.of(List.of(strategy), specification)
    );
  }

  static Stream<Arguments> sortDataProvider() {

    PriceOrderStrategy order = Mockito.mock(PriceOrderStrategy.class);
    Sort prioritySort = Sort.by("priority").descending();

    PriceOrderStrategy multiOrder = Mockito.mock(PriceOrderStrategy.class);
    Sort multiSort = prioritySort.and(Sort.by("date").descending());

    Mockito.when(order.getSort(Mockito.any())).thenReturn(prioritySort);
    Mockito.when(multiOrder.getSort(Mockito.any())).thenReturn(multiSort);

    return Stream.of(
        Arguments.of(List.of(), Sort.unsorted()),
        Arguments.of(List.of(order), prioritySort),
        Arguments.of(List.of(multiOrder), multiSort)
    );
  }
}