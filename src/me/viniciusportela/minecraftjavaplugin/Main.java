package me.viniciusportela.minecraftjavaplugin;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.api.UserDoesNotExistException;
import net.ess3.api.Economy;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

public class Main extends JavaPlugin {

    static Plugin plugin;
    final int secondsDelay = 5;

    @Override
    public void onEnable() {
        plugin = this;

        // Another way to use getLogger
        // Bukkit.getLogger()
        getLogger().info("Plugin Loaded");

        // Get list of players
        //OfflinePlayer[] players = Bukkit.getOfflinePlayers();

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

        /*try {
            Economy.getMoneyExact("Viniccius007");
        } catch (UserDoesNotExistException e) {
            getLogger().info("User Viniccius007 doesn't exists");
            //e.printStackTrace();
        }*/

        super.onEnable();
    }
}
