package com.sigmaproject;

import com.sigmaproject.service.*;


import static com.sigmaproject.service.ApplicationService.runApplication;
import static com.sigmaproject.utils.Constant.FINAL_MESSAGE;

/**
 * Main class to run the application.
 */
public class Main {

    /**
     * Entry point for the application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        try {
            runApplication(new CommandLineArgsService(args));
        } catch (Exception e) {
            System.err.println(FINAL_MESSAGE);
        }
    }
}
