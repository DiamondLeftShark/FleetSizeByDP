package FleetSizeByDP;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import FleetSizeByDP.com.starfarer.api.impl.campaign.skills.FleetSizeByDP;

public class FleetSizeByDPPlugin extends BaseModPlugin {

    private boolean ENABLED = Global.getSettings().getBoolean("useFleetSizeByDPMod");

    /*On game load:
    * Check if FleetSizeByDP skill is assigned to player character
    * If not, assign it and notify player.
    */
    @Override
    public void onGameLoad(boolean newGame) {

        //Add skill to player character
        //Test to confirm proper way to assign skill to player: rewrite to use fleet_size_by_dp skill
        if(ENABLED) {
            Global.getSector().getPlayerPerson().getStats().setSkillLevel("fleet_size_by_dp", 1);
        } 
        else {
            Global.getSector().getPlayerPerson().getStats().setSkillLevel("fleet_size_by_dp", 0);
        }


        //test throw to confirm Starsector is picking up onGameLoad
        //throw new NullPointerException("Test by FleetSizeByDP");
    }
}
