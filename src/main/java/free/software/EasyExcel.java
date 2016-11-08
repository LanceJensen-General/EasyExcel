package free.software;

import free.software.domain.RunConfiguration;
import free.software.factory.RecordReaderFactory;
import free.software.factory.RecordWriterFactory;
import free.software.service.RecordReader;
import free.software.service.RecordWriter;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by Lance Jensen on 10/24/2016.
 */
public class EasyExcel {

    private static final Logger logger = LoggerFactory.getLogger(EasyExcel.class.getName());

    public static void main(String[] args)  {

        // Parse the command line arguments and display help message
        // if invalid parameters are specified.
        RunConfiguration runConfiguration = new RunConfiguration();
        CmdLineParser parser = new CmdLineParser(runConfiguration);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException ex) {
            logger.error(ex.getMessage());
            System.exit(1);
        }

        // Validate the run configuration
        RunConfigurationValidator.validate(runConfiguration);

        // Create a record reader
        RecordReader reader = null;
        try {
            reader = RecordReaderFactory.getRecordReader(runConfiguration);
        } catch (IOException e) {
            logger.error("Could not open the file " + runConfiguration.getInputFile() + " for processing.");
            System.exit(1);
        }

        // Create an Excel writer
        RecordWriter writer = null;
        try {
            writer = RecordWriterFactory.getRecordWriter(runConfiguration);
        } catch (IOException e) {
            logger.error("Could not open the file " + runConfiguration.getOutputExcelFile() + " for output.");
            System.exit(2);
        }

        // Transfer the records from input source to Excel
        transferRecords(reader,writer);

        logger.info("Creation of " + runConfiguration.getOutputExcelFile() + " is complete.");
    }

    public static void transferRecords(RecordReader reader, RecordWriter writer) {
        while(reader.hasNextRecord()) {
            writer.write(reader.readRecord());
        }
        try {
            writer.close();
        } catch (IOException e) {
            logger.warn("Could not close the Excel output file.");
        }
    }
}
