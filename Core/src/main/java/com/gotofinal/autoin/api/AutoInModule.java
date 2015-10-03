package com.gotofinal.autoin.api;

public interface AutoInModule
{
    /**
     * Return full name of AutoIn module.
     *
     * @return full name of AutoIn module.
     */
    String getName();

    /**
     * Return implementation side of AutoIn. It will not change at runtime.
     *
     * @return implementation side of AutoIn.
     */
    AutoInSide getSide();


    /*
     * Output methods....
     */

    /**
     * Log message/object to console.
     *
     * @param obj object/message to log.
     */
    void log(Object obj);

    /**
     * Print warning message/object to console.
     *
     * @param obj object/message to log warning.
     */
    void warn(Object obj);

    /**
     * Print debug message/object to console if debug is enabled. {@link #isDebugEnabled()}
     *
     * @param obj object/message to log debug.
     */
    default void debug(final Object obj)
    {
        this.debug(obj, 1);
    }

    /**
     * Print debug message/object to console if debug level is higher or equal to given one. {@link #getDebugLevel()} ()}
     *
     * @param obj        object/message to log debug.
     * @param debugLevel needed debug level to show message.
     */
    void debug(Object obj, int debugLevel);

    /**
     * Invoke runnable only if debug is enabled. {@link #isDebugEnabled()}
     *
     * @param runnable runnable with debug code.
     */
    default void debugRun(final Runnable runnable)
    {
        this.debugRun(runnable, 1);
    }

    /**
     * Invoke runnable only if debug level is higher or equal to given one. {@link #getDebugLevel()} ()}
     *
     * @param runnable   runnable with debug code.
     * @param debugLevel needed debug level to run debug code.
     */
    default void debugRun(final Runnable runnable, final int debugLevel)
    {
        if (this.getDebugLevel() >= debugLevel)
        {
            runnable.run();
        }
    }

    /**
     * Returns true if debug is enabled.
     *
     * @return true if debug is enabled.
     */
    default boolean isDebugEnabled()
    {
        return this.getDebugLevel() > 0;
    }

    /**
     * Return level of debug, higher level - more debug.
     *
     * @return level of debug.
     */
    int getDebugLevel();

    /**
     * Set new debug level at runtime.
     *
     * @param debug new level of debug.
     */
    void setDebugLevel(int debug);
}
