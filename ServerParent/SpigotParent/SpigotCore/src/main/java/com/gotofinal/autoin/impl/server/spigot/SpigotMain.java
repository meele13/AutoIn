package com.gotofinal.autoin.impl.server.spigot;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class SpigotMain extends JavaPlugin
{
    private static SpigotMain instance;
    private static Logger logger;

    public static SpigotMain getInstance()
    {
        return instance;
    }

    {
        SpigotMain.instance = this;
        logger = this.getLogger();
    }

    @Override
    public void onEnable()
    {

    }

    @Override
    public void onDisable()
    {

    }

}
