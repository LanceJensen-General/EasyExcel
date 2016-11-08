package free.software.service;

import org.apache.commons.csv.CSVRecord;

import java.io.IOException;

/**
 * Created by Lance Jensen on 11/5/2016.
 */
public interface RecordWriter {

    public void write(CSVRecord record);

    public void close() throws IOException;
}
