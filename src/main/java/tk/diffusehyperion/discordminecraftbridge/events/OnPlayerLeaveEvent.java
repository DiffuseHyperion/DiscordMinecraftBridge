package tk.diffusehyperion.discordminecraftbridge.events;

import com.google.gson.JsonObject;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import tk.diffusehyperion.discordminecraftbridge.util.ApiCommunicator;

public class OnPlayerLeaveEvent extends ApiCommunicator implements Listener {
    @EventHandler
    public void PlayerLeaveEvent(PlayerQuitEvent e) {
        JsonObject obj = new JsonObject();
        obj.addProperty(e.getPlayer().getDisplayName(), e.getQuitMessage());
        sendRequest("/leave", "POST", obj);
    }
}
