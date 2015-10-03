package com.gotofinal.autoin.impl.server.spigot;

import java.util.logging.Level;

import com.gotofinal.autoin.impl.server.AutoInServerModuleImpl;

public abstract class AutoInSpigotModuleImpl extends AutoInServerModuleImpl
{
    private final SpigotMain main;

    protected AutoInSpigotModuleImpl(final SpigotMain main)
    {
        this.main = main;
    }

    @Override
    public String getName()
    {
        return "AutoIn-Spigot";
    }

    @Override
    public void log(final Object obj)
    {
        this.main.getLogger().log(Level.FINE, obj.toString());
    }

    @Override
    public void warn(final Object obj)
    {
        this.main.getLogger().log(Level.WARNING, obj.toString());
    }

    @Override
    protected void debug_(final Object obj)
    {
        this.main.getLogger().log(Level.INFO, obj.toString());
    }
}
