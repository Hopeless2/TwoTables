package com.example.twotables.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

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
    private final String scriptFileName = "data.sql";
    String sqlScript = read(scriptFileName);

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProductName(String name) {
        SqlRowSet sqlRowSet = namedParameterJdbcTemplate.queryForRowSet(sqlScript, Map.of("name", name));
        List<String> list = new ArrayList<>();
        while (sqlRowSet.next()) {
            list.add(sqlRowSet.getString("product_name"));
        }
        return list.toString();
    }
}