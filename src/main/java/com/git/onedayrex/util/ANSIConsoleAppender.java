package com.git.onedayrex.util;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggingEvent;

import java.util.Random;

/**
 * Colour-coded console appender for Log4J.
 */
public class ANSIConsoleAppender extends ConsoleAppender
{
    private static final int NORMAL = 0;
    private static final int BRIGHT = 1;
    private static final int FOREGROUND_BLACK = 30;
    private static final int FOREGROUND_RED = 31;
    private static final int FOREGROUND_GREEN = 32;
    private static final int FOREGROUND_YELLOW = 33;
    private static final int FOREGROUND_BLUE = 34;
    private static final int FOREGROUND_MAGENTA = 35;
    private static final int FOREGROUND_CYAN = 36;
    private static final int FOREGROUND_WHITE = 37;

    private static final String PREFIX = "\u001b[";
    private static final String SUFFIX = "m";
    private static final char SEPARATOR = ';';
    private static final String END_COLOUR = PREFIX + SUFFIX;

    public static final String NBLACK = PREFIX
            + BRIGHT + SEPARATOR + FOREGROUND_BLACK + SUFFIX;
    public static final String NRED = PREFIX
            + NORMAL + SEPARATOR + FOREGROUND_RED + SUFFIX;
    public static final String NGREEN = PREFIX
            + NORMAL + SEPARATOR + FOREGROUND_GREEN + SUFFIX;
    public static final String NYELLOW = PREFIX
            + NORMAL + SEPARATOR + FOREGROUND_YELLOW + SUFFIX;
    public static final String NBLUE = PREFIX
            + NORMAL + SEPARATOR + FOREGROUND_BLUE + SUFFIX;
    public static final String NMAGENTA = PREFIX
            + NORMAL + SEPARATOR + FOREGROUND_MAGENTA + SUFFIX;
    public static final String NCYAN = PREFIX
            + NORMAL + SEPARATOR + FOREGROUND_CYAN + SUFFIX;
    public static final String NWHITE = PREFIX
            + NORMAL + SEPARATOR + FOREGROUND_WHITE + SUFFIX;
    public static final String BBLACK = PREFIX
            + BRIGHT + SEPARATOR + FOREGROUND_BLACK + SUFFIX;
    public static final String BRED = PREFIX
            + BRIGHT + SEPARATOR + FOREGROUND_RED + SUFFIX;
    public static final String BGREEN = PREFIX
            + BRIGHT + SEPARATOR + FOREGROUND_GREEN + SUFFIX;
    public static final String BYELLOW = PREFIX
            + BRIGHT + SEPARATOR + FOREGROUND_YELLOW + SUFFIX;
    public static final String BBLUE = PREFIX
            + BRIGHT + SEPARATOR + FOREGROUND_BLUE + SUFFIX;
    public static final String BMAGENTA = PREFIX
            + BRIGHT + SEPARATOR + FOREGROUND_MAGENTA + SUFFIX;
    public static final String BCYAN = PREFIX
            + BRIGHT + SEPARATOR + FOREGROUND_CYAN + SUFFIX;
    public static final String BWHITE = PREFIX
            + BRIGHT + SEPARATOR + FOREGROUND_WHITE + SUFFIX;

    /**
     * Wraps the ANSI control characters around the
     * output from the super-class Appender.
     */
    protected void subAppend(LoggingEvent event)
    {
        this.qw.write(getColour(event.getLevel()));
        super.subAppend(event);
        this.qw.write(END_COLOUR);

        if(this.immediateFlush)
        {
            this.qw.flush();
        }
    }

    /**
     * Get the appropriate control characters to change
     * the colour for the specified logging level.
     */
    private String getColour(Level level)
    {
        Random random = new Random();
        int i = random.nextInt(15);
        switch (level.toInt())
        {
            case Priority.ERROR_INT: return NBLACK;
            case Priority.WARN_INT: return NBLACK;
            case Priority.INFO_INT:
                if (i == 1) {
                    return NBLACK;
                } else if (i == 2) {
                    return NRED;
                } else if (i==3) {
                    return NGREEN;
                } else if (i == 4) {
                    return NYELLOW;
                } else if (i == 5) {
                    return NBLUE;
                } else if (i == 6) {
                    return NMAGENTA;
                }else if (i == 7) {
                    return NCYAN;
                }else if (i == 8) {
                    return NWHITE;
                }else if (i == 9) {
                    return BBLACK;
                }else if (i == 9) {
                    return BRED;
                }else if (i == 10) {
                    return BGREEN;
                }else if (i == 11) {
                    return BYELLOW;
                }else if (i == 12) {
                    return BBLUE;
                }else if (i == 13) {
                    return BMAGENTA;
                }else if (i == 14) {
                    return BCYAN;
                }else if (i == 15) {
                    return BWHITE;
                }
                return NRED;
            case Priority.DEBUG_INT:return NBLACK;
            default: return NBLACK;
        }
    }
}