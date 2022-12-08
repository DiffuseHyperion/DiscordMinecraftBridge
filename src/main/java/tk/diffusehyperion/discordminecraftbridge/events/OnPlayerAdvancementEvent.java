package tk.diffusehyperion.discordminecraftbridge.events;

import com.google.gson.JsonObject;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import tk.diffusehyperion.discordminecraftbridge.util.ApiCommunicator;

import java.util.Objects;

public class OnPlayerAdvancementEvent extends ApiCommunicator implements Listener {
    @EventHandler
    public void PlayerAdvancementEvent(PlayerAdvancementDoneEvent e) {
        JsonObject obj = new JsonObject();
        obj.addProperty(e.getPlayer().getDisplayName(), Objects.requireNonNull(e.getAdvancement().getDisplay()).getTitle());
        sendRequest("/advancement", "POST", obj);
    }
}
