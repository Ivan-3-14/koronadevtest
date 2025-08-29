package com.sigmaproject.utils;

/**
 * Utility class to hold constant values used throughout the application.
 * <p>
 * This class contains constants for command-line arguments, error messages,
 * and other fixed values that are commonly used. It provides a centralized
 * location for these constants to improve code readability and maintainability.
 * </p>
 */
public class Constant {

    /**
     * The name of the error log file.
     * <p>
     * This constant holds the filename where error logs will be recorded
     * for troubleshooting and debugging purposes.
     * </p>
     */
    public static final String ERROR_LOG = "error.log";

    /**
     * The string representation for the "Manager" model.
     */
    public static final String MANAGER = "Manager";

    /**
     * The string representation for the "Employee" model.
     */
    public static final String EMPLOYEE = "Employee";

    /**
     * The file extension for serialized binary files.
     */
    public static final String POINT_S_B = ".sb";

    /**
     * The pattern for matching files with the .sb extension.
     */
    public static final String FILE_EXTENSION_PATTERN = "*.sb";

    /**
     * The delimiter used in CSV (Comma-Separated Values) files.
     */
    public static final String CSV_DELIMITER = ",";

    /**
     * A formatted string used for representing a key-value pair
     * in the format of "'key' : value".
     */
    public static final String QUOTE_SPACE_COLON_SPACE = "' : ";

    /**
     * The string representation of true.
     */
    public static final String TRUE = "true";

    /**
     * The string used for the sort parameter.
     */
    public static final String SORT = "sort";

    /**
     * The short form of the sort parameter.
     */
    public static final String S = "s";

    /**
     * The string used for the order parameter.
     */
    public static final String ORDER = "order";

    /**
     * The string used for the stat parameter.
     */
    public static final String STAT = "stat";

    /**
     * The string used for the output parameter.
     */
    public static final String OUTPUT = "output";

    /**
     * The short form of the output parameter.
     */
    public static final String O = "o";

    /**
     * The string used for the path parameter.
     */
    public static final String PATH = "path";

    /**
     * The string representation of double dash used in command-line arguments.
     */
    public static final String DOUBLE_DASH = "--";

    /**
     * The string representation of single dash used in command-line arguments.
     */
    public static final String SINGLE_DASH = "-";

    /**
     * The character used to denote key-value pairs in command-line arguments.
     */
    public static final Character EQUALS = '=';

    /**
     * The header line format for the statistics output.
     */
    public static final String STAT_HEAD_LINE = "department, min, max, mid";

    /**
     * Default value for salary represented as a string.
     */
    public static final String DEFAULT_SALARY_VAL_STR = "0.00";

    /**
     * String format for a line in the statistics output.
     */
    public static final String STAT_LINE_STRING_FORMAT = "%s, %s, %s, %s";

    /**
     * Template for a message indicating a duplicate manager.
     */
    public static final String DUPLICATE_MANAGER_MESSAGE_TEMPLATE = "%s%s%s%s";

    /**
     * Error message for statistics options without the --stat argument.
     */
    public static final String STAT_ERROR_MESSAGE = "Statistics options (--output, --path) cannot be specified without the --stat argument";

    /**
     * Error message for output file path specification without --path.
     */
    public static final String OUTPUT_ERROR_MESSAGE_PATH = "With --output=file the --path parameter must be specified";

    /**
     * Error message for incorrect output parameter values.
     */
    public static final String OUTPUT_ERROR_MESSAGE = "Incorrect value for --output parameter: ";

    /**
     * Error message for sort order specified without sort parameter.
     */
    public static final String SORT_ERROR_MESSAGE = "Sort order (--order) specified without sort parameter (--sort)";

    /**
     * Error message for incorrect sort parameter values.
     */
    public static final String INCORRECT_SORT_PARAM = "Incorrect value for --sort parameter: ";

    /**
     * Error message for incorrect order parameter values.
     */
    public static final String INCORRECT_ORDER_PARAM = "Incorrect value for --order parameter: ";

    /**
     * Error message for indicating a duplicate manager for a department.
     */
    public static final String DUPLICATE_MANAGER_ERR = "Duplicate manager for department '";

    /**
     * Error message for file write operations.
     */
    public static final String FILE_WRITE_ERR = "File write error ";

    /**
     * Error message when there is an issue writing to the error log file.
     */
    public static final String ERR_WRITING_ERR_LOG = "Error writing error.log: ";

    /**
     * Error message for errors encountered while reading input files.
     */
    public static final String ERR_READ_INPUT_FILES = "Error reading input files: ";

    /**
     * Error message for issues encountered while recording statistics.
     */
    public static final String ERR_REC_STATS = "Error recording statistics: ";

    /**
     * Error message for issues encountered while creating a directory.
     */
    public static final String ERR_CREATE_DIR = "Error creating directory: ";

    /**
     * A message prompting the user to restart the program.
     */
    public static final String FINAL_MESSAGE = "Please, restart the program";

    /**
     * Private constructor to prevent instantiation of the utility class.
     */
    private Constant() {
    }
}
