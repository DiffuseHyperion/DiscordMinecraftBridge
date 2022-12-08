package tk.diffusehyperion.discordminecraftbridge;

import io.javalin.Javalin;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import tk.diffusehyperion.discordminecraftbridge.events.*;

public final class DiscordMinecraftBridge extends JavaPlugin{

    public static Plugin plugin;
    public static Javalin app;

    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new OnPlayerAdvancementEvent(), this); // /advancement, "name": "advancement name (Serious Dedication)"
        getServer().getPluginManager().registerEvents(new OnPlayerChatEvent(), this); // /message, "name": "message"
        getServer().getPluginManager().registerEvents(new OnPlayerDeathEvent(), this); // /death, "name": "death message (Player fell from a high place)"
        getServer().getPluginManager().registerEvents(new OnPlayerJoinEvent(), this); // /join, "name": "join message (Player joined the game)"
        getServer().getPluginManager().registerEvents(new OnPlayerKickedEvent(), this); // /kick, "name": "kick reason (was being annoying)"
        getServer().getPluginManager().registerEvents(new OnPlayerLeaveEvent(), this); // /leave, "name": "leave message (Player left the game)"

        app = Javalin.create(/*config*/)
                .post("/", ctx -> OnJavalinReceive.main(ctx.body()))
                .start(25566);
    }

    @Override
    public void onDisable() {
        app.stop();
    }
}
