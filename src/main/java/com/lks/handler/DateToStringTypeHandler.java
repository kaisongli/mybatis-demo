package com.lks.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by likaisong on 2019/2/25.
 */
public class DateToStringTypeHandler implements TypeHandler{
    /**
     * 将时间戳传入数据库
     * @param preparedStatement
     * @param i
     * @param o
     * @param jdbcType
     * @throws java.sql.SQLException
     */
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Object o, JdbcType jdbcType) throws SQLException {
        Date date = (Date) o;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        preparedStatement.setString(i, dateString);
    }

    /**
     * 将字符串类型的时间戳转换为Date
     * @param resultSet
     * @param s
     * @return
     * @throws SQLException
     */
    @Override
    public Object getResult(ResultSet resultSet, String s) throws SQLException {
        String timeStr = resultSet.getString(s);
        if (timeStr != null || "".equals(timeStr)){
            return stringToDate(timeStr);
        }
        return null;
    }

    @Override
    public Object getResult(ResultSet resultSet, int i) throws SQLException {
        String timeStr = resultSet.getString(i);
        if (timeStr != null || "".equals(timeStr)){
            return stringToDate(timeStr);
        }
        return null;
    }

    @Override
    public Object getResult(CallableStatement callableStatement, int i) throws SQLException {
        String timeStr = callableStatement.getString(i);
        if (timeStr != null || "".equals(timeStr)){
            return stringToDate(timeStr);
        }
        return null;
    }

    private Date stringToDate(String timeStr) {
        if (timeStr != null || "".equals(timeStr)) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ParsePosition pos = new ParsePosition(0);
            Date date = formatter.parse(timeStr, pos);
            return date;
        }
        return null;
    }
}
