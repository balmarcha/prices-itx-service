package es.bxg.ps.pricelist.adapters.mapper;

import es.bxg.ps.common.mapper.IGenericDtoMapper;
import es.bxg.ps.model.PriceListDto;
import es.bxg.ps.pricelist.model.PriceList;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPriceListDtoMapper extends IGenericDtoMapper<PriceList, PriceListDto> {
}
