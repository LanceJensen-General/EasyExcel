package free.software.service;

import org.apache.commons.csv.CSVRecord;

/**
 * RecordReader is an interface to abstract away the differences of utilizing various file formats or input sources
 * Created by Lance Jensen on 10/25/2016.
 */
public interface RecordReader {

    /**
     * hasNextRecord - returns the next record available from the input source
     * @return true if there is another record and false otherwise.  The method will block if it can not be deterministically
     * resolved by the underlying source stream.
     */
    public boolean hasNextRecord();

    /**
     * readRecord - the next available record.
     * @return a String array containing the record contents or Null if there are no more records.
     */
    public CSVRecord readRecord();
}
