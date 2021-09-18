package FleetSizeByDP;

import com.fs.starfarer.api.EveryFrameScript;
import com.fs.starfarer.api.Global;

import java.awt.Color;

public class FleetSizeByDPNotification implements EveryFrameScript {

    private float CHECK_INTERVAL = 10f;

    private float secSinceLastCheck = 0f;

    private String message = "This is a test message from FleetSizeByDP: can you see me?";
    
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
        secSinceLastCheck += amount;
        checkStatus();
    }

    private void checkStatus() {
        //if secSinceLastCheck >= check_interval:
        //if player is under fleet limit, do nothing
        //otherwise, send notification to player while on campaign map
        //reset secSinceLastCheck to 0 afterwards

        if(secSinceLastCheck >= CHECK_INTERVAL) {
            //notification goes here
            Global.getSector().getCampaignUI().addMessage(message, Color.PINK);
            resetTimer();
        }
    }

    private void resetTimer() {
        secSinceLastCheck = 0f;
    }
}
