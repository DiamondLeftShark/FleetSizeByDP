package FleetSizeByDP;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;

public class FleetSizeByDPPlugin extends BaseModPlugin {

    /*On game load:
    * Check if FleetSizeByDP skill is assigned to player character
    * If not, assign it and notify player.
    */
    @Override
    public void onGameLoad(boolean newGame) {

        //Add skill to player character
        //Test to confirm proper way to assign skill to player: rewrite to use fleet_size_by_dp skill
        Global.getSector().getPlayerPerson().getStats().setSkillLevel("electronic_warfare", 1);


        //test throw to confirm Starsector is picking up onGameLoad
        //throw new NullPointerException("Test by FleetSizeByDP");
    }
}
