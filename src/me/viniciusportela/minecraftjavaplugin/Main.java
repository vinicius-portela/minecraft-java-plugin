package me.viniciusportela.minecraftjavaplugin;

import com.earth2me.essentials.api.UserDoesNotExistException;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.IOException;

public class Main extends JavaPlugin {

    static Plugin plugin;

    @Override
    public void onEnable() {

        plugin = this;
        this.saveDefaultConfig();

        // Read Configuration
        final int secondsDelay = this.getConfig().getInt("updateTime");

        // Another way to use getLogger
        // Bukkit.getLogger()
        getLogger().info("Plugin Loaded");

        //0 = Tick Initial Delay
        //20L = 20 Ticks -> de delay
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                /*for(OfflinePlayer item : players){
                    getLogger().info(ChatColor.RED + "Player :" + item.getName());
                    Utils.write(item.getName());
                }*/
                OfflinePlayer[] players = Bukkit.getOfflinePlayers();
                try {
                    Utils.write("./players.txt", players);
                } catch (IOException | UserDoesNotExistException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 20L * secondsDelay);

        super.onEnable();
    }
}