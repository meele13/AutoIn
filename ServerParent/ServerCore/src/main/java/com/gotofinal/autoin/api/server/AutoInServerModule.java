package com.gotofinal.autoin.api.server;

import com.gotofinal.autoin.api.AutoInModule;
import com.gotofinal.autoin.api.AutoInSide;

public interface AutoInServerModule extends AutoInModule
{
    @Override
    default AutoInSide getSide()
    {
        return AutoInSide.SERVER;
    }
}
