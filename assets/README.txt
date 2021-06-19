ABOUT

This mod changes how the player's max fleet size is determined: instead of ship count, total DP (not including
mothballed ships) is counted instead.  Going over the fleet DP limit will incur burn speed and supply use
penalties, similar to vanilla.

CONFIGURATION

Mod settings are available in data\config\settings.json.

DISABLING MID-GAME

To disable this mod and return to vanilla fleet tracking, DO NOT disable this mod in the mod manager.  Instead:

1. Open this mod's settings.json file and change "useFleetSizeByDPMod" to false.
2. In the same file, comment out "showMaxShipsWidgetAtShips" and "maxShipsInFleet".
3. With this mod enabled, load game as normal.

--!--IF USING QUALITY CAPTAINS (OR SIMILAR MODS) READ THIS--!--

This mod is implemented via a hidden skill added to the player character on game load: this skill tracks
the player's total fleet DP and calculates the supply/burn speed penalty if necessary.  Quality Captains 
completely replaces the vanilla skill_data.csv file, preventing other mods from merging their own
skill_data.csv into the base game's file (e.g. this one).  Under normal circumstances, running this mod
and QC together will cause a crash when loading the game.

If you wish to use this mod with Quality Captains, you will need to perform the following steps:

1. Go to Quality Captains\data\characters\skills and open the skill_data.csv file in a text editor (Notepad).
If you are not sure what you are doing, I recommend making a copy of this file before continuing so that you
have a backup if something goes wrong.

2. Copy and paste the following line on a new line at the bottom of the file:

fleet_size_by_dp,Fleet Size By DP,11000,0,,,,TRUE,,npc_only,graphics/icons/skills/fsdp.png,

Do NOT delete or overwrite any existing lines in the file.

3. Save and close the file, and start the game as normal.  If done correctly, the game should load with both
QC's skills and this mod's hidden skill active.

While these instructions are for Quality Captains, the steps should be the same for any mod replacing
skill_data.csv (check if the mod has a "replace" tag in mod_info.json, and if skill_data.csv is listed).
Remember to repeat these steps after updating any of the mods in question.

If you encounter issues with the above method, please DO NOT post in their mod threads or otherwise hassle
them: please contact me (Chozo on the FractalSoftworks forums, ditto in the unofficial Discord) first so
that I can help you.  I recognize that this is a less-than-elegant workaround and am looking for a more
long term solution: please excuse my mess (of code).

FINAL NOTES

This mod is currently in Beta: to-dos and known issues are listed in this mod's TO_DO.txt, but I am 
also looking for feedback.  Feedback/bug reports/incoherent rage can be sent to:
-Chozo on the FractalSoftworks forums
-This mod's forum thread (if it is up when you read this)
-Chozo on the unofficial Starsector Discord


SPECIAL THANKS:
-Jaghaimo for his Starsector mod template (https://github.com/jaghaimo/starsector-mod)
-Various members of the Starsector Discord modding channels, who humored my dumb questions about 
the Starsector API 
-Players like you