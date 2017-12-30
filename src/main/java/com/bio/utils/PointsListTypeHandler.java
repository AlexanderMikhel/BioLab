package com.bio.utils;

import com.bio.domain.Point;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Mikhel Alexander on 31.12.2017 email mikhelas@altarix.ru .
 * Доработать обработку исключений
 * */
public class PointsListTypeHandler implements TypeHandler<List<Point>> {
    @Override
    public void setParameter(PreparedStatement ps, int columnIndex, List<Point> parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(columnIndex, serializeToJson(parameter));
    }

    @Override
    public List<Point> getResult(ResultSet rs, String columnName) throws SQLException {
        return deserializeFromJson(rs.getString(columnName));
    }

    @Override
    public List<Point> getResult(ResultSet rs, int columnIndex) throws SQLException {
        return deserializeFromJson(rs.getString(columnIndex));
    }

    @Override
    public List<Point> getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return deserializeFromJson(cs.getString(columnIndex));
    }

    private String serializeToJson(List<Point> parameter){
        if (parameter == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(parameter);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Point> deserializeFromJson(String value) {
        if (value == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(value, new TypeReference<List<Point>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
