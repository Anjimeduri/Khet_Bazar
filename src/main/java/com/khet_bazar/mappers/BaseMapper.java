//package com.khet_bazar.mappers;
//
//import com.khet_bazar.entity.BaseEntity;
//import org.mapstruct.BeanMapping;
//import org.mapstruct.MappingTarget;
//import org.mapstruct.NullValuePropertyMappingStrategy;
//
//public interface BaseMapper<D, E extends BaseEntity> {
//    D toDTO(E entity);
//
//    // just sets the changed fields. Unchanged fields will remain as it is.
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    E toEntity(D dto, @MappingTarget E entity);
//}
