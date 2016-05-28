package net.devintia.region;

import net.devintia.quests.trigger.TriggerType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;

/**
 * Created by Martin on 28.05.2016.
 */
public class MoveListener implements Listener {

    private RegionPlugin plugin;

    public MoveListener( RegionPlugin regionPlugin ) {
        this.plugin = regionPlugin;
    }

    @EventHandler
    public void onPlayerRespawn( PlayerRespawnEvent event ) {

    }

    @EventHandler
    public void onVehicleEnter( VehicleEnterEvent event ) {

    }

    @EventHandler
    public void onPlayerMove( PlayerMoveEvent event ) {
        if ( event.getFrom().getX() != event.getTo().getX() || event.getFrom().getY() != event.getTo().getY() || event.getFrom().getZ() != event.getTo().getZ() ) {
            for ( Region region : plugin.getRegionHandler().getRegionsAt( event.getTo() ) ) {
                plugin.getTriggerHandler().trigger( TriggerType.ENTER_REGION, region.getId(), event.getPlayer() );
            }
        }
    }
}
