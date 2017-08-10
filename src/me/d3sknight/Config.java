package me.d3sknight;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config extends Main{
    public File l;
    public File p;
    public YamlConfiguration lang = new YamlConfiguration();
    public YamlConfiguration players = new YamlConfiguration();
    public void mkdir(){
        if(!l.exists()){
            saveResource("lang.yml", false);
        }
        if(!p.exists()){
            saveResource("playerdata.yml", false);
        }
    }
    public void loadYamls(){
        try {
            lang.load(l);
        } catch (IOException | InvalidConfigurationException e){
            e.printStackTrace();
        }
        try {
            lang.load(p);
        } catch (IOException | InvalidConfigurationException e){
            e.printStackTrace();
        }

    }
    public void saveLang() {
        try {
            lang.save(l);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveData(){
        try {
            players.save(p);
        } catch (IOException e){
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
