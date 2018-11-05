package VDreams.AutocodeGen;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * All Excel related Actions
 *
 */
public class ReadWriteExcel 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
//        readFirstRow("D:\\Satish Chanaveeragoudar\\eclipse-workspace-satish\\AutocodeGen\\GenExcel\\Testing CDG - Appraisal - Standard Goals - 2015_16_V1 1.xls");
//        loadExcelLines("D:\\Satish Chanaveeragoudar\\eclipse-workspace-satish\\AutocodeGen\\GenExcel\\Testing CDG - Appraisal - Standard Goals - 2015_16_V1 1.xls");
    }
    
    
    public static void readFirstRow(String filename)
    {

        List<String> fieldsArrayList = new ArrayList<String>();

         try{

                FileInputStream myInput = new FileInputStream(new File(filename));

                Workbook workBook = null;

                workBook    = new HSSFWorkbook(myInput);

                Sheet sheet = workBook.getSheetAt(0);

                Row firstRow = sheet.getRow(0);

                int length  = firstRow.getLastCellNum();

                org.apache.poi.ss.usermodel.Cell cell = null;

                for( int i = 0 ; i < length ; i++ )

                    {
                         cell = firstRow.getCell(i);

                         fieldsArrayList.add(cell.toString());

                    }
                
                System.out.println(fieldsArrayList);

         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
    }
    
    public static HashMap loadExcelLines(String  fileName)
    {
        // Used the LinkedHashMap and LikedList to maintain the order
        HashMap<String, LinkedHashMap<Integer, List>> outerMap = new LinkedHashMap<String, LinkedHashMap<Integer, List>>();

        LinkedHashMap<Integer, List> hashMap = new LinkedHashMap<Integer, List>();

        String sheetName = null;
        // Create an ArrayList to store the data read from excel sheet.
        // List sheetData = new ArrayList();
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(fileName);
            // Create an excel workbook from the file system
            Workbook workBook = new HSSFWorkbook(fis);
            // Get the first sheet on the workbook.
            for (int i = 0; i < workBook.getNumberOfSheets(); i++)
            {
                Sheet sheet = workBook.getSheetAt(i);
                // XSSFSheet sheet = workBook.getSheetAt(0);
                sheetName = workBook.getSheetName(i);

                Iterator rows = sheet.rowIterator();
                while (rows.hasNext())
                {
                    HSSFRow row = (HSSFRow) rows.next();
                    Iterator cells = row.cellIterator();

                    List data = new LinkedList();
                    while (cells.hasNext())
                    {
                        HSSFCell cell = (HSSFCell) cells.next();
//                        cell.setCellType(cell.CELL_TYPE_STRING);
                        
                        data.add(cell);
                    }
                    hashMap.put(row.getRowNum(), data);

                    System.out.println(data);
                    // sheetData.add(data);
                }
                outerMap.put(sheetName, hashMap);
                hashMap = new LinkedHashMap<Integer, List>();
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (fis != null)
            {
                try
                {
                    fis.close();
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return outerMap;

    }
}
    
//}
