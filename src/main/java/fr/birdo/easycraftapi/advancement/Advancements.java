package fr.birdo.easycraftapi.advancement;

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
    public static final Advancement MINECRAFT = new Advancements("Minecraft","minecraft:story/root", NORMAL);
    public static final Advancement STONE_AGE = new Advancements("Stone Age", "minecraft:story/mine_stone", NORMAL);
    public static final Advancement GETTING_AN_UPGRADE = new Advancements("Getting an Upgrade", "minecraft:story/upgrade_tools", NORMAL);
    public static final Advancement ACQUIRE_HARDWARE = new Advancements("Acquire Hardware", "minecraft:story/smelt_iron ", NORMAL);
    public static final Advancement SUIT_UP = new Advancements("Suit Up", "minecraft:story/obtain_armor", NORMAL);
    public static final Advancement HOT_STUFF = new Advancements("Hot Stuff", "minecraft:story/lava_bucket", NORMAL);
    public static final Advancement ISNT_IT_IRON_PICK = new Advancements("Isn't It Iron Pick", "minecraft:story/iron_tools", NORMAL);
    public static final Advancement NOT_TODAY_THANK_YOU = new Advancements("Not Today, Thank You", "minecraft:story/deflect_arrow", NORMAL);
    public static final Advancement ICE_BUCKET_CHALLENGE = new Advancements("Ice Bucket Challenge", "minecraft:story/form_obsidian", NORMAL);
    public static final Advancement DIAMONDS = new Advancements("Diamonds!", "minecraft:story/mine_diamond", NORMAL);
    public static final Advancement WE_NEED_TO_GO_DEEPER = new Advancements("We Need to Go Deeper", "minecraft:story/enter_the_nether", NORMAL);
    public static final Advancement COVER_Me_WITH_DIAMONDS = new Advancements("Cover Me With Diamonds", "minecraft:story/shiny_gear", NORMAL);
    public static final Advancement ENCHANTER = new Advancements("Enchanter", "minecraft:story/enchant_item", NORMAL);
    public static final Advancement ZOMBIE_DOCTOR = new Advancements("Zombie Doctor", "minecraft:story/cure_zombie_villager", GOAL);
    public static final Advancement EYE_SPY = new Advancements("Eye Spy", "minecraft:story/follow_ender_eye", NORMAL);
    public static final Advancement THE_END = new Advancements("The End?", "minecraft:story/enter_the_end", NORMAL);

    //Nether
    public static final Advancement NETHER = new Advancements("Nether", "minecraft:nether/root", NORMAL);
    public static final Advancement RETURN_TO_SENDER = new Advancements("Return to Sender", "minecraft:nether/return_to_sender ", CHALLENGE);
    public static final Advancement THOSE_WERE_THE_DAYS = new Advancements("Those Were the Days", "minecraft:nether/find_bastion", NORMAL);
    public static final Advancement HIDDEN_IN_THE_DEPTHS = new Advancements("Hidden in the Depths", "minecraft:nether/obtain_ancient_debris  ", NORMAL);
    public static final Advancement SUBSPACE_BUBBLE = new Advancements("Subspace Bubble", "minecraft:nether/fast_travel ", CHALLENGE);
    public static final Advancement A_TERRIBLE_FORTRESS = new Advancements("A Terrible Fortress", "minecraft:nether/find_fortress", NORMAL);
    public static final Advancement WHO_IS_CUTTING_ONIONS = new Advancements("Who is Cutting Onions?", "minecraft:nether/obtain_crying_obsidian", NORMAL);
    public static final Advancement OH_SHINY = new Advancements("Oh Shiny", "minecraft:nether/distract_piglin", NORMAL);
    public static final Advancement THIS_BOAT_HAS_LEGS = new Advancements("This Boat Has Legs", "minecraft:nether/ride_strider", NORMAL);
    public static final Advancement UNEASY_ALLIANCE = new Advancements("Uneasy Alliance", "minecraft:nether/uneasy_alliance", CHALLENGE);
    public static final Advancement WAR_PIGS = new Advancements("War Pigs", "minecraft:nether/loot_bastion", NORMAL);
    public static final Advancement COUNTRY_LODE_TAKE_ME_HOME = new Advancements("Country Lode, Take Me Home", "minecraft:nether/use_lodestone", NORMAL);
    public static final Advancement COVER_ME_IN_DEBRIS = new Advancements("Cover Me in Debris", "minecraft:nether/netherite_armor", CHALLENGE);
    public static final Advancement SPOOKY_SCARY_SKELETON = new Advancements("Spooky Scary Skeleton", "minecraft:nether/get_wither_skull", NORMAL);
    public static final Advancement INTO_FIRE = new Advancements("Into Fire", "minecraft:nether/obtain_blaze_rod", NORMAL);
    public static final Advancement NOT_QUITE_NINE_LIVES = new Advancements("Not Quite \"Nine\" Lives", "minecraft:nether/charge_respawn_anchor", NORMAL);
    public static final Advancement FEELS_LIKE_HOME = new Advancements("Feels like home", "minecraft:nether/ride_strider_in_overworld_lava", NORMAL);
    public static final Advancement HOT_TOURIST_DESTINATIONS = new Advancements("Hot Tourist Destinations", "minecraft:nether/explore_nether", CHALLENGE);
    public static final Advancement WITHERING_HEIGHTS = new Advancements("Withering Heights", "minecraft:nether/summon_wither", NORMAL);
    public static final Advancement LOCAL_BREWERY = new Advancements("Local Brewery", "minecraft:nether/brew_potion", NORMAL);
    public static final Advancement BRING_HOME_THE_BEACON = new Advancements("Bring Home the Beacon", "minecraft:nether/create_beacon", NORMAL);
    public static final Advancement A_FURIOUS_COCKTAIL = new Advancements("A Furious Cocktail", "minecraft:nether/all_potions", CHALLENGE);
    public static final Advancement BEACONATOR = new Advancements("Beaconator", "minecraft:nether/create_full_beacon", GOAL);
    public static final Advancement HOW_DID_WE_GET_HERE = new Advancements("How Did We Get Here?", "minecraft:nether/all_effects", CHALLENGE);

    //The End
    public static final Advancement END = new Advancements("The End?", "minecraft:end/root", NORMAL);
    public static final Advancement FREE_THE_END = new Advancements("Free the End", "minecraft:end/kill_dragon", NORMAL);
    public static final Advancement THE_NEXT_GENERATION = new Advancements("The Next Generation", "minecraft:end/dragon_egg", GOAL);
    public static final Advancement REMOTE_GATEWAY = new Advancements("Remote Getaway", "minecraft:end/enter_end_gateway ", NORMAL);
    public static final Advancement THE_END_AGAIN = new Advancements("The End... Again...", "minecraft:end/respawn_dragon", GOAL);
    public static final Advancement YOU_NEED_A_MINT = new Advancements("You Need a Mint", "minecraft:end/dragon_breath", GOAL);
    public static final Advancement THE_CITY_AT_THE_END_OF_THE_GAME = new Advancements("The City at the End of the Game", "minecraft:end/find_end_city", NORMAL);
    public static final Advancement SKYS_THE_LIMIT = new Advancements("Sky's the Limit", "minecraft:end/elytra", GOAL);
    public static final Advancement GREAT_VIEW_FROM_UP_HERE = new Advancements("Great View From Up Here", "minecraft:end/levitate", CHALLENGE);

    //Adventure
    public static final Advancement ADVENTURE = new Advancements("Adventure", "minecraft:adventure/root", NORMAL);
    public static final Advancement VOLUNTARY_EXILE = new Advancements("Voluntary Exile", "minecraft:adventure/voluntary_exile", NORMAL);
    public static final Advancement IS_IT_A_BIRD = new Advancements("Is It a Bird?", "minecraft:adventure/spyglass_at_parrot", NORMAL);
    public static final Advancement MONSTER_HUNTER = new Advancements("Monster Hunter", "minecraft:adventure/kill_a_mob", NORMAL);
    public static final Advancement WHAT_A_DEAL = new Advancements("What a Deal!", "minecraft:adventure/trade", NORMAL);
    public static final Advancement STICKY_SITUATION = new Advancements("Sticky Situation", "minecraft:adventure/honey_block_slide", NORMAL);
    public static final Advancement OL_BETSY = new Advancements("Ol' Betsy", "minecraft:adventure/ol_betsy", NORMAL);
    public static final Advancement SURGE_PROTECTOR = new Advancements("Surge Protector", "minecraft:adventure/lightning_rod_with_villager_no_fire", NORMAL);
    public static final Advancement CAVES_AND_CLIFFS = new Advancements("Caves & Cliffs", "minecraft:adventure/fall_from_world_height", NORMAL);
    public static final Advancement SWEET_DREAMS = new Advancements("Sweet Dreams", "minecraft:adventure/sleep_in_bed", NORMAL);
    public static final Advancement HERO_OF_THE_VILLAGE = new Advancements("Hero of the Village", "minecraft:adventure/hero_of_the_village", CHALLENGE);
    public static final Advancement IS_IT_A_BALLOON = new Advancements("Is It a Balloon?", "minecraft:adventure/spyglass_at_ghast", NORMAL);
    public static final Advancement A_THROWAWAY_JOKE = new Advancements("A Throwaway Joke", "minecraft:adventure/throw_trident", NORMAL);
    public static final Advancement TAKE_AIM = new Advancements("Take Aim", "minecraft:adventure/shoot_arrow", NORMAL);
    public static final Advancement MONSTERS_HUNTED = new Advancements("Monsters Hunted", "minecraft:adventure/kill_all_mobs", CHALLENGE);
    public static final Advancement POSTMORTAL = new Advancements("Postmortal", "minecraft:adventure/totem_of_undying", GOAL);
    public static final Advancement HIRED_HELP = new Advancements("Hired Help", "minecraft:adventure/summon_iron_golem",GOAL);
    public static final Advancement STAR_TRADER = new Advancements("Star Trader", "minecraft:adventure/trade_at_world_height", NORMAL);
    public static final Advancement TWO_BIRDS_ONE_ARROW = new Advancements("Two Birds, One Arrow", "minecraft:adventure/two_birds_one_arrow", CHALLENGE);
    public static final Advancement WHO_IS_PILLAGER_NOW = new Advancements("Who's the Pillager Now?", "minecraft:adventure/whos_the_pillager_now", NORMAL);
    public static final Advancement ARBALISTIC = new Advancements("Arbalistic", "minecraft:adventure/arbalistic", CHALLENGE);
    public static final Advancement ADVENTURING_TIME = new Advancements("Adventuring Time", "minecraft:adventure/adventuring_time", CHALLENGE);
    public static final Advancement SOUND_OF_MUSIC = new Advancements("Sound of Music", "minecraft:adventure/play_jukebox_in_meadows", NORMAL);
    public static final Advancement LIGHT_AS_A_RABBIT = new Advancements("Light as a Rabbit", "minecraft:adventure/walk_on_powder_snow_with_leather_boots", NORMAL);
    public static final Advancement IS_IT_A_PLANE = new Advancements("Is It a Plane?", "minecraft:adventure/spyglass_at_dragon", NORMAL);
    public static final Advancement VERY_VERY_FRIGHTENING = new Advancements("Very Very Frightening", "minecraft:adventure/very_very_frightening", NORMAL);
    public static final Advancement SNIPER_DUEL = new Advancements("Sniper Duel", "minecraft:adventure/sniper_duel", CHALLENGE);
    public static final Advancement BULLSEYE = new Advancements("Bullseye", "minecraft:adventure/bullseye", CHALLENGE);

    //Husbandry
    public static final Advancement HUSBANDRY = new Advancements("Husbandry", "minecraft:husbandry/root", NORMAL);
    public static final Advancement BEE_OUR_GUEST = new Advancements("Bee Our Guest", "minecraft:husbandry/safely_harvest_honey", NORMAL);
    public static final Advancement THE_PARROTS_AND_THE_BATS = new Advancements("The Parrots and the Bats", "minecraft:husbandry/breed_an_animal", NORMAL);
    public static final Advancement WHATEVER_FLOATS_YOUR_GOAT = new Advancements("Whatever Floats Your Goat!", "minecraft:husbandry/ride_a_boat_with_a_goat", NORMAL);
    public static final Advancement BEST_FRIENDS_FOREVER = new Advancements("Best Friends Forever", "minecraft:husbandry/tame_an_animal", NORMAL);
    public static final Advancement GLOW_AND_BEHOLD = new Advancements("Glow and Behold!", "minecraft:husbandry/make_a_sign_glow", NORMAL);
    public static final Advancement FISHY_BUSINESS = new Advancements("Fishy Business", "minecraft:husbandry/fishy_business", NORMAL);
    public static final Advancement TOTAL_BEELOCATION = new Advancements("Total Beelocation", "minecraft:husbandry/silk_touch_nest", NORMAL);
    public static final Advancement A_SEEDY_PLACE = new Advancements("A Seedy Place", "minecraft:husbandry/plant_seed", NORMAL);
    public static final Advancement WAX_ON = new Advancements("Wax On", "minecraft:husbandry/wax_on", NORMAL);
    public static final Advancement TWO_BY_TWO = new Advancements("Two by Two", "minecraft:husbandry/bred_all_animals", CHALLENGE);
    public static final Advancement A_COMPLETE_CATALOGUE = new Advancements("A Complete Catalogue", "minecraft:husbandry/complete_catalogue", CHALLENGE);
    public static final Advancement TACTICAL_FISHING = new Advancements("Tactical Fishing", "minecraft:husbandry/tactical_fishing", NORMAL);
    public static final Advancement A_BALANCED_DIET = new Advancements("A Balanced Diet", "minecraft:husbandry/balanced_diet", CHALLENGE);
    public static final Advancement SERIOUS_DEDICATION = new Advancements("Serious Dedication", "minecraft:husbandry/obtain_netherite_hoe", CHALLENGE);
    public static final Advancement WAX_OFF = new Advancements("Wax Off", "minecraft:husbandry/wax_off", NORMAL);
    public static final Advancement THE_CUTEST_PREDATOR = new Advancements("The Cutest Predator", "minecraft:husbandry/axolotl_in_a_bucket", NORMAL);
    public static final Advancement THE_HEALING_POWER_OF_FRIENDSHIP = new Advancements("The Healing Power of Friendship!", "minecraft:husbandry/kill_axolotl_target", NORMAL);


    private Advancements(String name, String id, AdvancementType type) {
        super(name,id, type);

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
            //Get file of player's advancement file in /world/advancements/ and temp file of player's advancement file in /world/advancements/temp
            File adv_file = new File(path.substring(0, path.length() - 1) + "world" + File.separator + "advancements" + File.separator + player.getUniqueId() + ".json");
            File temp_adv_file = new File(AdvancementFile.getTempFolder() + File.separator + player.getUniqueId() + ".json");

            //Parse the files
            Reader adv_reader = new FileReader(adv_file);
            JSONObject advs = (JSONObject) new JSONParser().parse(adv_reader);

            Reader temp_adv_reader = new FileReader(adv_file);
            JSONObject temp_advs = (JSONObject) new JSONParser().parse(temp_adv_reader);
            advs.putAll(temp_advs);

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
            adv_reader.close();

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return player_advancements;
    }

    public static AdvancementType getTypeById(String id) {
        Advancement advancement = registeredAdvancements.getOrDefault(id, new Advancements("Minecraft", "easycraftapi:default", NORMAL));
        return advancement.getType();
    }
}