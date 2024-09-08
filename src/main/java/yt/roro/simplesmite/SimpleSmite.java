package yt.roro.simplesmite;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import yt.roro.simplesmite.commands.Smite;

public final class SimpleSmite extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("SimpleSmite is online!");
        getCommand("smite").setExecutor(new Smite());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("SimpleSmite is going offline! Bye Bye");
    }

}
