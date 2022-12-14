package me.haru301.simpleradio.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class ModConfigs
{
    public static ForgeConfigSpec SERVER_CONFIG;

    public static ForgeConfigSpec.IntValue CHANNEL_SIZE;
    public static ForgeConfigSpec.BooleanValue RADIO_FILTER;
    //TODO Make Radio Filter Methods

    public static void init()
    {
        initServer();
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG);
    }

    private static void initServer()
    {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.comment("General Config").push("general");
        CHANNEL_SIZE = builder
                .comment("Radio Channel Size Value")
                .defineInRange("channelSize", 10, 1, Short.MAX_VALUE);
        RADIO_FILTER = builder
                .comment("Adjust whether you are going to use Radio voice Effect on you Server")
                .define("radioFilter", false);
        builder.pop();

        SERVER_CONFIG = builder.build();
    }
}
