package free.software.service;

import org.apache.commons.csv.CSVRecord;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.IOException;

/**
 * Created by Lance Jensen on 11/5/2016.
 */
public class PoiRecordWriter implements RecordWriter {

    private POIFSFileSystem poiFileSystem;
    private HSSFWorkbook workbook;
    private Sheet sheet;
    private int currentRows =0;

    public PoiRecordWriter(File outputFile) throws IOException {
        this.poiFileSystem = new POIFSFileSystem(outputFile);
        this.workbook = new HSSFWorkbook(poiFileSystem);
    }

    public void setSheetName(String sheetName) {
        sheet = workbook.getSheet(sheetName);
        if(sheet == null) {
            sheet = workbook.createSheet();
            workbook.setSheetName(workbook.getSheetIndex(sheet) ,sheetName);
        }
    }

    public synchronized void write(CSVRecord record) {
        if(sheet == null) {
            sheet = workbook.createSheet();
        }
        Row row = sheet.createRow(currentRows);
        currentRows++;
        // Write the cells
        for(int atCellLocation = 0; atCellLocation < record.size(); atCellLocation++) {
            Cell cell = row.createCell(atCellLocation);
            cell.setCellValue(record.get(atCellLocation));
        }
    }

    public void close() throws IOException {
        workbook.write();
        poiFileSystem.close();
    }
}
