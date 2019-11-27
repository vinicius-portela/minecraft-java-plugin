package me.viniciusportela.minecraftjavaplugin;

import com.earth2me.essentials.api.UserDoesNotExistException;
import net.ess3.api.Economy;
import org.bukkit.OfflinePlayer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Objects;

public class Utils {

    // Create a file
    public static void write(String filename, OfflinePlayer[] player) throws IOException, UserDoesNotExistException {
        BufferedWriter outputWriter = new BufferedWriter(new FileWriter(filename));
        for (OfflinePlayer offlinePlayer : player) {
            BigDecimal money = Economy.getMoneyExact(Objects.requireNonNull(offlinePlayer.getName()));
            outputWriter.write(Objects.requireNonNull(offlinePlayer.getName()) + ": " + money.toString());
            outputWriter.newLine();
        }
        outputWriter.flush();
        outputWriter.close();
    }

}
