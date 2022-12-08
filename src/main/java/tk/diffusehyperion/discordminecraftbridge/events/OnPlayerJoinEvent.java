package tk.diffusehyperion.discordminecraftbridge.events;

import com.google.gson.JsonObject;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import tk.diffusehyperion.discordminecraftbridge.util.ApiCommunicator;

public class OnPlayerJoinEvent extends ApiCommunicator implements Listener {
    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent e) {
        JsonObject obj = new JsonObject();
        obj.addProperty(e.getPlayer().getDisplayName(), e.getJoinMessage());
        sendRequest("/join", "POST", obj);
    }
}
