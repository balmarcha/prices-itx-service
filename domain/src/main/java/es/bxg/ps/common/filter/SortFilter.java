package es.bxg.ps.common.filter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class SortFilter {
  private String field;
  private SortDirection direction;
}
