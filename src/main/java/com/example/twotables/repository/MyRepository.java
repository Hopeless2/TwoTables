package com.example.twotables.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public String getProductName(String name) {
        Query query = entityManager.createQuery("select o.productName from Order o join Customer c on o.customer.id = c.id where c.name = :name", String.class);
        query.setParameter("name", name);
        var queryResultList = query.getResultList();
        StringBuilder stringBuilder = new StringBuilder();
        for (Object o : queryResultList) {
            stringBuilder.append(o.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
