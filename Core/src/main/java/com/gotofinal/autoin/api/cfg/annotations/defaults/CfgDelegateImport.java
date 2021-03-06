package com.gotofinal.autoin.api.cfg.annotations.defaults;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used by {@link CfgDelegateDefault} to provide more imports to code, so you don't need use full names.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
@Repeatable(CfgDelegateImportArray.class)
public @interface CfgDelegateImport
{
    /**
     * @return class/package to import.
     */
    String value();
}
