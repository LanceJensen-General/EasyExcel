package free.software.domain;

import org.kohsuke.args4j.Option;

import java.io.File;

/**
 * RunConfiguration - is a class that holds the arguments parsed by Args4j from the command line.  The configurations
 * are used to run easy excel
 * Created by Lance Jensen on 10/24/2016.
 */
public class RunConfiguration {

    @Option(name="-inputFormat",
            usage="Configures the application to accept a usage format." +
                  "(excel,informix_unload,informix_unload_csv,mysql,rfc-4180,tdf)")
    private String inputFormat = "rfc-4180";
    @Option(name = "-inputFile",
            usage = "This option allows you to specify a file to transform into an Excel document.")
    private File inputFile;
    @Option(name="-outputFile",
            usage="This is your new excel file output location. This path may be relative or absolute.",
            required = true)
    private File outputExcelFile;
    @Option(name="-worksheet",
            usage="Sets the name of the worksheet where your data will be written",
            required=true)
    private String worksheetName;
    @Option(name="-header",
            usage="Used to specify a header for this worksheet.",
            depends={"-headerDelimiter"})
    private String header;
    @Option(name="-headerDelimiter",
            usage="Used to parse header for insertion into the worksheet.",
            depends={"-header"})
    private String headerDelimiter;
    @Option(name="-outputFormat",
            usage="Sets the excel output type to Excel 97(xls) or Excel 2003(xlsx).")
    private String excelOutputFormat = "xls";

    public String getHeader() {
        return header;
    }

    public File getInputFile() {
        return inputFile;
    }

    public void setInputFile(File inputFile) {
        this.inputFile = inputFile;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getInputFormat() {
        return inputFormat;
    }

    public void setInputFormat(String inputFormat) {
        this.inputFormat = inputFormat;
    }

    public String getHeaderDelimiter() {
        return headerDelimiter;
    }

    public void setHeaderDelimiter(String headerDelimiter) {
        this.headerDelimiter = headerDelimiter;
    }

    public File getOutputExcelFile() {
        return outputExcelFile;
    }

    public void setOutputExcelFile(File outputExcelFile) {
        this.outputExcelFile = outputExcelFile;
    }

    public String getWorksheetName() {
        return worksheetName;
    }

    public void setWorksheetName(String worksheetName) {
        this.worksheetName = worksheetName;
    }
}
