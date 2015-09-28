package com.gotofinal.autoin.api.utils.function;

import java.util.function.Predicate;

public final class FunctionUtils
{
    private FunctionUtils()
    {
    }

    public static <T> Predicate<T> not(final Predicate<T> t)
    {
        return t.negate();
    }
}
