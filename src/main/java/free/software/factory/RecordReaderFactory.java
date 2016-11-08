package free.software.factory;

import free.software.domain.RunConfiguration;
import free.software.service.ApacheRecordReader;
import free.software.service.RecordReader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;

/**
 * Created by Lance Jensen on 11/5/2016.
 */
public class RecordReaderFactory {

    public static RecordReader getRecordReader(RunConfiguration runConfiguration) throws IOException {
        // For inital implementation all I am concerned with is csv input from standard in or a file.
        // All other implementations will be for a later commit.

        // Get input stream
        Reader in = null;
        if(runConfiguration.getInputFile() == null) {
            in = new InputStreamReader(System.in);
        } else {
            in = new FileReader(runConfiguration.getInputFile());
        }

        Iterable<CSVRecord> records = CSVFormat.valueOf(runConfiguration.getInputFormat()).parse(in);

        return new ApacheRecordReader(records);
    }
}
