
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class UploadFiles {
    private JPanel jPanel;
    private JButton b1;
    private JButton b2;
    private JLabel L1;
    private JLabel L2;
    private JButton b3;
    static int rowCount1;
    int rowCount2;
    XSSFWorkbook work1;
    XSSFWorkbook work2;
    XSSFSheet sheet1;
    XSSFSheet sheet2;

    Report report = new Report();
    ArrayList<ReportProperties> reportPropertiesList = new ArrayList<>();


    /**
     * Button 1 : select first xls file
     * XSSFWorkbook is used to read / write files in xlsx format.
     * import java.io.FileInputStream; // Library required for file reading.
     */
    public UploadFiles() {
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                File file;
                int response;
                JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView());
                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                response = fileChooser.showOpenDialog(null);

                if (response == JFileChooser.APPROVE_OPTION) {
                    file = fileChooser.getSelectedFile();
                    L1.setText(file.getName());
                    try {
                        FileInputStream fis = new FileInputStream(file);
                        work1 = new XSSFWorkbook(fis);
                        sheet1 = work1.getSheet("Sheet1");
                        Iterator<Row> rowItr = sheet1.iterator();
                        rowCount1 = sheet1.getPhysicalNumberOfRows();
                        while (rowItr.hasNext()) {
                            Row row = rowItr.next();
                            Iterator<Cell> cellitr = row.cellIterator();
                            while (cellitr.hasNext()) {
                                Cell cell = cellitr.next();
                                switch (cell.getCellType()) {
                                    case STRING:
                                        System.out.print(cell.getStringCellValue() + "\t");
                                        break;
                                    case NUMERIC:
                                        System.out.print(cell.getNumericCellValue() + "\t");
                                        break;
                                    default:
                                        break;
                                }
                            }
                            System.out.println("");
                        }

                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
        /**
         * Button 2 : select second xls file
         */
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                File file2;
                int response;
                JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView());
                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                response = fileChooser.showOpenDialog(null);
                if (response == JFileChooser.APPROVE_OPTION) {
                    file2 = fileChooser.getSelectedFile();
                    L2.setText(file2.getName());
                    try {
                        FileInputStream fis = new FileInputStream(file2);
                        work2 = new XSSFWorkbook(fis);
                        sheet2 = work2.getSheet("Sheet1");
                        Iterator<Row> rowItr = sheet2.iterator();
                        rowCount2 = sheet2.getPhysicalNumberOfRows();
                        while (rowItr.hasNext()) {
                            Row row = rowItr.next();
                            Iterator<Cell> cellitr = row.cellIterator();
                            while (cellitr.hasNext()) {
                                Cell cell = cellitr.next();

                                switch (cell.getCellType()) {
                                    case STRING:
                                        System.out.print(cell.getStringCellValue() + "\t");
                                        break;
                                    case NUMERIC:
                                        System.out.print(cell.getNumericCellValue() + "\t");
                                        break;
                                    default:
                                        break;
                                }
                            }
                            System.out.println("");
                        }

                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
        /**
         * Button 3: created for comparison.
         *
         *     XSSFRow - the parent row.
         *     XSSFCell - containing information about the cell.
         */
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 1; i < rowCount1; i++) {

                    XSSFRow row1 = sheet1.getRow(i);
                    XSSFRow row2 = sheet2.getRow(i);
                    //-----------------Name//----------------
                    String name1 = "";
                    XSSFCell namestr = row1.getCell(0);
                    if (namestr != null) {
                        namestr.setCellType(CellType.STRING);
                        name1 = namestr.getStringCellValue();
                    }
                    String name2 = "";
                    XSSFCell namestr2 = row2.getCell(0);
                    if (namestr2 != null) {
                        namestr2.setCellType(CellType.STRING);
                        name2 = namestr2.getStringCellValue();
                    }
                    //-----------------Surname//----------------
                    String surname1 = "";
                    XSSFCell surnamestr = row1.getCell(1);
                    if (surnamestr != null) {
                        surnamestr.setCellType(CellType.STRING);
                        surname1 = surnamestr.getStringCellValue();
                    }
                    String surname2 = "";
                    XSSFCell surnamestr2 = row2.getCell(1);
                    if (surnamestr2 != null) {
                        surnamestr2.setCellType(CellType.STRING);
                        surname2 = namestr2.getStringCellValue();
                    }
                    //-----------------Birthdate//----------------
                    String birthdate1 = "";
                    XSSFCell birthdatestr = row1.getCell(2);
                    if (birthdatestr != null) {
                        birthdatestr.setCellType(CellType.STRING);
                        birthdate1 = birthdatestr.getStringCellValue();
                    }
                    String birthdate2 = "";
                    XSSFCell birthdatestr2 = row2.getCell(2);
                    if (birthdatestr2 != null) {
                        birthdatestr2.setCellType(CellType.STRING);
                        birthdate2 = birthdatestr2.getStringCellValue();
                    }
                    //-----------------BirthLocation//----------------

                    String birthloc2 = "";
                    XSSFCell birthlocstr2 = row2.getCell(3);
                    if (birthlocstr2 != null) {
                        birthlocstr2.setCellType(CellType.STRING);
                        birthloc2 = birthlocstr2.getStringCellValue();
                    }
                    //-----------------Mail//----------------
                    String mail1 = "";
                    XSSFCell mailstr = row1.getCell(3);
                    if (mailstr != null) {
                        mailstr.setCellType(CellType.STRING);
                        mail1 = mailstr.getStringCellValue();
                    }
                    String mail2 = "";
                    XSSFCell mailstr2 = row2.getCell(4);
                    if (mailstr2 != null) {
                        mailstr2.setCellType(CellType.STRING);
                        mail2 = mailstr2.getStringCellValue();
                    }
                    //-----------------Phone//----------------
                    String phone1 = "";
                    XSSFCell phonestr = row1.getCell(4);
                    if (phonestr != null) {
                        phonestr.setCellType(CellType.STRING);
                        phone1 = phonestr.getStringCellValue();
                    }
                    String phone2 = "";
                    XSSFCell phonestr2 = row2.getCell(5);
                    if (phonestr2 != null) {
                        phonestr2.setCellType(CellType.STRING);
                        phone2 = phonestr2.getStringCellValue();
                    }
                    //-----------------Status//----------------
                    String stastr1 = "";
                    XSSFCell statusstr = row1.getCell(5);
                    if (statusstr != null) {
                        statusstr.setCellType(CellType.STRING);
                        stastr1 = statusstr.getStringCellValue();
                    }
                    //-----------------JobStatus//----------------
                    String jobstastr2 = "";
                    XSSFCell jobstatusstr2 = row2.getCell(6);
                    if (jobstatusstr2 != null) {
                        jobstatusstr2.setCellType(CellType.STRING);
                        jobstastr2 = jobstatusstr2.getStringCellValue();
                    }
                    //-----------------University//----------------
                    String unistr2 = "";
                    XSSFCell universtr2 = row2.getCell(7);
                    if (universtr2 != null) {
                        universtr2.setCellType(CellType.STRING);
                        unistr2 = universtr2.getStringCellValue();
                    }
                    String wrong = "";
                    String wrongname = "Hatalı ad";
                    String wrongsurname = "Hatalı soyad";
                    String wrongphone = "Hatalı telefon";
                    String wrongdate = "Hatalı doğum tarihi";
                    String wrongmail = "Hatalı mail adresi";

                    if (((phone1 != "" || mail1 != "") & (phone2 != "" || mail2 != "")) & (name1.equals(name2) || surname1.equals(surname2) & !mail1.equals(mail2) || !phone1.equals(phone2))) {
                        //System.out.println(name1 + surname1 + birthdate2 + birthloc2 + mail2 + phone2 + stastr1 + jobstastr2 + unistr2);
                        if (!(birthdate1.equals(birthdate2))) {
                            reportPropertiesList.add(new ReportProperties(name1, surname1, birthloc2, birthdate2, mail2, phone2, stastr1, jobstastr2, unistr2, wrongdate + birthdate1 + " " + birthdate2));
                        } else if (!(name1.equals(name2) || surname1.equals(surname2))) {
                            reportPropertiesList.add(new ReportProperties(name1, surname1, birthloc2, birthdate2, mail2, phone2, stastr1, jobstastr2, unistr2, wrongname + " veya " + wrongsurname + name1 + " " + name2 + " " + surname1 + " " + surname2));
                        } else if (!mail1.equals(mail2)) {
                            reportPropertiesList.add(new ReportProperties(name1, surname1, birthloc2, birthdate2, mail2, phone2, stastr1, jobstastr2, unistr2, wrongmail + " " + mail1 + " " + mail2));
                        } else if (!phone1.equals(phone2)) {
                            reportPropertiesList.add(new ReportProperties(name1, surname1, birthloc2, birthdate2, mail2, phone2, stastr1, jobstastr2, unistr2, wrongphone + " " + phone1 + " " + phone2));
                        } else {
                            reportPropertiesList.add(new ReportProperties(name1, surname1, birthloc2, birthdate2, mail2, phone2, stastr1, jobstastr2, unistr2, wrong));
                        }
                    }
                }
                report.createNewFile(reportPropertiesList);
            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("UploadFiles");
        frame.setLocation(500, 500);
        frame.setContentPane(new UploadFiles().jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(300, 200);
    }
}