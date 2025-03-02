package es.bxg.ps.brand.adapters.mapper;

import es.bxg.ps.brand.adapters.entity.BrandEntity;
import es.bxg.ps.brand.model.Brand;
import es.bxg.ps.common.mapper.IGenericDboMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IBrandDboMapper extends IGenericDboMapper<BrandEntity, Brand> {
}

