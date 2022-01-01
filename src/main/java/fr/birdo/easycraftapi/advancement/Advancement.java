package fr.birdo.easycraftapi.advancement;

import fr.birdo.easycraftapi.entity.Player;
import org.bukkit.Bukkit;
import org.checkerframework.framework.qual.Unused;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import static fr.birdo.easycraftapi.advancement.AdvancementType.NORMAL;
import static fr.birdo.easycraftapi.advancement.AdvancementType.GOAL;
import static fr.birdo.easycraftapi.advancement.AdvancementType.CHALLENGE;

public class Advancement {

    //Minecraft
    public static final Advancement MINECRAFT = new Advancement("minecraft:story/root", NORMAL);
    public static final Advancement STONE_AGE = new Advancement("minecraft:story/mine_stone", NORMAL);
    public static final Advancement GETTING_AN_UPGRADE = new Advancement("minecraft:story/upgrade_tools", NORMAL);
    public static final Advancement ACQUIRE_HARDWARE = new Advancement("minecraft:story/smelt_iron ", NORMAL);
    public static final Advancement SUIT_UP = new Advancement("minecraft:story/obtain_armor", NORMAL);
    public static final Advancement HOT_STUFF = new Advancement("minecraft:story/lava_bucket", NORMAL);
    public static final Advancement ISNT_IT_IRON_PICK = new Advancement("minecraft:story/iron_tools", NORMAL);
    public static final Advancement NOT_TODAY_THANK_YOU = new Advancement("minecraft:story/deflect_arrow", NORMAL);
    public static final Advancement ICE_BUCKET_CHALLENGE = new Advancement("minecraft:story/form_obsidian", NORMAL);
    public static final Advancement DIAMONDS = new Advancement("minecraft:story/mine_diamond", NORMAL);
    public static final Advancement WE_NEED_TO_GO_DEEPER = new Advancement("minecraft:story/enter_the_nether", NORMAL);
    public static final Advancement COVER_Me_WITH_DIAMONDS = new Advancement("minecraft:story/shiny_gear", NORMAL);
    public static final Advancement ENCHANTER = new Advancement("minecraft:story/enchant_item", NORMAL);
    public static final Advancement ZOMBIE_DOCTOR = new Advancement("minecraft:story/cure_zombie_villager", GOAL);
    public static final Advancement EYE_SPY = new Advancement("minecraft:story/follow_ender_eye", NORMAL);
    public static final Advancement THE_END = new Advancement("minecraft:story/enter_the_end", NORMAL);

    //Nether
    public static final Advancement NETHER = new Advancement("minecraft:nether/root", NORMAL);
    public static final Advancement RETURN_TO_SENDER = new Advancement("minecraft:nether/return_to_sender ", CHALLENGE);
    public static final Advancement THOSE_WERE_THE_DAYS = new Advancement("minecraft:nether/find_bastion", NORMAL);
    public static final Advancement HIDDEN_IN_THE_DEPTHS = new Advancement("minecraft:nether/obtain_ancient_debris  ", NORMAL);
    public static final Advancement SUBSPACE_BUBBLE = new Advancement("minecraft:nether/fast_travel ", CHALLENGE);
    public static final Advancement A_TERRIBLE_FORTRESS = new Advancement("minecraft:nether/find_fortress", NORMAL);
    public static final Advancement WHO_IS_CUTTING_ONIONS = new Advancement("minecraft:nether/obtain_crying_obsidian", NORMAL);
    public static final Advancement OH_SHINY = new Advancement("minecraft:nether/distract_piglin", NORMAL);
    public static final Advancement THIS_BOAT_HAS_LEGS = new Advancement("minecraft:nether/ride_strider", NORMAL);
    public static final Advancement UNEASY_ALLIANCE = new Advancement("minecraft:nether/uneasy_alliance", CHALLENGE);
    public static final Advancement WAR_PIGS = new Advancement("minecraft:nether/loot_bastion", NORMAL);
    public static final Advancement COUNTRY_LODE_TAKE_ME_HOME = new Advancement("minecraft:nether/use_lodestone", NORMAL);
    public static final Advancement COVER_ME_IN_DEBRIS = new Advancement("minecraft:nether/netherite_armor", CHALLENGE);
    public static final Advancement SPOOKY_SCARY_SKELETON = new Advancement("minecraft:nether/get_wither_skull", NORMAL);
    public static final Advancement INTO_FIRE = new Advancement("minecraft:nether/obtain_blaze_rod", NORMAL);
    public static final Advancement NOT_QUITE_NINE_LIVES = new Advancement("minecraft:nether/charge_respawn_anchor", NORMAL);
    public static final Advancement FEELS_LIKE_HOME = new Advancement("minecraft:nether/ride_strider_in_overworld_lava", NORMAL);
    public static final Advancement HOT_TOURIST_DESTINATIONS = new Advancement("minecraft:nether/explore_nether", CHALLENGE);
    public static final Advancement WITHERING_HEIGHTS = new Advancement("minecraft:nether/summon_wither", NORMAL);
    public static final Advancement LOCAL_BREWERY = new Advancement("minecraft:nether/brew_potion", NORMAL);
    public static final Advancement BRING_HOME_THE_BEACON = new Advancement("minecraft:nether/create_beacon", NORMAL);
    public static final Advancement A_FURIOUS_COCKTAIL = new Advancement("minecraft:nether/all_potions", CHALLENGE);
    public static final Advancement BEACONATOR = new Advancement("minecraft:nether/create_full_beacon", GOAL);
    public static final Advancement HOW_DID_WE_GET_HERE = new Advancement("minecraft:nether/all_effects", CHALLENGE);

    //The End
    public static final Advancement END = new Advancement("minecraft:end/root", NORMAL);
    public static final Advancement FREE_THE_END = new Advancement("minecraft:end/kill_dragon", NORMAL);
    public static final Advancement THE_NEXT_GENERATION = new Advancement("minecraft:end/dragon_egg", GOAL);
    public static final Advancement REMOTE_GATEWAY = new Advancement("minecraft:end/enter_end_gateway ", NORMAL);
    public static final Advancement THE_END_AGAIN = new Advancement("minecraft:end/respawn_dragon", GOAL);
    public static final Advancement YOU_NEED_A_MINT = new Advancement("minecraft:end/dragon_breath", GOAL);
    public static final Advancement THE_CITY_AT_THE_END_OF_THE_GAME = new Advancement("minecraft:end/find_end_city", NORMAL);
    public static final Advancement SKYS_THE_LIMIT = new Advancement("minecraft:end/elytra", GOAL);
    public static final Advancement GREAT_VIEW_FROM_UP_HERE = new Advancement("minecraft:end/levitate", CHALLENGE);

    public static HashMap<String,AdvancementType> advancements = new HashMap<>();

    private String id;
    private AdvancementType type;

    public Advancement(String id, AdvancementType type) {
        this.id = id;
        this.type = type;

        advancements.put(id,type);
    }

    public AdvancementType getType() {
        return this.type;
    }

    public String getId() {
        return this.id;
    }

    public static List<Advancement> getAdvancements(Player player) {
        List<Advancement> player_advancements = new ArrayList<>();
        try {
            String path = Bukkit.getWorldContainer().getAbsolutePath(); //Get the path of the server main folder
            //Get file of player's advancement file in /world/advancements/
            File adv_file = new File(path.substring(0, path.length() - 1) + "world" + File.separator + "advancements" + File.separator + player.getUniqueId() + ".json");

            //Parse the file
            Reader adv_reader = new FileReader(adv_file);
            JSONObject advs = (JSONObject) new JSONParser().parse(adv_reader);

            //Loop on each advancement
            for (Object key : advs.keySet()) {

                if (advs.get(key.toString()) instanceof JSONObject) {

                    JSONObject advancement = (JSONObject) advs.get(key.toString());

                    //Regex for crafting advancements
                    Pattern craft_reg = Pattern.compile("minecraft:recipes");

                    //Ignore crafting advancements and none finished advancements
                    if (craft_reg.matcher(key.toString()).find() || !(boolean) advancement.get("done")) {
                        continue;
                    }

                    player_advancements.add(new Advancement(key.toString(), getTypeById(key.toString())));
                }
            }

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return player_advancements;
    }

    public static AdvancementType getTypeById(String id){
        return advancements.getOrDefault(id, NORMAL);
    }
}

enum AdvancementType {

    NORMAL(0),
    GOAL(1),
    CHALLENGE(2);

    private int id;

    AdvancementType(int id) {
        this.id = id;
    }

    int getId() {
        return this.id;
    }
}