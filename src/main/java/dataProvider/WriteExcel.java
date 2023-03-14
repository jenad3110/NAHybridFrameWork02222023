package dataProvider;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class WriteExcel {


    public static class WriteExcelDemo {

        public static void main(String[] args) {


            //Blank workbook
            XSSFWorkbook workbook = new XSSFWorkbook();

            //Create a blank sheet
            XSSFSheet sheet = workbook.createSheet("Product data");

            //This data needs to be written (Object[])
            Map<String,
                    Object[]> data = new TreeMap<>();

            data.put("1", new Object[]{"ID","NAME","PRICE" });
            data.put("2", new Object[]{"Id01","Mouse",1000});
            data.put("3", new Object[]{"id02","Keyboard",1200});
            data.put("4",new Object[]{"id03","Screen",1500});


            //Iterate over data and write to sheet
            Set<String> keyset = data.keySet();
            int rownum = 0;
            for (String key : keyset) {
                Row row = sheet.createRow(rownum++);
                Object[] objArr = data.get(key);
                int cellnum = 0;
                for (Object obj : objArr) {
                    Cell cell = row.createCell(cellnum++);
                    if (obj instanceof String) cell.setCellValue((String) obj);
                    else if (obj instanceof Integer) cell.setCellValue((Integer) obj);
                }
            }
            try {
                //Write the workbook in file system
                FileOutputStream out = new FileOutputStream("Product.xlsx");
                workbook.write(out);
                out.close();
                System.out.println("java_demo.xlsx written successfully on disk.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
