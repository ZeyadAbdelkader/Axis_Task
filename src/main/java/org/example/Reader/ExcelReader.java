package org.example.Reader;

import Utilities.Constants;
import Utilities.CustomAnnotations;
import Utilities.ExcelUtilities;
import org.example.DataProviderObjects.UserRegistration;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {

    @DataProvider(name = "UserRegistration")
    public Iterator<Object[]> Credentials(Method method) {
        String testCaseName = method.getName();
        return fetchDataFromSheet(Constants.Axis_DATA_WORKBOOK,
                Constants.UserRegistration_PAGE_ENV_SHEET, testCaseName);
    }

    public Iterator<Object[]> fetchDataFromSheet(String workBookName, String sheetName, String testCaseName) {
        ExcelUtilities config = new ExcelUtilities();
        config.setTestDataExcelPath("/src/main/resources/TestData/" + workBookName);
        config.setExcelFileSheet(sheetName);
        int row = config.getLastRow();
        List<Object[]> recordsList = new ArrayList<>();

        for (int i = 1; i < row; i++) {
            if (config.getCellData(i, 0).contains(testCaseName)) {
                UserRegistration userRegistration = new UserRegistration(); // Create new instance

                Field[] fields = userRegistration.getClass().getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(CustomAnnotations.ExcelColumn.class)) {
                        CustomAnnotations.ExcelColumn excelColumn = field.getAnnotation(CustomAnnotations.ExcelColumn.class);
                        field.setAccessible(true);
                        try {
                            // Set the field value
                            field.set(userRegistration, config.getCellData(i, excelColumn.value()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                recordsList.add(new Object[]{userRegistration}); // Wrap in Object[]
            }
        }
        return recordsList.iterator();
    }
}

//    public Iterator<Object> fetchDataFromSheet(Object obj, String workBookName, String sheetName, String testCaseName) {
//            ExcelUtilities config = new ExcelUtilities();
//            config.setTestDataExcelPath("/src/main/resources/TestData/" + workBookName);
//            config.setExcelFileSheet(sheetName);
//            int row = config.getLastRow();
//            List<Object> recordsList = new ArrayList<>();
//            //Cloner cloner = new Cloner();
//
//            for (int i = 1; i < row; i++) {
//                Object tempObj;
//                if (config.getCellData(i, 0).contains(testCaseName)) {
//                    int j = 1;
//                    Field[] fields = obj.getClass().getDeclaredFields();
//                    for (Field field : fields) {
//                        if (field.isAnnotationPresent(CustomAnnotations.ExcelColumn.class)) {
//                            CustomAnnotations.ExcelColumn excelColumn = field.getAnnotation(CustomAnnotations.ExcelColumn.class);
//                            field.setAccessible(true); // should work on private fields
//                            try {
//                                if(excelColumn.value() == j) {
//                                    field.set(obj, config.getCellData(i, j++));
//                                }
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                    //empObj = cloner.deepClone(obj);
//                    //recordsList.add(tempObj);
//                }
//            }
//            return recordsList.iterator();
//        }
//}
//        static FileInputStream fis = null;
//
//        public FileInputStream getFileInputStream() {
//            String filepath= System.getProperty("user.dir")+ "/src/main/resources/TestData/ExcelData.xlsx";
//            File srcFile= new File(filepath);
//            try {
//                fis = new FileInputStream(srcFile);
//            } catch (FileNotFoundException e) {
//
//                e.printStackTrace();
//                System.out.println("Test Data File not Found: ");
//            }
//            return fis;
//        }
//    public Object [] [] getExcelData() throws IOException{
//        fis = getFileInputStream();
//
//        XSSFWorkbook wb= new XSSFWorkbook(fis);
//        XSSFSheet sheet = wb.getSheetAt(0);
//
//        int TotalNumberOfRows= (sheet.getLastRowNum()+1);
//        int TotalNumberOfColumns = 5;
//        String [][] arrayExcelData = new String [TotalNumberOfRows][TotalNumberOfColumns];
//
//        for (int i = 0; i < TotalNumberOfRows;i++) {
//            for (int j = 0; j < TotalNumberOfColumns;j++) {
//                XSSFRow row = sheet.getRow(1);
//                System.out.println(row.getCell(j).toString());
//                arrayExcelData [i][j] = row.getCell(j).toString();
//
//            }
//
//
//        }
//        System.out.println(arrayExcelData);
//        wb.close();
//
//        return arrayExcelData;
//    }




