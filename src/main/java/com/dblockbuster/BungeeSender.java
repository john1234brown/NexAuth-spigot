package com.dblockbuster;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class BungeeSender {

    private final Plugin plugin;
    
    private static final String CHANNEL = "ambassador:main";

    public BungeeSender(Plugin plugin) {
        this.plugin = plugin;
    }

    public void sendMessageToBungee(String subChannel, String playerName) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF(subChannel);
        out.writeUTF(playerName);

        Player anyPlayer = Bukkit.getServer().getOnlinePlayers().stream().findFirst().orElse(null);
        if (anyPlayer != null) {
            anyPlayer.sendPluginMessage(plugin, "ambassador:main", out.toByteArray()); // Include colon in channel name
        }
    }
    
    /*public void sendMessageToProxy(
            final Player player,
            final @NotNull MessageType type,
            final @NotNull String playerName
    ) {
        final ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF(type.toString());
        out.writeUTF(playerName);

        if (player == null) {
            Bukkit.getServer().sendPluginMessage(plugin, CHANNEL, out.toByteArray());
            Bukkit.getLogger().info("MessageToProxy | Null Player, Player Name: " + playerName + " With messagetype: "+type);
        } else {
            player.sendPluginMessage(plugin, CHANNEL, out.toByteArray());
            Bukkit.getLogger().info("MessageToProxy | Player Present: " + playerName + " With messagetype: "+type);
        }
    }

    public void sendMessageToProxy(
            final Player player,
            final @NotNull MessageType type
    ) {
        sendMessageToProxy(player, type, player.getName());
    }*/



}

