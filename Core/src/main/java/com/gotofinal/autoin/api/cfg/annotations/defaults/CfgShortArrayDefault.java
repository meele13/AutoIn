package com.gotofinal.autoin.api.cfg.annotations.defaults;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used to define default value of short[] type.
 * It will be read from field only if field have compatybile type.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CfgShortArrayDefault
{
    /**
     * @return default value of configuration field.
     */
    short[] value();
}
