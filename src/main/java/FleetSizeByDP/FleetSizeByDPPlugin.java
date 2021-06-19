package FleetSizeByDP;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;

public class FleetSizeByDPPlugin extends BaseModPlugin {

    private boolean MOD_ENABLED = Global.getSettings().getBoolean("useFleetSizeByDPMod");

    @Override
    public void onGameLoad(boolean newGame) {

        //Add skill to player character on game load if enabled: else, set skill level to 0
        if(MOD_ENABLED) {
            Global.getSector().getPlayerPerson().getStats().setSkillLevel("fleet_size_by_dp", 1);
        } 
        else {
            Global.getSector().getPlayerPerson().getStats().setSkillLevel("fleet_size_by_dp", 0);
        }

    }
}
