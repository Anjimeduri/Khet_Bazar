package com.khet_bazar.utils;

import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.util.Properties;

public class IdGenerator extends SequenceStyleGenerator {
    private static final int DEFAULT_INCREMENT_SIZE = 1;

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) {
        String sequenceName = params.get("jpa_entity_name").toString().toLowerCase() + "_sequence"; // e.g. "buyer_seq"
        System.out.println("sequenceName" + sequenceName);
        params.put(SEQUENCE_PARAM, sequenceName);
        params.put(INCREMENT_PARAM, String.valueOf(DEFAULT_INCREMENT_SIZE));
        params.put(OPT_PARAM, "pooled-lo");

        super.configure(type, params, serviceRegistry);
    }
}