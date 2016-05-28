package net.devintia.region;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Location;

import java.util.UUID;

/**
 * Created by Martin on 28.05.2016.
 */
@Getter
@AllArgsConstructor
public class Region {

    private UUID id;
    private Location location1;
    private Location location2;

    public boolean containsLocation( Location locToCheck ) {
        double smallX = Math.min( location1.getX(), location2.getX() );
        double smallY = Math.min( location1.getY(), location2.getY() );
        double smallZ = Math.min( location1.getZ(), location2.getZ() );
        double largeX = Math.max( location1.getX(), location2.getX() );
        double largeY = Math.max( location1.getY(), location2.getY() );
        double largeZ = Math.max( location1.getZ(), location2.getZ() );

        return smallX <= locToCheck.getX() && locToCheck.getX() <= largeX &&
                smallY <= locToCheck.getY() && locToCheck.getY() <= largeY &&
                smallZ <= locToCheck.getZ() && locToCheck.getZ() <= largeZ;
    }
}
