package com.nepalaya.jdbc.db;

import java.sql.ResultSet;

public interface RowMapper<T> {

    T map(ResultSet resultSet) throws Exception;
}
