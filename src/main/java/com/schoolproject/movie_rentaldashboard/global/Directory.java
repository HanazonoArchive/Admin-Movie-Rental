package com.schoolproject.movie_rentaldashboard.global;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Directory {
    public static final String PROJECT_ROOT = getProjectRootDirectory();
    public static final String SRC_DIRECTORY = PROJECT_ROOT + "\\src";
    public static final String RESOURCES_DIRECTORY = PROJECT_ROOT + "\\resources";
    public static final String CONFIG_DIRECTORY = RESOURCES_DIRECTORY + "/config";
    public static final String LIBRARY_DIRECTORY = PROJECT_ROOT + "\\lib";
    public static final String LOGS_DIRECTORY = PROJECT_ROOT + "\\logs";
    public static final String MOVIES_IMAGES_DIRECTORY = SRC_DIRECTORY + "\\main\\resources\\com\\schoolproject\\movie_rentaldashboard\\movieImageResources";

    // Method to get the project root directory
// Method to get the project root directory
    public static String getProjectRootDirectory() {
        // Get the current working directory
        Path currentPath = Paths.get("").toAbsolutePath();

        // Return the current working directory as the project root directory
        return currentPath.toString();
    }


}
