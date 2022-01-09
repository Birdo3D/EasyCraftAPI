package fr.birdo.easycraftapi.advancement;

import fr.birdo.easycraftapi.EasyCraftAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.logging.Level;
import java.util.regex.Pattern;

public class AdvancementFile {
    public static void clear() {
        File temp_adv_folder = new File(getTempFolder());

        if (temp_adv_folder.exists())
            temp_adv_folder.delete();
    }

    public static void create(Player player) {
        //Get temp file of player's advancement file in /world/advancements/temp
        File temp_adv_file = new File(getTempFolder() + File.separator + player.getUniqueId() + ".json");
        //Create temp folder
        File temp_folder = new File(getTempFolder());
        if (!temp_folder.exists())
            temp_folder.mkdirs();

        try {
            temp_adv_file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String getTempFolder() {
        String path = Bukkit.getWorldContainer().getAbsolutePath(); //Get the path of the server main folder
        //Get temp folder of player's advancement in /world/advancements/temp
        return path.substring(0, path.length() - 1) + "world" + File.separator + "advancements" + File.separator + "temp";
    }

    public static void addAdvancement(Player player, Advancement advancement) {
        JSONObject advancements = new JSONObject();

        try {
            //Get temp file of player's advancement file in /world/advancements/temp
            File adv_file = new File(getTempFolder() + File.separator + player.getUniqueId() + ".json");

            if(adv_file.length() != 0) {
                //Parse the file
                Reader adv_reader = new FileReader(adv_file);
                JSONObject advs = (JSONObject) new JSONParser().parse(adv_reader);

                //Loop on each advancement
                for (Object key : advs.keySet())
                    if (advs.get(key.toString()) instanceof JSONObject)
                        advancements.put(key.toString(), (JSONObject) advs.get(key.toString()));
                adv_reader.close();
            }
            JSONObject done = new JSONObject();
            done.put("done",true);
            advancements.put(advancement.getId(), done);

            FileWriter adv_writer = new FileWriter(adv_file);

            adv_writer.write(advancements.toJSONString().replaceAll("\\\\",""));
            adv_writer.close();
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
