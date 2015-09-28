package com.gotofinal.autoin.api.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

import sun.misc.Unsafe;

public final class DioriteUtils
{
    private static final Unsafe unsafeInstance;
    public static final int[] EMPTY_INT = new int[0];

    private DioriteUtils()
    {
    }

    static
    {
        try
        {
            final Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafeInstance = (Unsafe) field.get(null);
        } catch (final Throwable e)
        {
            throw new Error("Can't find unsafe instance.", e);
        }
    }

    /**
     * Don't ise that if you don't know what {@link Unsafe} is.
     *
     * @return unsafe instance.
     */
    public static Unsafe getUnsafe()
    {
        return unsafeInstance;
    }

    /**
     * Create file directory, and then create file.
     *
     * @param file file to create.
     *
     * @throws IOException from {@link File#createNewFile()}
     */
    public static void createFile(final File file) throws IOException
    {
        if (file.exists())
        {
            return;
        }
        file.getAbsoluteFile().getParentFile().mkdirs();
        file.createNewFile();
    }

    public static UUID getCrackedUuid(final String nick)
    {
        return UUID.nameUUIDFromBytes(("OfflinePlayer:" + nick).getBytes(StandardCharsets.UTF_8));
    }

    public static int size(final Iterable<?> iterable)
    {
        return (iterable instanceof Collection) ? ((Collection<?>) iterable).size() : size(iterable.iterator());
    }

    public static int size(final Iterator<?> iterator)
    {
        int count = 0;
        while (iterator.hasNext())
        {
            iterator.next();
            count++;
        }
        return count;
    }
}
