package com.hyperiumjailbreak;

import cc.hyperium.Hyperium;
import cc.hyperium.internal.addons.IAddon;

public class DiscordRPAddon implements IAddon {
    private final DiscordPresence handler = new DiscordPresence();

    @Override
    public void onLoad() {
        Hyperium.LOGGER.info("Successfully loaded DiscordRP!");

        Hyperium.CONFIG.register(MiniRPCSettings.INSTANCE);
        handler.load();
    }

    @Override
    public void onClose() {
        handler.shutdown();

        Hyperium.LOGGER.info("Unloaded DiscordRP addon.");
    }
}
