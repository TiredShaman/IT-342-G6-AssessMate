package edu.cit.AssessMate.Utils;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import jakarta.persistence.Query;

public class QuizIDGenerator implements IdentifierGenerator {

    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String prefix = "QuizID";

        // Query to get the maximum quiz ID
        String query = "SELECT MAX(q.quizID) FROM Quiz q WHERE q.quizID LIKE 'QuizID%'";
        String maxID = (String) session.createQuery(query).uniqueResult();

        int nextNumber = 1; // Start from 1 instead of 0
        if (maxID != null && maxID.length() >= 9) {
            String numberStr = maxID.substring(6); // Extract the number part
            try {
                nextNumber = Integer.parseInt(numberStr) + 1;
            } catch (NumberFormatException e) {
                // If parsing fails, start from 1
                nextNumber = 1;
            }
        }

        // Format the number with leading zeros
        return String.format("%s%03d", prefix, nextNumber);
    }
}