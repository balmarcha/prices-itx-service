package es.bxg.ps.product.adapters.mapper;

import es.bxg.ps.common.IGenericDboMapper;
import es.bxg.ps.product.adapters.entity.ProductEntity;
import es.bxg.ps.product.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProductDboMapper extends IGenericDboMapper<ProductEntity, Product> {
}

