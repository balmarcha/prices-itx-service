package es.bxg.ps.price.adapters.mapper;

import es.bxg.ps.brand.adapters.mapper.IBrandDboMapper;
import es.bxg.ps.common.mapper.IGenericDboMapper;
import es.bxg.ps.price.adapters.entity.PriceEntity;
import es.bxg.ps.price.model.Price;
import es.bxg.ps.pricelist.adapters.mapper.IPriceListDboMapper;
import es.bxg.ps.product.adapters.mapper.IProductDboMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {IBrandDboMapper.class, IProductDboMapper.class, IPriceListDboMapper.class})
public interface IPriceDboMapper extends IGenericDboMapper<PriceEntity, Price> {
}

