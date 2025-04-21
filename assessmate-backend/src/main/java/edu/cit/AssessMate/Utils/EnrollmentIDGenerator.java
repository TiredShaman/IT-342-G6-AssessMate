package edu.cit.AssessMate.Utils;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.util.UUID;

public class EnrollmentIDGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        // Generate a unique ID with prefix "EN" followed by first 8 characters of a
        // UUID
        return "EN" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}