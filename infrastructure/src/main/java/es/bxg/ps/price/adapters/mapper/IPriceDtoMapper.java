package es.bxg.ps.price.adapters.mapper;

import es.bxg.ps.common.IGenericDtoMapper;
import es.bxg.ps.model.PriceDto;
import es.bxg.ps.price.model.Price;
import es.bxg.ps.pricelist.adapters.mapper.IPriceListDtoMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = IPriceListDtoMapper.class)
public interface IPriceDtoMapper extends IGenericDtoMapper<Price, PriceDto> {

  @Mapping(source = "brand.id", target = "brandId")
  @Mapping(source = "product.id", target = "productId")
  PriceDto toDto(Price pojo);

  @InheritInverseConfiguration
  Price toPojo(PriceDto dto);
}
