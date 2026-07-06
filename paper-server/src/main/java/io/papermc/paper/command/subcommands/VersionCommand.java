package io.papermc.paper.command.subcommands;

import io.papermc.paper.ServerBuildInfo;
import io.papermc.paper.command.PaperSubcommand;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.framework.qual.DefaultQualifier;

@DefaultQualifier(NonNull.class)
public final class VersionCommand implements PaperSubcommand {
    @Override
    public boolean execute(final CommandSender sender, final String subCommand, final String[] args) {
        final ServerBuildInfo build = ServerBuildInfo.buildInfo();
        sender.sendMessage(label("Dimigot 버전", build.asString(ServerBuildInfo.StringRepresentation.VERSION_SIMPLE)));
        sender.sendMessage(label("Minecraft 버전", build.minecraftVersionName()));
        sender.sendMessage(label("Bukkit API", Bukkit.getBukkitVersion()));
        return true;
    }

    private static Component label(final String label, final String value) {
        return Component.text(label + ": ", NamedTextColor.GRAY)
            .append(Component.text(value, NamedTextColor.GREEN));
    }
}
