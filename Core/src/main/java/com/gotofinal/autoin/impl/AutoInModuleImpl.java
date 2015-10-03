package com.gotofinal.autoin.impl;

import com.gotofinal.autoin.api.AutoInModule;

public abstract class AutoInModuleImpl implements AutoInModule
{
    protected int debugLevel;


    /*
     * Output methods....
     */

    @Override
    public int getDebugLevel()
    {
        return this.debugLevel;
    }

    @Override
    public void setDebugLevel(final int debugLevel)
    {
        this.debugLevel = debugLevel;
    }

    @Override
    public void debug(final Object obj, final int debugLevel)
    {
        if (this.debugLevel >= debugLevel)
        {
            this.debug_(obj);
        }
    }

    protected abstract void debug_(Object obj);
}
