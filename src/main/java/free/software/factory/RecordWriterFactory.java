package free.software.factory;

import free.software.domain.RunConfiguration;
import free.software.service.PoiRecordWriter;
import free.software.service.RecordWriter;

import java.io.IOException;

/**
 * Created by Lance Jensen on 11/5/2016.
 */
public class RecordWriterFactory {


    public static RecordWriter getRecordWriter(RunConfiguration runConfiguration) throws IOException {

        PoiRecordWriter recordWriter = new PoiRecordWriter(runConfiguration.getOutputExcelFile());
        recordWriter.setSheetName(runConfiguration.getWorksheetName());
        return recordWriter;


    }
}
