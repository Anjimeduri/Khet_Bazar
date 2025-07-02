package com.khet_bazar.repository;

import com.khet_bazar.entity.Buyer;

import java.util.Optional;

public interface BuyerRepository extends BaseRepository<Buyer> {
    Optional<Buyer> findById(Long Long);
}
