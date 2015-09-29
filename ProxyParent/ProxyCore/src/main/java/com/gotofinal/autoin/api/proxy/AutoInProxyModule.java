package com.gotofinal.autoin.api.proxy;

import com.gotofinal.autoin.api.AutoInModule;
import com.gotofinal.autoin.api.AutoInSide;

public interface AutoInProxyModule extends AutoInModule
{
    @Override
    default AutoInSide getSide()
    {
        return AutoInSide.PROXY;
    }
}
