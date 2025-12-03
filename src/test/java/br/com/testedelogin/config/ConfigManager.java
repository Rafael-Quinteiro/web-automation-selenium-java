package br.com.testedelogin.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utility class responsible for loading and providing access
 * to application configuration properties.
 * <p>
 * The properties are loaded once at class initialization time
 * from the {@code config.properties} file available in the classpath.
 * </p>
 */
public class ConfigManager {

    private static final Properties properties = new Properties();

    static {
        String fileName = "config.properties";

        try (InputStream input = ConfigManager.class
                .getClassLoader()
                .getResourceAsStream(fileName)) {

            if (input == null) {
                throw new RuntimeException("Configuration file not found: " + fileName);
            }

            properties.load(input);

        } catch (IOException ex) {
            throw new RuntimeException("Error while loading configuration properties", ex);
        }
    }

    /**
     * Retrieves a configuration value by its key.
     *
     * @param key the property key
     * @return the property value associated with the given key
     */
    public static String get(String key) {
        return properties.getProperty(key);
    }

    /**
     * Returns the base URL used for login requests.
     *
     * @return the login base URL
     */
    public static String getBaseLoginUrl() {
        return get("url.base-login");
    }

    /**
     * Returns the configured login username.
     *
     * @return the login username
     */
    public static String getLoginUser() {
        return get("user.login");
    }

    /**
     * Returns the configured login password.
     *
     * @return the login password
     */
    public static String getLoginPassword() {
        return get("password.login");
    }

    /**
     * Returns the maximum wait time in milliseconds.
     *
     * @return the maximum wait time as a long value
     */
    public static long getMaxWaitTime() {
        return Long.parseLong(get("tempo.max.espera"));
    }
}