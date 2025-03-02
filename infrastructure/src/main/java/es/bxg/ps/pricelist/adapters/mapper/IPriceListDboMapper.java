package es.bxg.ps.pricelist.adapters.mapper;

import es.bxg.ps.common.mapper.IGenericDboMapper;
import es.bxg.ps.pricelist.adapters.entity.PriceListEntity;
import es.bxg.ps.pricelist.model.PriceList;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPriceListDboMapper extends IGenericDboMapper<PriceListEntity, PriceList> {
}

