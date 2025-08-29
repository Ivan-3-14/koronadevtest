package com.sigmaproject.service;

import com.sigmaproject.exception.CustomIllArgException;
import com.sigmaproject.model.enums.OrderValue;
import com.sigmaproject.model.enums.OutputValue;
import com.sigmaproject.model.enums.SortValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

import static com.sigmaproject.utils.Constant.*;

/**
 * Service class for handling command-line arguments.
 * <p>
 * This class parses command-line arguments, validates them, and provides access
 * to the parsed values such as sorting options, order, and output settings.
 * </p>
 */

@Getter
public class CommandLineArgsService {

    private boolean stat = false;
    private String sortBy = null;
    private String order = null;
    private String output = null;
    private String path = null;

    /**
     * Constructs a CommandLineArgsService with the provided command-line arguments.
     *
     * @param args the command-line arguments to parse
     * @throws CustomIllArgException if the arguments are invalid
     */
    public CommandLineArgsService(String[] args) throws CustomIllArgException {
        parseArgs(args);
        validate();
    }

    /**
     * Parses the command-line arguments and populates the fields of the class.
     *
     * @param args the command-line arguments to parse
     */
    private void parseArgs(String[] args) {
        Map<String, String> params = new HashMap<>();

        for (String arg : args) {
            if (arg.startsWith(DOUBLE_DASH)) {
                int eqIdx = arg.indexOf(EQUALS);
                if (eqIdx > 0) {
                    String key = arg.substring(2, eqIdx).toLowerCase();
                    String value = arg.substring(eqIdx + 1);
                    params.put(key, value);
                } else {
                    String key = arg.substring(2).toLowerCase();
                    params.put(key, TRUE);
                }
            } else if (arg.startsWith(SINGLE_DASH)) {
                int eqIdx = arg.indexOf(EQUALS);
                if (eqIdx > 0) {
                    String key = arg.substring(1, eqIdx).toLowerCase();
                    String value = arg.substring(eqIdx + 1);
                    params.put(key, value);
                } else {
                    String key = arg.substring(1).toLowerCase();
                    params.put(key, TRUE);
                }
            }
        }

        if (params.containsKey(SORT)) {
            sortBy = params.get(SORT);
        } else if (params.containsKey(S)) {
            sortBy = params.get(S);
        }

        if (params.containsKey(ORDER)) {
            order = params.get(ORDER);
        }

        if (params.containsKey(STAT)) {
            stat = true;
        }

        if (params.containsKey(OUTPUT)) {
            output = params.get(OUTPUT);
        } else if (params.containsKey(O)) {
            output = params.get(O);
        }

        if (params.containsKey(PATH)) {
            path = params.get(PATH);
        }
    }

    /**
     * Validates the parsed command-line arguments for correctness.
     *
     * @throws CustomIllArgException if any of the arguments are invalid
     */
    private void validate() {
        validateSort();
        validateStatistic();
    }

    /**
     * Validates the statistics settings.
     *
     * @throws CustomIllArgException if the statistics settings are invalid
     */
    private void validateStatistic() {
        if (!stat) {
            if (output != null && !output.equals(OutputValue.CONSOLE.getValue())) {
                throw new CustomIllArgException(STAT_ERROR_MESSAGE);
            }
            if (path != null) {
                throw new CustomIllArgException(STAT_ERROR_MESSAGE);
            }
        } else {
            if (output == null) {
                output = OutputValue.CONSOLE.getValue();
            }
            if (output.equals(OutputValue.FILE.getValue()) && (path == null || path.isEmpty())) {
                throw new CustomIllArgException(OUTPUT_ERROR_MESSAGE_PATH);
            }
            if (!output.equals(OutputValue.FILE.getValue()) && !output.equals(OutputValue.CONSOLE.getValue())) {
                throw new CustomIllArgException(OUTPUT_ERROR_MESSAGE + output);
            }
        }
    }

    /**
     * Validates the sorting parameters.
     *
     * @throws CustomIllArgException if the sorting parameters are invalid
     */
    private void validateSort() {
        if (sortBy == null && order != null) {
            throw new CustomIllArgException(SORT_ERROR_MESSAGE);
        }
        if (sortBy != null && !sortBy.equals(SortValue.NAME.getValue()) && !sortBy.equals(SortValue.SALARY.getValue())) {
            throw new CustomIllArgException(INCORRECT_SORT_PARAM + sortBy);
        }
        if (order != null && !order.equals(OrderValue.ASC.getValue()) && !order.equals(OrderValue.DESC.getValue())) {
            throw new CustomIllArgException(INCORRECT_ORDER_PARAM + order);
        }
    }
}
