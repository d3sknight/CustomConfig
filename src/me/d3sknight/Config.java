package me.d3sknight;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    CustomConfig main = CustomConfig.getInstance();


    public File l;
    public File p;
    public YamlConfiguration lang = new YamlConfiguration();
    public YamlConfiguration players = new YamlConfiguration();
    public void mkdir(){
        if(!l.exists()){
            main.saveResource("lang.yml", false);
        }
        if(!p.exists()){
            main.saveResource("playerdata.yml", false);
        }
    }
    public void loadYamls(){

        try {
            lang.load(l);
            players.load(p);
        } catch (IOException | InvalidConfigurationException e){
            e.printStackTrace();
        }
    }
    public void save() {
        try {
            lang.save(l);
            players.save(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public YamlConfiguration getLang(){
        return lang;
    }
    public YamlConfiguration getPlayersData(){
        return players;
    }
}
