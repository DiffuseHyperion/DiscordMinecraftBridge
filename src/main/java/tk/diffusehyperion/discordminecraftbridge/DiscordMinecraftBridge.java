package tk.diffusehyperion.discordminecraftbridge;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import tk.diffusehyperion.discordminecraftbridge.events.OnPlayerChatEvent;

public final class DiscordMinecraftBridge extends JavaPlugin {

    public static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new OnPlayerChatEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
