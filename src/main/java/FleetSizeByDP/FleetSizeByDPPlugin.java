package FleetSizeByDP;

import java.util.List;
import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.fleet.FleetMemberAPI;
import FleetSizeByDP.com.starfarer.api.impl.campaign.skills.FleetSizeByDP;

public class FleetSizeByDPPlugin extends BaseModPlugin {

    private boolean MOD_ENABLED = Global.getSettings().getBoolean("useFleetSizeByDPMod");
    private boolean NOTIFICATIONS_ENABLED = Global.getSettings.getBoolean("fsdpEnableNotification");

    private static FleetSizeByDPNotification notification;

    @Override
    public void onGameLoad(boolean newGame) {

        //Add skill to player character on game load if enabled
        if(MOD_ENABLED) {
            Global.getSector().getPlayerPerson().getStats().setSkillLevel("fleet_size_by_dp", 1);

            //v1.0.0: add notification script on game load if mod enabled
            //v1.0.2: add handling for settings toggle
            if(NOTIFICATIONS_ENABLED) {
                notification = new FleetSizeByDPNotification();
                Global.getSector().addTransientScript(notification);
            }
        } 
        //if disabled, set skill to 0 and remove existing modifiers
        else {
            Global.getSector().getPlayerPerson().getStats().setSkillLevel("fleet_size_by_dp", 0);

            List<FleetMemberAPI> playerFleet = Global.getSector().getPlayerFleet().getFleetData().getMembersInPriorityOrder();
            
            for(FleetMemberAPI ship : playerFleet) {
                ship.getStats().getSuppliesPerMonth().unmodify(FleetSizeByDP.SUPPLIES_BY_FLEET_DP);
            }
           
            Global.getSector().getPlayerFleet().getStats().getFleetwideMaxBurnMod().unmodifyMult(FleetSizeByDP.BURN_MULT_BY_FLEET_DP);
        }

    }
}
