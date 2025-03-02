package es.bxg.ps.pricelist.adapters.mapper;

import es.bxg.ps.common.IGenericDtoMapper;
import es.bxg.ps.model.PriceDto;
import es.bxg.ps.model.PriceListDto;
import es.bxg.ps.price.model.Price;
import es.bxg.ps.pricelist.model.PriceList;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IPriceListDtoMapper extends IGenericDtoMapper<PriceList, PriceListDto> {
}
