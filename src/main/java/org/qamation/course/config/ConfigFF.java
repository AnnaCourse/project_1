package org.qamation.course.config;

import org.qamation.course.utils.ResourceUtils;

public class ConfigFF {

    private static ConfigFF config = null;

    public static ConfigFF getConfig() {
        if (config == null) {
            config = new ConfigFF();
        }
        return config;
    }


    private String rootPath;
    private String resourcesPath;
    private String firefoxDriverPath;
    private String env;


    private long pauseInTest;

    private ConfigFF() {
        env = System.getProperty("env");
        if (env == null) {
            System.err.println("env is not provided. Please set -Denv=<folder> what is /resources/env/<folder> ");
            System.exit(-1);
        }

        rootPath = System.getProperty("ROOT");

        if (rootPath == null) rootPath = System.getProperty("user.dir");
        resourcesPath = rootPath + "/resources";

        String defaultPropsPath = resourcesPath + "/etc";
        String envPropsPath = resourcesPath + "/env/" + env;
        readProperties(defaultPropsPath);
        readProperties(envPropsPath);
        setUpSuiteVariables();
    }

    public String getRootPath() {
        return rootPath;
    }

    public String getResourcesPath() {
        return resourcesPath;
    }

    public String getFirefoxDriverPath() { return firefoxDriverPath; }

    public long getPauseInTest() {
        return pauseInTest;
    }

    public String getEnv() {
        return env;
    }

    private void readProperties(String prop_path) {
        if (prop_path.isEmpty()) {
            ResourceUtils.loadProperties();
        } else {
            ResourceUtils.loadProperties(prop_path);
        }
    }

    private void setUpSuiteVariables() {
        firefoxDriverPath = System.getProperty("firefox.path") + "/" + System.getProperty("firefox.name");
        pauseInTest = Long.parseLong(System.getProperty("PAUSE_IN_TEST_MILLS"));

    }


}


