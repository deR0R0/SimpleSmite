package yt.roro.simplesmite.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.List;

public class Smite implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        // Check if command issuer is a player
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(ChatColor.GOLD + "[SimpleSmite] " + ChatColor.RED + "Only players can use this command!");
            return true;
        }

        Player sender = (Player)commandSender;

        // Check if player is op
        if(!(sender.isOp())) {
            commandSender.sendMessage(ChatColor.GOLD + "[SimpleSmite] " + ChatColor.RED + "You need OP to run this command!");
            return true;
        }


        // Smite the amount of players listed
        for(int i = 1; i<=args.length; i++) {
            // Grab player
            String targetName = args[i-1];
            Player target = Bukkit.getServer().getPlayerExact(targetName);
            // Check if player is online
            if (target == null) {
                commandSender.sendMessage(ChatColor.GOLD + "[SimpleSmite] " + ChatColor.RED + "Player Offline: " + targetName);
            } else {
                //Grab target coords
                Location targetLocation = target.getLocation();
                // Spawn the lightning bolt entity
                target.getWorld().spawnEntity(targetLocation, EntityType.LIGHTNING_BOLT);
                commandSender.sendMessage(ChatColor.GOLD + "[SimpleSmite] " + ChatColor.GREEN + "Successfully Smited Player: " + targetName);
            }
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String label, String[] args) {
        return null;
    }
}
