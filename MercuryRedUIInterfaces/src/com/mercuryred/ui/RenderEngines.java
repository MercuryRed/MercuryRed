package com.mercuryred.ui;

import com.mercuryred.render.interfaces.IRenderEngine;

public final class RenderEngines {
    private static IRenderEngine _renderEngineCurrent = null;
    private static IRenderEngine _renderEngineNext = null;

    public static IRenderEngine Get() {
        return _renderEngineCurrent;
    }

    // Use can be called async in mid frame rendering
    public static void Use(IRenderEngine renderEngine) {
        _renderEngineNext = renderEngine;
    }

    // StartRenderSession needs to be called only by the render thread, before rendering a new Frame
    public static void StartRenderFrame() {
        _renderEngineCurrent = _renderEngineNext;
    }
}
