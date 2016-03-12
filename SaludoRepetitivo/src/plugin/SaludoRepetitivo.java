package plugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatColor;

public class SaludoRepetitivo extends JavaPlugin implements Listener{

	

	
	
	
	
	
	
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		repetirSaludo();
		
	}

	private void repetirSaludo() {
		   BukkitRunnable r = new BukkitRunnable() {
			
			@Override
			public void run() {
				getServer().broadcastMessage(ChatColor.GOLD + "[" + ChatColor.GREEN + "Consejo util" + ChatColor.GOLD + "] " + ChatColor.YELLOW + "  Solo podrás ser " + ChatColor.AQUA + "ADMIN " + ChatColor.YELLOW + "si eres amigo de los creadores.");
				
			}
		};
		r.runTaskTimer(this, 0, 20000);
	}
    
}
