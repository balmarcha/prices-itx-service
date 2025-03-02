package es.bxg.ps.common;

import java.util.List;

public interface IGenericDtoMapper<P, D> {
  D toDto(P pojo);

  P toPojo(D dto);

  List<D> toDto(Iterable<P> pojos);

  List<P> toPojo(Iterable<D> entities);
}

