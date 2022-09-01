package de.compsience.utilplugin.CommandExecutor;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TrollCommand implements CommandExecutor {

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
                pl.playEffect(pl.getLocation(), Effect.GHAST_SHRIEK,  3);
                pl.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 300, 4, false));
                pl.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 300, 4, false));
            }
        }

        return true;
    }
}
