package de.compsience.utilplugin.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.List;

public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(ChatColor.DARK_RED + player.getName() + ChatColor.DARK_GRAY + " hat sich in " + ChatColor.GOLD + "Luft" + ChatColor.DARK_GRAY + " aufgelöst!");
        List<Player> list = new ArrayList<>(Bukkit.getOnlinePlayers());

        for (Player players : list) {
            players.playSound(players.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_CHIME,10,2);
    }   }
}
