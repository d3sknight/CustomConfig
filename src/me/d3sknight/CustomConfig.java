package me.d3sknight;


import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
public class CustomConfig extends JavaPlugin{
    public static CustomConfig singleton;
    public static CustomConfig getInstance( ) {
        return singleton;
    }

    @Override
    public void onEnable(){
        singleton = this;
        Config config = new Config();
        config.l = new File(getDataFolder(), "lang.yml");
        config.p = new File(getDataFolder(), "playerdata.yml");
        saveDefaultConfig();
        config.mkdir();
        config.loadYamls();
    }
    @Override
    public void onDisable(){
    }
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (cmd.getName().equalsIgnoreCase("data") && sender instanceof Player){
            Config config = new Config();
            config.getPlayersData();
            Player p = (Player) sender;
            p.sendMessage("Test thu cai");
            config.players.set(p.getUniqueId().toString(),"test!");
            config.saveData();
            return true;
        }
        return false;
    }

}
