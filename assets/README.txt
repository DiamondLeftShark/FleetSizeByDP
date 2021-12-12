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

--!--NOTE ON POTENTIAL COMPATIBILITY ISSUES--!--

This mod is implemented via a hidden skill added to the player character on game load: this skill tracks
the player's total fleet DP and calculates the supply/burn speed penalty if necessary.  Some mods replace
the skill_data.csv file, which will prevent this mod from working and crash your game on startup if both
are enabled.

If you wish to use this mod with the mod(s) in question, you will need to perform the following steps:

1. Go to [MOD]\data\characters\skills and open the skill_data.csv file in a text editor (Notepad).
I recommend making a copy of this file before continuing so that you have a backup if something goes wrong.

2. Copy and paste the following line on a new line at the bottom of the file:

fleet_size_by_dp,Fleet Size By DP,11000,0,,,,,,TRUE,,npc_only,graphics/icons/skills/fsdp.png,

Do NOT delete or overwrite any existing lines in the file.

3. Save and close the file, and start the game as normal.  If done correctly, the game should load with both
mods active.

If you encounter issues with the above method, please DO NOT post in their mod threads or otherwise hassle
them: please contact me (Chozo on the FractalSoftworks forums, ditto in the unofficial Discord) first so
that I can help you.

FINAL NOTES
Feedback/bug reports/incoherent rage can be sent to:
-Chozo on the FractalSoftworks forums
-This mod's forum thread (https://fractalsoftworks.com/forum/index.php?topic=22191.0)
-Chozo on the unofficial Starsector Discord


SPECIAL THANKS:
-Jaghaimo for his Starsector mod template (https://github.com/jaghaimo/starsector-mod)
-Various members of the Starsector Discord modding channels, who humored my dumb questions about 
the Starsector API 
-Players like you