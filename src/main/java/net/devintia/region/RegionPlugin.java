package net.devintia.region;

import lombok.Getter;
import net.devintia.quests.QuestPlugin;
import net.devintia.quests.quest.QuestHandler;
import net.devintia.quests.trigger.TriggerHandler;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Martin on 28.05.2016.
 */
@Getter
public class RegionPlugin extends JavaPlugin {

    private RegionHandler regionHandler;
    private TriggerHandler triggerHandler;

    @Override
    public void onEnable() {
        regionHandler = new RegionHandler();

        triggerHandler = ( (QuestPlugin) getServer().getPluginManager().getPlugin( "DevintiaQuests" ) ).getTriggerHandler();

        getServer().getPluginManager().registerEvents( new MoveListener( this ), this );
    }
}
