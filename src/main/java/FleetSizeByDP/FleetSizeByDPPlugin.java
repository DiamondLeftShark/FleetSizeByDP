package FleetSizeByDP;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import FleetSizeByDP.com.starfarer.api.impl.campaign.skills.FleetSizeByDP;

public class FleetSizeByDPPlugin extends BaseModPlugin {

    private boolean MOD_ENABLED = Global.getSettings().getBoolean("useFleetSizeByDPMod");

    /*On game load:
    * Check if FleetSizeByDP skill is assigned to player character
    * If not, assign it and notify player.
    */
    @Override
    public void onGameLoad(boolean newGame) {

        //Add skill to player character
        //Test to confirm proper way to assign skill to player: rewrite to use fleet_size_by_dp skill
        if(MOD_ENABLED) {
            FleetSizeByDP.ENABLED = true;
            Global.getSector().getPlayerPerson().getStats().setSkillLevel("fleet_size_by_dp", 1);
        } 
        else {
            FleetSizeByDP.ENABLED = false;
        }


        //test throw to confirm Starsector is picking up onGameLoad
        //throw new NullPointerException("Test by FleetSizeByDP");
    }
}
