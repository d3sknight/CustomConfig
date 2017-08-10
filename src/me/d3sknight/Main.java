package me.d3sknight;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
public class Main extends JavaPlugin{
    public static Main plugin;

    private static Main singleton = new Main();
    public static Main getInstance( ) {
        return singleton;
    }

    @Override
    public void onEnable(){
        plugin = this;
        Config config = new Config();
        config.l = new File(getDataFolder(), "lang.yml");
        config.p = new File(getDataFolder(), "playerdata.yml");
        saveDefaultConfig();
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"Config has been loaded");
        config.mkdir();
        config.loadYamls();
    }
    @Override
    public void onDisable(){
    }
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (cmd.getName().equalsIgnoreCase("data") && sender instanceof Player){
            Config config = new Config();
            Player p = (Player) sender;
            p.sendMessage("Test thu cai");
            config.players.set(p.getUniqueId().toString(),"test!");
            config.saveData();
            return true;
        }
        return false;
    }

}
