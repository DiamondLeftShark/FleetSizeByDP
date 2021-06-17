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

        //TBD

        //change max ships in player fleet count for testing
       // Global.getSettings().setFloat("maxShipsInFleet", 10f);
       // Global.getSettings().setFloat("showMaxShipsWidgetAtShips", 5f);
        int maxFleet = Global.getSettings().getInt("maxShipsInFleet");
        Global.getSector().getCampaignUI().addMessage("FleetSizeByDP loaded: current max fleet size is " + maxFleet + ".");

        //test throw to confirm Starsector is picking up onGameLoad
        //throw new NullPointerException("Test by FleetSizeByDP");
    }
}
