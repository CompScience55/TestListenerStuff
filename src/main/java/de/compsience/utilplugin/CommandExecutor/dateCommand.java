package de.compsience.utilplugin.CommandExecutor;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Date;

public class dateCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Date date = new Date();
        sender.sendMessage(ChatColor.WHITE + "Die Uhrzeit ist: " +ChatColor.GOLD + date.toString());
        return false;
    }
}
