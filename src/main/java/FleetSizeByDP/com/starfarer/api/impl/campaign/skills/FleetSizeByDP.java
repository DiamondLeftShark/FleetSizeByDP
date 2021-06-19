package FleetSizeByDP.com.starfarer.api.impl.campaign.skills;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.impl.campaign.skills.BaseSkillEffectDescription;
import com.fs.starfarer.api.campaign.CampaignFleetAPI;
import com.fs.starfarer.api.campaign.FleetDataAPI;
import com.fs.starfarer.api.characters.FleetTotalItem;
import com.fs.starfarer.api.characters.FleetTotalSource;
import com.fs.starfarer.api.characters.MutableCharacterStatsAPI;
import com.fs.starfarer.api.characters.ShipSkillEffect;
import com.fs.starfarer.api.characters.SkillSpecAPI;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.ui.TooltipMakerAPI;

//Skill that checks current player fleet DP and applies increased supply use/burn speed reduction if over the limit.
//This skill should only ever be assigned to the player character, for obvious reasons.
public class FleetSizeByDP {

    //settings.json values
    private static int MAX_FLEET_BY_DP = Global.getSettings().getInt("maxShipsInPlayerFleetByDP");
    private static float SUPPLY_PENALTY_MULT = Global.getSettings().getFloat("suppliesPerShipOverMaxInFleet");
    
    //helper function for current fleet DP
    public static float getCurrentFleetDP() {
        CampaignFleetAPI fleet = Global.getSector().getPlayerFleet();
        MutableCharacterStatsAPI stats = Global.getSector().getPlayerStats();

        return BaseSkillEffectDescription.getTotalOP(fleet.getFleetData(), stats);
    }


    //Level1: implements supply use modifier

    //Supply multiplier id
    public static String SUPPLIES_BY_FLEET_DP = "supply_use_mult_by_dp";

    public static class Level1 extends BaseSkillEffectDescription implements ShipSkillEffect, FleetTotalSource {

        //display OP total on fleet page
        public FleetTotalItem getFleetTotalItem() {
			return getOPTotal();
		}

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            id = SUPPLIES_BY_FLEET_DP;
            float useMult = getFleetSupplyMult();
            stats.getSuppliesPerMonth().modifyMult(id, useMult);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            id = SUPPLIES_BY_FLEET_DP;
            stats.getSuppliesPerMonth().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return null;
        }

        public ScopeDescription getScopeDescription() {
			return ScopeDescription.FLEET;
		}

        //calculate fleet supply multiplier
        public float getFleetSupplyMult() {

            float currentDP = getCurrentFleetDP();

            if(currentDP <= MAX_FLEET_BY_DP) {
                return 1f;
            } 
            else {
                float baseMult = 1 + Math.max(SUPPLY_PENALTY_MULT, 0);
                float fleetOverMult = (currentDP / MAX_FLEET_BY_DP);
                return baseMult * fleetOverMult;
            }
        }
    }

    //Level 2: implements burn speed multiplier

    //burn multiplier id
    public static String BURN_MULT_BY_FLEET_DP = "burn_mult_by_dp";
   
    public static class Level2 extends BaseSkillEffectDescription implements ShipSkillEffect, FleetTotalSource {
        public FleetTotalItem getFleetTotalItem() {
			return getOPTotal();
		}

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            //TBD
            id = BURN_MULT_BY_FLEET_DP;
            float burnMult = getFleetBurnMult();
            Global.getSector().getPlayerFleet().getStats().getFleetwideMaxBurnMod().modifyMult(id, burnMult);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            //TBD
            id = BURN_MULT_BY_FLEET_DP;
            Global.getSector().getPlayerFleet().getStats().getFleetwideMaxBurnMod().unmodifyMult(id);
        }

        public String getEffectDescription(float level) {
            return null;
        }

        public ScopeDescription getScopeDescription() {
			return ScopeDescription.FLEET;
		}

        public float getFleetBurnMult() {
            float currentDP = getCurrentFleetDP();

            if(currentDP <= MAX_FLEET_BY_DP) {
                return 1f;
            } 
            else {
                return 0.5f;
            }
        }

    } 

}
