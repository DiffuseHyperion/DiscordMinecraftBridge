package tk.diffusehyperion.discordminecraftbridge;

import io.javalin.Javalin;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import tk.diffusehyperion.discordminecraftbridge.events.OnJavalinReceive;
import tk.diffusehyperion.discordminecraftbridge.events.OnPlayerChatEvent;

public final class DiscordMinecraftBridge extends JavaPlugin{

    public static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new OnPlayerChatEvent(), this);
        Javalin app = Javalin.create(/*config*/)
                .post("/", ctx -> OnJavalinReceive.main(ctx.body()))
                .start(25566);
    }

    @Override
    public void onDisable() {
    }
}
