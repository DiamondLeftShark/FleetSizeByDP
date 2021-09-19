package FleetSizeByDP;

import com.fs.starfarer.api.EveryFrameScript;
import com.fs.starfarer.api.Global;
import FleetSizeByDP.com.starfarer.api.impl.campaign.skills.FleetSizeByDP;

import java.awt.Color;

public class FleetSizeByDPNotification implements EveryFrameScript {

    private float CHECK_INTERVAL = 10f;
    private float secSinceLastCheck = 0f;

    private String messageA = "Your fleet is over its maximum DP allowance by ";
    private String messageB = " DP.  Supply use increased by ";
    private String messageC = "% and maximum burn speed reduced.";
    
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
            //Global.getSector().getCampaignUI().addMessage(message, Color.ORANGE);

            if(FleetSizeByDP.isFleetOverLimit()) {
                int dp = Math.round(FleetSizeByDP.getDPOverLimit());
                int supplyPercent = Math.round(FleetSizeByDP.getSupplyPenaltyInPercent());
                String message = messageA + dp + messageB + supplyPercent + messageC;

                Global.getSector().getCampaignUI().addMessage(message, Color.RED);
            }

            resetTimer();
        }
    }

    private void resetTimer() {
        secSinceLastCheck = 0f;
    }
}
