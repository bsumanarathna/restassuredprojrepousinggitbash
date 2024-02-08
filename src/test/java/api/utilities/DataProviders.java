package api.utilities;

import org.jetbrains.annotations.NotNull;
import org.testng.annotations.DataProvider;

import java.io.IOException;


public class DataProviders {

    @DataProvider(name = "Dataset")
    public static String[][] setData() throws IOException {
        String path = System.getProperty("user.dir")+"//src//testdata//userTestData.xlsx";
        XLUtilities xl= new XLUtilities(path);
        int rownum = xl.getRowCount("Sheet1");
        int colnum= xl.getColCount("Sheet1",1);
        String data[][] = new String[rownum][colnum];
        for(int i=1;i<rownum;i++)

            for (int j=0;j<colnum;j++)
            {
                data[i-1][j]= xl.celldata("Sheet1",i,j);
            }

        return data;
    }


    @DataProvider(name = "Usernames")
    public static String[] setUsers() throws IOException {
        String path= System.getProperty("user.dir"+"//src//testdata//userTestData.xlsx");
        XLUtilities xl= new XLUtilities(path);
        int rownum = xl.getRowCount("Sheet1");


        String userdata[]= new String[rownum];
        for(int i=1; i<rownum; i++)
                {
                    userdata[i]= xl.celldata("Sheet1",i,1);
                }
        return userdata;
    }


}
