package com.schoolproject.movie_rentaldashboard.dao.mysql.helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class MoveCastConversionHelper {

    // Helper method to convert comma-separated String to List<String>
    public static List<String> convertStringToList(String castString) {
        return Arrays.asList(castString.split(","));
    }

    // Helper method to convert List<String> to comma-separated String
    public static String convertListToString(List<String> castList) {
        return String.join(",", castList);
    }

    // Helper method to set List<String> in PreparedStatement
    public static void setListInPreparedStatement(PreparedStatement preparedStatement, int index, List<String> castList) throws SQLException {
        String castString = convertListToString(castList);
        preparedStatement.setString(index, castString);
    }

    // Helper method to get List<String> from ResultSet
    public static List<String> getListFromResultSet(ResultSet resultSet, String columnName) throws SQLException {
        String castString = resultSet.getString(columnName);
        return convertStringToList(castString);
    }
}
