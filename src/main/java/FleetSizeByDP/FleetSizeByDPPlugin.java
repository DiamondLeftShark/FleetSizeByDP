package FleetSizeByDP;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import FleetSizeByDP.com.starfarer.api.impl.campaign.skills.FleetSizeByDP;

public class FleetSizeByDPPlugin extends BaseModPlugin {

    private boolean MOD_ENABLED = Global.getSettings().getBoolean("useFleetSizeByDPMod");

    @Override
    public void onGameLoad(boolean newGame) {

        //Add skill to player character on game load if enabled: else, set skill level to 0
        if(MOD_ENABLED) {
            Global.getSector().getPlayerPerson().getStats().setSkillLevel("fleet_size_by_dp", 1);
        } 
        else {
            //Global.getSector().getPlayerPerson().getStats().setSkillLevel("fleet_size_by_dp", 0);
            //remove existing modifiers, if present
            //getSuppliesPerMonth().unmodify(FleetSizeByDP.SUPPLIES_BY_FLEET_DP);
            //Global.getSector().getPlayerFleet().getStats().getFleetwideMaxBurnMod().unmodifyMult(FleetSizeByDP.BURN_MULT_BY_FLEET_DP);
            if(Global.getSector().hasScript(FleetSizeByDP.class)) {
                Global.getSector().removeScriptsOfClass(FleetSizeByDP.class)
            }
        }

    }
}
