package tk.diffusehyperion.discordminecraftbridge.events;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.bukkit.Bukkit;

public class OnJavalinReceive {
    public static void main(String received) {
        JsonObject obj = (JsonObject) JsonParser.parseString(received);
        Bukkit.getLogger().info("received: " + obj);
        for (String name : obj.keySet()) {
            Bukkit.broadcastMessage("DISCORD: " + name + ": " + obj.get(name));
        }
    }
}
