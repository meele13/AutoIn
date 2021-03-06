package com.gotofinal.autoin.api.cfg.annotations.defaults;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used to define default value of {@link String} type.
 * It will be read from field only if field have compatybile type.
 * <p>
 * Strings can be also used for {@link java.io.File} default values.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CfgStringDefault
{
    /**
     * @return default value of configuration field.
     */
    String value();
}
