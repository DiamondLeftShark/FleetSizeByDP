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

    int maxFleetByDP = Global.getSettings().getInt("maxShipsInPlayerFleetByDP");
    
    public static class Level1 extends BaseSkillEffectDescription implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            //TBD
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            //TBD
        }

        public String getEffectDescription(float level) {
            return null;
        }

        public ScopeDescription getScopeDescription() {
			return ScopeDescription.FLEET;
		}

        //Calculates extra supplies consumed by fleet.  Should return 0 if current fleet DP <= maxFleetByDP
        private float calculateExtraSupplies() {
            //TBD
            return 0f;
        }

        //Calculates burn speed reduction for fleet.  Should return 0 if current fleet DP <= maxFleetByDP
        private float calculateReducedBurnSpeed() {
            //TBD
            return 0f;
        }

    }

}
