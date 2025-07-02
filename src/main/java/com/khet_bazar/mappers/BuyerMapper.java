//package com.khet_bazar.mappers;
//
//import com.khet_bazar.entity.Buyer;
//import org.mapstruct.*;
//import org.mapstruct.factory.Mappers;
//
//@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
//        unmappedTargetPolicy = ReportingPolicy.IGNORE,
//        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
//        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//public interface BuyerMapper extends BaseMapper<Buyer, Buyer> {
//    BuyerMapper INSTANCE = Mappers.getMapper(BuyerMapper.class);
//
//    @Override
//    public Buyer toDTO(Buyer buyer);
//
//    @Override
//    public Buyer toEntity(Buyer buyerDto, Buyer buyerEntity);
//}
