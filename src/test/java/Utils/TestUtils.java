package Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TestUtils {

    public static void main(String[] args) throws SQLException, IOException {

        JDBCUtils.establishConnection();
        List<Map<String,Object>> data=JDBCUtils.runQuery("select first_name,last_name,salary from employees");
        JDBCUtils.closeConnection();
        for(int i=0; i<data.size(); i++) {
            if(data.get(i).get("FIRST_NAME").equals("Steven")){
                System.out.println(data.get(i).get("SALARY"));
            }

        }

        ExcelUtils.openExcel("TestData","Sheet1");
        System.out.println(ExcelUtils.getValue(1,1));

        ExcelUtils.setValue("Srikkanth",5,0);
        System.out.println(ExcelUtils.getNumberOfCells(1));
    }
}
