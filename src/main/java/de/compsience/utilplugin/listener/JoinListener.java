package de.compsience.utilplugin.listener;

import de.compsience.utilplugin.UtilPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.DARK_GRAY + "Willkommen auf " + ChatColor.GOLD + "Tim's " + ChatColor.DARK_GRAY + "Heiligen Boden!");
        event.setJoinMessage(ChatColor.DARK_RED + player.getName() + ChatColor.DARK_GRAY + " ist nun" + ChatColor.GOLD + " ein Spieler" + ChatColor.DARK_GRAY + "!");
        List<Player> list = new ArrayList<>(Bukkit.getOnlinePlayers());

        for (Player players : list) {
            players.playSound(players.getLocation(), Sound.BLOCK_AMETHYST_CLUSTER_HIT,10,5);
        }

        //Rucksack
        Player p = event.getPlayer();
        PersistentDataContainer data = p.getPersistentDataContainer();
        if (!data.has(new NamespacedKey(UtilPlugin.getPlugin(), "contents"), PersistentDataType.STRING)) {
            data.set(new NamespacedKey(UtilPlugin.getPlugin(), "contents"), PersistentDataType.STRING, "");
        }


    }
}
