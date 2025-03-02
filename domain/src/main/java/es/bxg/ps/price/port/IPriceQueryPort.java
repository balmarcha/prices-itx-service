package es.bxg.ps.price.port;

import es.bxg.ps.price.filter.PriceFilter;
import es.bxg.ps.price.model.Price;

import java.util.List;

public interface IPriceQueryPort {

  List<Price> findByFilters(PriceFilter filter);

}
