package de.compsience.utilplugin.CommandExecutor;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class SmiteCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        if (!(sender.hasPermission("op.smite"))) {
            return true;
        }

        Player p = (Player) sender;
        String name = args[0];

        for (Player pl: Bukkit.getOnlinePlayers()) {
            if (pl.getName().equals(name)) {
                Location location = pl.getLocation();
                Objects.requireNonNull(location.getWorld()).strikeLightning(location);
            }
        }

        for (Player p2: Bukkit.getOnlinePlayers()) {
            p2.sendMessage(ChatColor.DARK_GRAY + "Der Spieler " + ChatColor.GOLD + args[0] + ChatColor.DARK_GRAY + " wurde von Gott bestraft.");
        }


        return true;
    }
}
