package br.com.testedelogin.global;

/**
 * Centralized class that stores application-wide constants
 * used across the test automation project.
 * <p>
 * This class groups fixed values such as report paths, messages,
 * URLs, and UI texts to avoid duplication and hardcoding.
 * </p>
 */
public class Constants {

    public static final String LOGIN_ROUTINE_DESCRIPTION = "Login";

    public static final String LOGIN_REPORT_PATH = "reports/Login/";

    public static final String ORDER_ROUTINE_DESCRIPTION = "Order";

    public static final String ORDER_REPORT_PATH = "reports/Order/";

    public static final String ACCOUNT_PAGE_URL =
            "https://opencart.abstracta.us/index.php?route=account/account";

    public static final String SUCCESS_ALERT_MESSAGE = "Success: You have added";

    public static final String ORDER_SUCCESS_MESSAGE = "Your order has been placed!";

    public static final String CHECKOUT_TEXT = "Checkout";

    public static final String SCREENSHOT_FOLDER_PATH = "src/screenshots/";

    public static final String REPORT_BASE_NAME = "reports/Reports-Automation-";

    public static final String REPORTS_SOURCE_PATH = "reports";
}