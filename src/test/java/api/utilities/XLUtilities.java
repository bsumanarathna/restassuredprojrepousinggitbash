package api.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class XLUtilities {

    public FileOutputStream fo;
    public FileInputStream fi;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;
    public XSSFCellStyle style;
    String path;
    public XLUtilities(String path)
    {this.path= path;
    }


    public int getRowCount(String workSheet) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(workSheet);
        int rowCount= sheet.getLastRowNum();
        workbook.close();
        fi.close();
        return rowCount;
    }

    public int getColCount(String workSheet,int rowNum) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(workSheet);
        row = sheet.getRow(rowNum);
        int count = row.getLastCellNum();
        workbook.close();
        fi.close();
        return count;
    }

    public String celldata(String workSheet,int rowNum,int colNum) throws IOException
    {
        fi= new FileInputStream(path);
        workbook= new XSSFWorkbook(fi);
        sheet = workbook.getSheet(workSheet);
        row= sheet.getRow(rowNum);
        cell=row.getCell(colNum);

        DataFormatter df=new DataFormatter();
            String data;
        try {
            data = df.formatCellValue(cell);

        }
        catch (Exception e)
        {data="";
        }
        workbook.close();
        fi.close();
        return workSheet;
    }
}
