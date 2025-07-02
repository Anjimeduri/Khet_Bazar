package com.khet_bazar.service;

import com.khet_bazar.entity.Buyer;
import com.khet_bazar.repository.BuyerRepository;
import org.springframework.stereotype.Service;

@Service
public class BuyersService extends BaseService<Buyer> {
    public BuyersService(BuyerRepository repository) {
        super(repository);
    }

    @Override
    public BuyerRepository getRepository() {
        return (BuyerRepository) this.repository;
    }
}
