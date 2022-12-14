package tk.diffusehyperion.discordminecraftbridge.events;

import com.google.gson.JsonObject;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import tk.diffusehyperion.discordminecraftbridge.util.ApiCommunicator;

public class OnPlayerChatEvent extends ApiCommunicator implements Listener {
    @EventHandler
    public void PlayerChatEvent(AsyncPlayerChatEvent e) {
        JsonObject obj = new JsonObject();
        obj.addProperty(e.getPlayer().getDisplayName(), e.getMessage());
        sendRequest("/message", "POST", obj);
    }
}
