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
    private static final String ERROR_LOG = "error.log";

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
     * Private constructor to prevent instantiation of the utility class.
     */
    private Constant() {
    }
}
