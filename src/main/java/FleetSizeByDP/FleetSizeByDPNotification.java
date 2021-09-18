package FleetSizeByDP;

import com.fs.starfarer.api.EveryFrameScript;
import com.fs.starfarer.api.Global;

import java.awt.Color;

public class FleetSizeByDPNotification implements EveryFrameScript {

    private float CHECK_INTERVAL = 10f;

    private float secSinceLastCheck = 0f;
    
    @Override
    public boolean isDone() {
        return false;
    }
    
    @Override
    public boolean runWhilePaused() {
        return false;
    }

    @Override
    public void advance(float amount) {
        //add amount to secSinceLastCheck
        //if secSinceLastCheck >= check_interval:
        //if player is under fleet limit, do nothing
        //otherwise, send notification to player while on campaign map
        //reset secSinceLastCheck to 0 afterwards
        secSinceLastCheck += amount;

        if(secSinceLastCheck >= CHECK_INTERVAL) {
            //notification goes here

            secSinceLastCheck = 0f;
        }
    }
}
