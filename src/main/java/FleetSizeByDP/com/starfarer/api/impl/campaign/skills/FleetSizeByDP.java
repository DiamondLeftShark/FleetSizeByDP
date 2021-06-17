package FleetSizeByDP.com.starfarer.api.impl.campaign.skills;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.impl.campaign.skills.BaseSkillEffectDescription;
import com.fs.starfarer.api.campaign.FleetDataAPI;
import com.fs.starfarer.api.characters.FleetTotalItem;
import com.fs.starfarer.api.characters.FleetTotalSource;
import com.fs.starfarer.api.characters.MutableCharacterStatsAPI;
import com.fs.starfarer.api.characters.ShipSkillEffect;
import com.fs.starfarer.api.characters.SkillSpecAPI;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.ui.TooltipMakerAPI;

//"Skill" that checks current fleet DP and applies increased supply use/burn speed reduction if over the limit.
//This skill should only ever be assigned to the main player character, for obvious reasons.
public class FleetSizeByDP {

    private int MAX_FLEET_BY_DP = Global.getSettings().getInt("maxShipsInPlayerFleetByDP");
    public static boolean ENABLED = false;
    
    //Supply multiplier
    public static String SUPPLIES_BY_FLEET_DP = "supply_use_mult_by_dp";

    public static class Level1 extends BaseSkillEffectDescription implements ShipSkillEffect, FleetTotalSource {

        //should display OP total 
        public FleetTotalItem getFleetTotalItem() {
			return getOPTotal();
		}

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            //TBD
            id = SUPPLIES_BY_FLEET_DP;
            float useMult = getFleetSupplyMult();
            stats.getSuppliesPerMonth().modifyMult(id, useMult);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            //TBD
            id = SUPPLIES_BY_FLEET_DP;
            stats.getSuppliesPerMonth().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return null;
        }

        public ScopeDescription getScopeDescription() {
			return ScopeDescription.FLEET;
		}

        //TBD add function to calculate fleet supply multiplier
        private float getFleetSupplyMult() {
            return 1f;
        }
    }

    //Burn speed multiplier
/*    
    public static class Level2 extends BaseSkillEffectDescription implements ShipSkillEffect, FleetTotalSource {
        
    } 
*/
}
