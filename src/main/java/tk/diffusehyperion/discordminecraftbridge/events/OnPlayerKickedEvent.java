package tk.diffusehyperion.discordminecraftbridge.events;

import com.google.gson.JsonObject;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import tk.diffusehyperion.discordminecraftbridge.util.ApiCommunicator;

public class OnPlayerKickedEvent extends ApiCommunicator implements Listener {
    @EventHandler
    public void PlayerKickedEvent(PlayerKickEvent e) {
        JsonObject obj = new JsonObject();
        obj.addProperty(e.getPlayer().getDisplayName(), e.getReason());
        sendRequest("/kick", "POST", obj);
    }
}
