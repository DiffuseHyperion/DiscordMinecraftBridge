package tk.diffusehyperion.discordminecraftbridge.util;

import com.google.gson.JsonObject;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static tk.diffusehyperion.discordminecraftbridge.DiscordMinecraftBridge.plugin;

public class ApiCommunicator {
    public String sendRequest(String suffix, String method, JsonObject obj) {
        StringBuilder response = new StringBuilder();
        BukkitRunnable task = new BukkitRunnable() {
            @Override
            public void run() {
                try {
                    String apiLink = "https://Discord-Minecraft-bridge.diffusehyperion.repl.co/" + suffix;
                    URL url = new URL(apiLink);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod(method.toUpperCase());
                    conn.setRequestProperty("Accept", "application/json");
                    conn.setRequestProperty("Content-Type", "application/json");
                    conn.setDoOutput(true);
                    conn.setDoInput(true);

                    OutputStream os = conn.getOutputStream();
                    byte[] output = obj.toString().getBytes(StandardCharsets.UTF_8);
                    os.write(output, 0, output.length);
                    os.flush();
                    os.close();

                    if (conn.getResponseCode() != 200) {
                        Bukkit.getLogger().severe("abnormal response code: " + conn.getResponseCode());
                    }

                    BufferedReader br = new BufferedReader(new InputStreamReader(
                            (conn.getInputStream())));

                    String inputLine;
                    while ((inputLine = br.readLine()) != null) {
                        response.append(inputLine);
                    }
                    br.close();
                    conn.disconnect();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        };
        task.runTaskAsynchronously(plugin);
        return response.toString();
    }
}
