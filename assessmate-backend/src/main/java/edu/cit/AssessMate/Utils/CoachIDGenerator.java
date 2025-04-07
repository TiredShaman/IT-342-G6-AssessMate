package edu.cit.AssessMate.Utils;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CoachIDGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String prefix = "COACH";
        try (Connection connection = session.getJdbcConnectionAccess().obtainConnection();
                Statement statement = connection.createStatement();
                ResultSet rs = statement
                        .executeQuery("SELECT MAX(CAST(SUBSTRING(coach_id, 6) AS UNSIGNED)) FROM coaches")) {

            int nextId = 1;
            if (rs.next() && rs.getString(1) != null) {
                nextId = rs.getInt(1) + 1;
            }
            return prefix + String.format("%03d", nextId);
        } catch (SQLException e) {
            throw new HibernateException("Unable to generate Coach ID", e);
        }
    }
}