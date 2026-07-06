package com.destroystokyo.paper;

import com.destroystokyo.paper.util.VersionFetcher;
import io.papermc.paper.ServerBuildInfo;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.checkerframework.checker.nullness.qual.NonNull;

import static io.papermc.paper.ServerBuildInfo.StringRepresentation.VERSION_SIMPLE;

@DefaultQualifier(NonNull.class)
public class PaperVersionFetcher implements VersionFetcher {
    private static final ServerBuildInfo BUILD_INFO = ServerBuildInfo.buildInfo();

    @Override
    public long getCacheTime() {
        return Long.MAX_VALUE;
    }

    @Override
    public Component getVersionMessage() {
        return Component.text(
            BUILD_INFO.brandName() + " " + BUILD_INFO.asString(VERSION_SIMPLE) + " for Minecraft " + BUILD_INFO.minecraftVersionName(),
            NamedTextColor.GREEN
        );
    }

    public static void getUpdateStatusStartupMessage() {
        // Dimigot does not check an upstream update API.
    }
}
