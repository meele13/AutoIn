package com.gotofinal.autoin.api.utils.lazy;

import java.util.Collection;

import com.gotofinal.autoin.api.utils.function.CharSupplier;
import com.gotofinal.autoin.api.utils.others.Resetable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CharLazyValue implements Resetable
{
    private final CharSupplier supplier;
    private       char         cached;
    private       boolean      updated;

    public CharLazyValue(final CharSupplier supplier)
    {
        this.supplier = supplier;
    }

    public CharLazyValue(final Collection<? super CharLazyValue> collection, final CharSupplier supplier)
    {
        this.supplier = supplier;
        collection.add(this);
    }

    public char get()
    {
        if (this.updated)
        {
            return this.cached;
        }
        else
        {
            this.cached = this.supplier.getAsChar();
            this.updated = true;
            return this.cached;
        }
    }

    @Override
    public void reset()
    {
        this.updated = false;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("supplier", this.supplier).append("cached", this.cached).toString();
    }
}
