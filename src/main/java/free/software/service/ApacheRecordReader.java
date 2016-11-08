package free.software.service;

import free.software.service.RecordReader;
import org.apache.commons.csv.CSVRecord;

import java.util.Iterator;

/**
 * Created by Lance Jensen on 11/5/2016.
 */
public class ApacheRecordReader implements RecordReader {

    private Iterable<CSVRecord> records = null;

    private Iterator<CSVRecord> recordAccessor = null;

    public ApacheRecordReader(Iterable<CSVRecord> records) {
        this.records = records;
        this.recordAccessor = this.records.iterator();
    }

    public boolean hasNextRecord() {
        if (recordAccessor == null) {
            return false;
        } else {
            return recordAccessor.hasNext();
        }
    }

    public CSVRecord readRecord() {
        if(recordAccessor == null) {
            return null;
        } else {
            return recordAccessor.next();
        }

    }
}
