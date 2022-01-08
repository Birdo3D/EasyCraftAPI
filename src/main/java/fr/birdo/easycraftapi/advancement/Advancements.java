package fr.birdo.easycraftapi.advancement;

import com.sun.org.apache.bcel.internal.generic.GOTO;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static fr.birdo.easycraftapi.advancement.AdvancementType.NORMAL;
import static fr.birdo.easycraftapi.advancement.AdvancementType.GOAL;
import static fr.birdo.easycraftapi.advancement.AdvancementType.CHALLENGE;

import static fr.birdo.easycraftapi.registry.GameRegistry.registeredAdvancements;

public class Advancements extends Advancement {
    //Minecraft
    public static final Advancement MINECRAFT = new Advancements("minecraft:story/root", NORMAL);
    public static final Advancement STONE_AGE = new Advancements("minecraft:story/mine_stone", NORMAL);
    public static final Advancement GETTING_AN_UPGRADE = new Advancements("minecraft:story/upgrade_tools", NORMAL);
    public static final Advancement ACQUIRE_HARDWARE = new Advancements("minecraft:story/smelt_iron ", NORMAL);
    public static final Advancement SUIT_UP = new Advancements("minecraft:story/obtain_armor", NORMAL);
    public static final Advancement HOT_STUFF = new Advancements("minecraft:story/lava_bucket", NORMAL);
    public static final Advancement ISNT_IT_IRON_PICK = new Advancements("minecraft:story/iron_tools", NORMAL);
    public static final Advancement NOT_TODAY_THANK_YOU = new Advancements("minecraft:story/deflect_arrow", NORMAL);
    public static final Advancement ICE_BUCKET_CHALLENGE = new Advancements("minecraft:story/form_obsidian", NORMAL);
    public static final Advancement DIAMONDS = new Advancements("minecraft:story/mine_diamond", NORMAL);
    public static final Advancement WE_NEED_TO_GO_DEEPER = new Advancements("minecraft:story/enter_the_nether", NORMAL);
    public static final Advancement COVER_Me_WITH_DIAMONDS = new Advancements("minecraft:story/shiny_gear", NORMAL);
    public static final Advancement ENCHANTER = new Advancements("minecraft:story/enchant_item", NORMAL);
    public static final Advancement ZOMBIE_DOCTOR = new Advancements("minecraft:story/cure_zombie_villager", GOAL);
    public static final Advancement EYE_SPY = new Advancements("minecraft:story/follow_ender_eye", NORMAL);
    public static final Advancement THE_END = new Advancements("minecraft:story/enter_the_end", NORMAL);

    //Nether
    public static final Advancement NETHER = new Advancements("minecraft:nether/root", NORMAL);
    public static final Advancement RETURN_TO_SENDER = new Advancements("minecraft:nether/return_to_sender ", CHALLENGE);
    public static final Advancement THOSE_WERE_THE_DAYS = new Advancements("minecraft:nether/find_bastion", NORMAL);
    public static final Advancement HIDDEN_IN_THE_DEPTHS = new Advancements("minecraft:nether/obtain_ancient_debris  ", NORMAL);
    public static final Advancement SUBSPACE_BUBBLE = new Advancements("minecraft:nether/fast_travel ", CHALLENGE);
    public static final Advancement A_TERRIBLE_FORTRESS = new Advancements("minecraft:nether/find_fortress", NORMAL);
    public static final Advancement WHO_IS_CUTTING_ONIONS = new Advancements("minecraft:nether/obtain_crying_obsidian", NORMAL);
    public static final Advancement OH_SHINY = new Advancements("minecraft:nether/distract_piglin", NORMAL);
    public static final Advancement THIS_BOAT_HAS_LEGS = new Advancements("minecraft:nether/ride_strider", NORMAL);
    public static final Advancement UNEASY_ALLIANCE = new Advancements("minecraft:nether/uneasy_alliance", CHALLENGE);
    public static final Advancement WAR_PIGS = new Advancements("minecraft:nether/loot_bastion", NORMAL);
    public static final Advancement COUNTRY_LODE_TAKE_ME_HOME = new Advancements("minecraft:nether/use_lodestone", NORMAL);
    public static final Advancement COVER_ME_IN_DEBRIS = new Advancements("minecraft:nether/netherite_armor", CHALLENGE);
    public static final Advancement SPOOKY_SCARY_SKELETON = new Advancements("minecraft:nether/get_wither_skull", NORMAL);
    public static final Advancement INTO_FIRE = new Advancements("minecraft:nether/obtain_blaze_rod", NORMAL);
    public static final Advancement NOT_QUITE_NINE_LIVES = new Advancements("minecraft:nether/charge_respawn_anchor", NORMAL);
    public static final Advancement FEELS_LIKE_HOME = new Advancements("minecraft:nether/ride_strider_in_overworld_lava", NORMAL);
    public static final Advancement HOT_TOURIST_DESTINATIONS = new Advancements("minecraft:nether/explore_nether", CHALLENGE);
    public static final Advancement WITHERING_HEIGHTS = new Advancements("minecraft:nether/summon_wither", NORMAL);
    public static final Advancement LOCAL_BREWERY = new Advancements("minecraft:nether/brew_potion", NORMAL);
    public static final Advancement BRING_HOME_THE_BEACON = new Advancements("minecraft:nether/create_beacon", NORMAL);
    public static final Advancement A_FURIOUS_COCKTAIL = new Advancements("minecraft:nether/all_potions", CHALLENGE);
    public static final Advancement BEACONATOR = new Advancements("minecraft:nether/create_full_beacon", GOAL);
    public static final Advancement HOW_DID_WE_GET_HERE = new Advancements("minecraft:nether/all_effects", CHALLENGE);

    //The End
    public static final Advancement END = new Advancements("minecraft:end/root", NORMAL);
    public static final Advancement FREE_THE_END = new Advancements("minecraft:end/kill_dragon", NORMAL);
    public static final Advancement THE_NEXT_GENERATION = new Advancements("minecraft:end/dragon_egg", GOAL);
    public static final Advancement REMOTE_GATEWAY = new Advancements("minecraft:end/enter_end_gateway ", NORMAL);
    public static final Advancement THE_END_AGAIN = new Advancements("minecraft:end/respawn_dragon", GOAL);
    public static final Advancement YOU_NEED_A_MINT = new Advancements("minecraft:end/dragon_breath", GOAL);
    public static final Advancement THE_CITY_AT_THE_END_OF_THE_GAME = new Advancements("minecraft:end/find_end_city", NORMAL);
    public static final Advancement SKYS_THE_LIMIT = new Advancements("minecraft:end/elytra", GOAL);
    public static final Advancement GREAT_VIEW_FROM_UP_HERE = new Advancements("minecraft:end/levitate", CHALLENGE);

    //Adventure
    public static final Advancement ADVENTURE = new Advancements("minecraft:adventure/root", NORMAL);
    public static final Advancement VOLUNTARY_EXILE = new Advancements("minecraft:adventure/voluntary_exile", NORMAL);
    public static final Advancement IS_IT_A_BIRD = new Advancements("minecraft:adventure/spyglass_at_parrot", NORMAL);
    public static final Advancement MONSTER_HUNTER = new Advancements("minecraft:adventure/kill_a_mob", NORMAL);
    public static final Advancement WHAT_A_DEAL = new Advancements("minecraft:adventure/trade", NORMAL);
    public static final Advancement STICHY_SITUATION = new Advancements("minecraft:adventure/honey_block_slide", NORMAL);
    public static final Advancement OL_BETSY = new Advancements("minecraft:adventure/ol_betsy", NORMAL);
    public static final Advancement SURGE_PROTECTOR = new Advancements("minecraft:adventure/lightning_rod_with_villager_no_fire", NORMAL);
    public static final Advancement CAVES_AND_CLIFFS = new Advancements("minecraft:adventure/fall_from_world_height", NORMAL);
    public static final Advancement SWEET_DREAMS = new Advancements("minecraft:adventure/sleep_in_bed", NORMAL);
    public static final Advancement HERO_OF_THE_VILLAGE = new Advancements("minecraft:adventure/hero_of_the_village", CHALLENGE);
    public static final Advancement IS_IT_A_BALLOON = new Advancements("minecraft:adventure/spyglass_at_ghast", NORMAL);
    public static final Advancement A_THROWAWAY_JOKE = new Advancements("minecraft:adventure/throw_trident", NORMAL);
    public static final Advancement TAKE_AIM = new Advancements("minecraft:adventure/shoot_arrow", NORMAL);
    public static final Advancement MONSTERS_HUNTED = new Advancements("minecraft:adventure/kill_all_mobs", CHALLENGE);
    public static final Advancement POSTMORTAL = new Advancements("minecraft:adventure/totem_of_undying", GOAL);
    public static final Advancement HIRED_HELP = new Advancements("minecraft:adventure/summon_iron_golem",GOAL);
    public static final Advancement STAR_TRADER = new Advancements("minecraft:adventure/trade_at_world_height", NORMAL);
    public static final Advancement TWO_BIRDS_ONE_ARROW = new Advancements("minecraft:adventure/two_birds_one_arrow", CHALLENGE);
    public static final Advancement WHO_IS_PILLAGER_NOW = new Advancements("minecraft:adventure/whos_the_pillager_now", NORMAL);
    public static final Advancement ARBALISTIC = new Advancements("minecraft:adventure/arbalistic", CHALLENGE);
    public static final Advancement ADVENTURING_TIME = new Advancements("minecraft:adventure/adventuring_time", CHALLENGE);
    public static final Advancement SOUND_OF_MUSIC = new Advancements("minecraft:adventure/play_jukebox_in_meadows", NORMAL);
    public static final Advancement LIGHT_AS_A_RABBIT = new Advancements("minecraft:adventure/walk_on_powder_snow_with_leather_boots", NORMAL);
    public static final Advancement IS_IT_A_PLANE = new Advancements("minecraft:adventure/spyglass_at_dragon", NORMAL);
    public static final Advancement VERY_VERY_FRIGHTENING = new Advancements("minecraft:adventure/very_very_frightening", NORMAL);
    public static final Advancement SNIPER_DUEL = new Advancements("minecraft:adventure/sniper_duel", CHALLENGE);
    public static final Advancement BULLSEYE = new Advancements("minecraft:adventure/bullseye", CHALLENGE);

    //Husbandry
    public static final Advancement HUSBANDRY = new Advancements("minecraft:husbandry/root", NORMAL);
    public static final Advancement BEE_OUR_GUEST = new Advancements("minecraft:husbandry/safely_harvest_honey", NORMAL);
    public static final Advancement THE_PARROTS_AND_THE_BATS = new Advancements("minecraft:husbandry/breed_an_animal", NORMAL);
    public static final Advancement WHATEVER_FLOATS_YOUR_GOAT = new Advancements("minecraft:husbandry/ride_a_boat_with_a_goat", NORMAL);
    public static final Advancement BEST_FRIENDS_FOREVER = new Advancements("minecraft:husbandry/tame_an_animal", NORMAL);
    public static final Advancement GLOW_AND_BEHOLD = new Advancements("minecraft:husbandry/make_a_sign_glow", NORMAL);
    public static final Advancement FISHY_BUSINESS = new Advancements("minecraft:husbandry/fishy_business", NORMAL);
    public static final Advancement TOTAL_BEELOCATION = new Advancements("minecraft:husbandry/silk_touch_nest", NORMAL);
    public static final Advancement A_SEEDY_PLACE = new Advancements("minecraft:husbandry/plant_seed", NORMAL);
    public static final Advancement WAX_ON = new Advancements("minecraft:husbandry/wax_on", NORMAL);
    public static final Advancement TWO_BY_TWO = new Advancements("minecraft:husbandry/bred_all_animals", CHALLENGE);
    public static final Advancement A_COMPLETE_CATALOGUE = new Advancements("minecraft:husbandry/complete_catalogue", CHALLENGE);
    public static final Advancement TACTICAL_FISHING = new Advancements("minecraft:husbandry/tactical_fishing", NORMAL);
    public static final Advancement A_BALANCE_DIET = new Advancements("minecraft:husbandry/balanced_diet", CHALLENGE);
    public static final Advancement SERIOUS_DEDICATION = new Advancements("minecraft:husbandry/obtain_netherite_hoe", CHALLENGE);
    public static final Advancement WAX_OFF = new Advancements("minecraft:husbandry/wax_off", NORMAL);
    public static final Advancement THE_CUTEST_PREDATOR= new Advancements("minecraft:husbandry/axolotl_in_a_bucket", NORMAL);
    public static final Advancement THE_HEALING_POWER_OF_FRIENDSHIP= new Advancements("minecraft:husbandry/kill_axolotl_target", NORMAL);


    private Advancements(String id, AdvancementType type) {
        super(id, type);

        //Register Minecraft's Advancement in ADVANCEMENT_LIST
        registeredAdvancements.put(id, new Advancement(id, type));
    }

    public Advancement register(String id, AdvancementType type) {
        //Register Advancement in ADVANCEMENT_LIST
        registeredAdvancements.put(id, new Advancement(id, type));

        return new Advancement(id, type);
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

    public static AdvancementType getTypeById(String id) {
        Advancement advancement = registeredAdvancements.getOrDefault(id, new Advancements("easycraftapi:default", NORMAL));
        return advancement.getType();
    }
}