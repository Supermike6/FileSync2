package Experiments.functions;

public class Formating {
    // Reset
    private static String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    private static String BLACK = "\033[0;30m";   // BLACK
    private static String RED = "\033[0;31m";     // RED
    private static String GREEN = "\033[0;32m";   // GREEN
    private static String YELLOW = "\033[0;33m";  // YELLOW
    private static String BLUE = "\033[0;34m";    // BLUE
    private static String PURPLE = "\033[0;35m";  // PURPLE
    private static String CYAN = "\033[0;36m";    // CYAN
    private static String WHITE = "\033[0;37m";   // WHITE

    // Bold
    private static String BLACK_BOLD = "\033[1;30m";  // BLACK
    private static String RED_BOLD = "\033[1;31m";    // RED
    private static String GREEN_BOLD = "\033[1;32m";  // GREEN
    private static String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    private static String BLUE_BOLD = "\033[1;34m";   // BLUE
    private static String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    private static String CYAN_BOLD = "\033[1;36m";   // CYAN
    private static String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Underline
    private static String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    private static String RED_UNDERLINED = "\033[4;31m";    // RED
    private static String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    private static String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    private static String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    private static String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    private static String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    private static String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

    // Background
    private static String BLACK_BACKGROUND = "\033[40m";  // BLACK
    private static String RED_BACKGROUND = "\033[41m";    // RED
    private static String GREEN_BACKGROUND = "\033[42m";  // GREEN
    private static String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    private static String BLUE_BACKGROUND = "\033[44m";   // BLUE
    private static String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    private static String CYAN_BACKGROUND = "\033[46m";   // CYAN
    private static String WHITE_BACKGROUND = "\033[47m";  // WHITE

    // High Intensity
    private static String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    private static String RED_BRIGHT = "\033[0;91m";    // RED
    private static String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    private static String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    private static String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    private static String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    private static String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    private static String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    // Bold High Intensity
    private static String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    private static String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    private static String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    private static String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    private static String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    private static String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    private static String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    private static String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    private static String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    private static String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    private static String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    private static String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    private static String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    private static String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    private static String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    private static String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
    
    public static void textBlack()
    {
        System.out.println(BLACK);
    }
    public static void textYellow()
    {
        System.out.println(YELLOW);
    }
    public static void textGreen()
    {
        System.out.println(GREEN);
    }
    public static void textBlue()
    {
        System.out.println(BLUE);
    }
    public static void textPurple()
    {
        System.out.println(PURPLE);
    }
    public static void textCyan()
    {
        System.out.println(CYAN);
    }
    public static void textWhite()
    {
        System.out.println(WHITE);
    }
    public static void textReset()
    {
        System.out.println(RESET);
    }


}