package de.compsience.utilplugin;

import de.compsience.utilplugin.CommandExecutor.PingCommand;
import de.compsience.utilplugin.CommandExecutor.SmiteCommand;
import de.compsience.utilplugin.CommandExecutor.TrollCommand;
import de.compsience.utilplugin.CommandExecutor.dateCommand;
import de.compsience.utilplugin.listener.JoinListener;
import de.compsience.utilplugin.listener.QuitListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class UtilPlugin extends JavaPlugin {

    private static UtilPlugin plugin;

    @Override
    public void onEnable() {
        Bukkit.getLogger().fine("Plugin wird aktiviert");
        CommandRegistration();
        listenerRegistration();
        plugin = this;

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().fine("Plugin wird deaktiviert");

    }

    private void listenerRegistration(){
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(),  this);
        pluginManager.registerEvents(new QuitListener(),  this);
    }

    private void CommandRegistration() {
        getCommand("date").setExecutor(new dateCommand());
        getCommand("smite").setExecutor(new SmiteCommand());
        getCommand("troll").setExecutor(new TrollCommand());
        getCommand("segen").setExecutor(new PingCommand());

    }

    public static UtilPlugin getPlugin() {
        return plugin;
    }
}
