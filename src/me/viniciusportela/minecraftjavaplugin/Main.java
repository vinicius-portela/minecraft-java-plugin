package me.viniciusportela.minecraftjavaplugin;

import com.earth2me.essentials.api.Economy;
import com.earth2me.essentials.api.UserDoesNotExistException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;

        // Another way to use getLogger
        // Bukkit.getLogger()
        getLogger().info("Plugin Loaded");

        try {
            Economy.getMoneyExact("Viniccius007");
        } catch (UserDoesNotExistException e) {
            e.printStackTrace();
        }

        super.onEnable();
    }
}
