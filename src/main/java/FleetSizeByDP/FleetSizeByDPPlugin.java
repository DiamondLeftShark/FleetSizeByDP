package FleetSizeByDP;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;

public class FleetSizeByDPPlugin extends BaseModPlugin {
    

    @Override
    public void onGameLoad(boolean newGame) {
        //set player fleet to large number of max ships
        //currently set to 10 for testing
        Global.getSettings().setFloat("maxShipsInFleet", 10f);
    }
}
