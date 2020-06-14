package org.greenplum.pxf.plugins.hive;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.apache.hadoop.mapred.FileSplit;
import org.codehaus.jackson.annotate.JsonCreator;
import org.greenplum.pxf.plugins.hdfs.HcfsFragmentMetadata;

import java.util.List;
import java.util.Properties;

@Getter
public class HiveFragmentMetadata extends HcfsFragmentMetadata {

    /**
     * Input format of a fragment
     */
    private String inputFormatName;

    /**
     * SerDe class name
     */
    private String serdeClassName;

    /**
     * Properties string needed for SerDe initialization
     */
    private String propertiesString;

    /**
     * Partition keys
     */
    private String partitionKeys;

    /**
     * Whether filtering was done in fragmenter
     */
    private boolean filterInFragmenter;

    /**
     * Field delimiter
     */
    private String delimiter;

    /**
     * All the column types
     */
    private String colTypes;

    /**
     * Number of header rows
     */
    private int skipHeader;

    /**
     * A list of indexes corresponding to columns on the Hive table that will
     * be retrieved during the query
     */
    private List<Integer> hiveIndexes;

    /**
     * A comma-separated list of column names defined in the Hive table
     * definition
     */
    private String allColumnNames;

    /**
     * A comma-separated list of column types defined in the Hive table
     * definition
     */
    private String allColumnTypes;

    /**
     * Default constructor for JSON serialization
     */
    public HiveFragmentMetadata() {
        this(0, 0);
    }

    public HiveFragmentMetadata(FileSplit fsp) {
        super(fsp);
    }

    public HiveFragmentMetadata(long start, long length) {
        super(start, length);
    }

    public static final class Builder {
        private String inputFormatName;
        private String serdeClassName;
        private String propertiesString;
        private String partitionKeys;
        private boolean filterInFragmenter;
        private String delimiter;
        private String colTypes;
        private int skipHeader;
        private List<Integer> hiveIndexes;
        private String allColumnNames;
        private String allColumnTypes;
        private long start;
        private long length;

        private Builder() {
        }

        public static Builder aHiveFragmentMetadata() {
            return new Builder();
        }

        public Builder withFileSplit(FileSplit fileSplit) {
            this.start = fileSplit.getStart();
            this.length = fileSplit.getLength();
            return this;
        }

        public Builder withInputFormatName(String inputFormatName) {
            this.inputFormatName = inputFormatName;
            return this;
        }

        public Builder withSerdeClassName(String serdeClassName) {
            this.serdeClassName = serdeClassName;
            return this;
        }

        public Builder withPropertiesString(String propertiesString) {
            this.propertiesString = propertiesString;
            return this;
        }

        public Builder withPartitionKeys(String partitionKeys) {
            this.partitionKeys = partitionKeys;
            return this;
        }

        public Builder withFilterInFragmenter(boolean filterInFragmenter) {
            this.filterInFragmenter = filterInFragmenter;
            return this;
        }

        public Builder withDelimiter(String delimiter) {
            this.delimiter = delimiter;
            return this;
        }

        public Builder withColTypes(String colTypes) {
            this.colTypes = colTypes;
            return this;
        }

        public Builder withSkipHeader(int skipHeader) {
            this.skipHeader = skipHeader;
            return this;
        }

        public Builder withHiveIndexes(List<Integer> hiveIndexes) {
            this.hiveIndexes = hiveIndexes;
            return this;
        }

        public Builder withAllColumnNames(String allColumnNames) {
            this.allColumnNames = allColumnNames;
            return this;
        }

        public Builder withAllColumnTypes(String allColumnTypes) {
            this.allColumnTypes = allColumnTypes;
            return this;
        }

        public Builder withStart(long start) {
            this.start = start;
            return this;
        }

        public Builder withLength(long length) {
            this.length = length;
            return this;
        }

        public HiveFragmentMetadata build() {
            HiveFragmentMetadata hiveFragmentMetadata = new HiveFragmentMetadata(start, length);
            hiveFragmentMetadata.propertiesString = this.propertiesString;
            hiveFragmentMetadata.allColumnTypes = this.allColumnTypes;
            hiveFragmentMetadata.colTypes = this.colTypes;
            hiveFragmentMetadata.inputFormatName = this.inputFormatName;
            hiveFragmentMetadata.delimiter = this.delimiter;
            hiveFragmentMetadata.allColumnNames = this.allColumnNames;
            hiveFragmentMetadata.hiveIndexes = this.hiveIndexes;
            hiveFragmentMetadata.skipHeader = this.skipHeader;
            hiveFragmentMetadata.filterInFragmenter = this.filterInFragmenter;
            hiveFragmentMetadata.partitionKeys = this.partitionKeys;
            hiveFragmentMetadata.serdeClassName = this.serdeClassName;
            return hiveFragmentMetadata;
        }
    }
}
