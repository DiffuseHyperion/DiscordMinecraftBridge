package tk.diffusehyperion.discordminecraftbridge.events;

import com.google.gson.JsonObject;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import tk.diffusehyperion.discordminecraftbridge.util.ApiCommunicator;

public class OnPlayerDeathEvent extends ApiCommunicator implements Listener{
    @EventHandler
    public void PlayerDeathEvent(PlayerDeathEvent e) {
        JsonObject obj = new JsonObject();
        obj.addProperty(e.getEntity().getDisplayName(), e.getDeathMessage());
        sendRequest("/death", "POST", obj);
    }
}
