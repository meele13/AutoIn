package com.gotofinal.autoin.api.cfg.annotations.defaults;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used by {@link CfgDelegateImport} for {@link java.lang.annotation.Repeatable} annotations.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface CfgDelegateImportArray
{
    /**
     * @return all single imports annotations.
     */
    CfgDelegateImport[] value();
}
