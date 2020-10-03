package Utils;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest {

    public static void main(String[] args) throws SQLException {

        /*
        What interface u use for connect to database
        Connection
        Statement
        ResultSet
         */

        Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@duzgundatabase.cxc573ikkvq4.us-east-2.rds.amazonaws.com:1521/ORCL",
                     "duzgunDatabase",
                "duzgunDatabase"); // host(URL) , username, password

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from employees");

        resultSet.next();
        System.out.println(resultSet.getString("FIRST_NAME"));
        System.out.println(resultSet.getString("SALARY"));

        resultSet.next(); // return type is true or false
        System.out.println(resultSet.getString("First_name"));

        while (resultSet.next()){// resultSet.next() == true
    //        System.out.println(resultSet.getString("First_name"));
           // System.out.println(resultSet.getString("SALARY"));
        }

        // ************** DatabaseMetaData -> to get information about database ***********

        DatabaseMetaData metaData = connection.getMetaData();
        System.out.println("user: "+metaData.getUserName());
        System.out.println("Product name: "+metaData.getDatabaseProductName());

        //*************** resultSetMetaData -> to get column names **************

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        System.out.println(resultSetMetaData.getColumnCount());
        System.out.println(resultSetMetaData.getColumnName(1));

        List<Map<String,Object>> data = new ArrayList<>();

        resultSet.beforeFirst();
        while (resultSet.next()){
            Map<String, Object> map = new HashMap<>();
            for(int i=1; resultSetMetaData.getColumnCount()>=i; i++){
                map.put(resultSetMetaData.getColumnName(i), resultSet.getObject(resultSetMetaData.getColumnName(i)));
            }
            data.add(map);

        }

        System.out.println(data.get(0).get("FIRST_NAME"));

        // using data list of maps print names who has salary more than 10000

        for(int i=0; i<data.size(); i++){
            if(Integer.parseInt(data.get(i).get("SALARY").toString())>10000){
                System.out.println(data.get(i).get("FIRST_NAME"));
            }
        }


    }
}
