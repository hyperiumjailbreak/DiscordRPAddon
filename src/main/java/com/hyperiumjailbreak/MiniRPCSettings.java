package com.hyperiumjailbreak;

import cc.hyperium.config.Category;
import cc.hyperium.config.ConfigOpt;
import cc.hyperium.config.ToggleSetting;

public class MiniRPCSettings {
    public static final MiniRPCSettings INSTANCE = new MiniRPCSettings();

    @ConfigOpt @ToggleSetting(name = "Discord RP", category = Category.INTEGRATIONS)
    public static boolean DISCORD_RP = true;
}
