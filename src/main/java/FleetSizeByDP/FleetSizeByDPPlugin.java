package FleetSizeByDP;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;

public class FleetSizeByDPPlugin extends BaseModPlugin {

    @Override
    public void onGameLoad(boolean newGame) {
        int maxFleet = Global.getSettings().getInt("maxShipsInFleet");
        Global.getSector().getCampaignUI().addMessage("FleetSizeByDP loaded: current max fleet size is " + maxFleet + ".");
    }
}
