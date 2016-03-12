package plugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatColor;

public class SaludoRepetitivo2 extends JavaPlugin implements Listener{

	

	
	
	
	
	
	
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		repetirSaludo();
		
	}

	private void repetirSaludo() {
		   BukkitRunnable r = new BukkitRunnable() {
			
			@Override
			public void run() {
				getServer().broadcastMessage(ChatColor.GREEN + "||||||||||||" + ChatColor.AQUA + "El uso de " + ChatColor.DARK_RED + "HACKS " + ChatColor.AQUA + "es motivo de " + ChatColor.LIGHT_PURPLE + ChatColor.UNDERLINE + "KICK " + ChatColor.AQUA + "o " + ChatColor.DARK_PURPLE + "BAN." + ChatColor.GREEN + "||||||||||||");
				
			}
		};
		r.runTaskTimer(this, 0, 19000);
	}
    
}
