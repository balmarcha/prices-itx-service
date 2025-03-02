package es.bxg.ps.common;

import java.util.List;

public interface IGenericDboMapper<E, P> {
  E toEntity(P pojo);

  P toPojo(E entity);

  List<E> toEntity(Iterable<P> pojos);

  List<P> toPojo(Iterable<E> entities);
}

