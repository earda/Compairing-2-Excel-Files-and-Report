import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Report {

    public static void createNewFile(ArrayList<ReportProperties> reportPropertiesList) {
        /**
         * headerStyle is containing information of cell's view properties
         */
        try {
            Workbook workbook = new XSSFWorkbook();
            Sheet sh = workbook.createSheet("Report");
            String[] columnHeadings = {" AD", "SOYAD", "DOĞUM TARİHİ", " DOĞUM YERİ", "MAİL", "TELEFON", "DURUM", " ÇALIŞMA DURUMU", " ÜNİVERSİTE","Farklılıklar"};
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 12);
            headerFont.setColor(IndexedColors.BLACK.index);
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFont(headerFont);
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
            Row headerRow = sh.createRow(0);
            for (int i = 0; i < columnHeadings.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columnHeadings[i]);
                cell.setCellStyle(headerStyle);
            }
            sh.createFreezePane(0, 1);

            int rownum = 1;
            for (ReportProperties i : reportPropertiesList) {
                //System.out.println("rownum-before"+(rownum));
                Row row = sh.createRow(rownum++);
                //System.out.println("rownum-after"+(rownum));
                row.createCell(0).setCellValue(i.getName());
                row.createCell(1).setCellValue(i.getSurname());
                row.createCell(2).setCellValue(i.getBirthL());
                row.createCell(3).setCellValue(i.getDate());
                row.createCell(4).setCellValue(i.getMail());
                row.createCell(5).setCellValue(i.getPhone());
                row.createCell(6).setCellValue(i.getStatus());
                row.createCell(7).setCellValue(i.getJobStatus());
                row.createCell(8).setCellValue(i.getUniversty());
                row.createCell(9).setCellValue(i.getWrong());
            }

            int noOfRows = sh.getLastRowNum();
            sh.groupRow(1, noOfRows);
            sh.setRowGroupCollapsed(1, true);
            for (int i = 0; i < columnHeadings.length; i++) {
                sh.autoSizeColumn(i);
            }
            /**
             * import java.io.FileInputStream; // Library required for file writing.
             */
            FileOutputStream fileOut = new FileOutputStream("C:/Users/ardag/Desktop/rpaproject/Report/Report.xlsx");
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Rapor Oluşturuldu.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
