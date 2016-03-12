package plugin;


import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Saludo extends JavaPlugin implements Listener{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {	
		
		
		
		
		
		
		
		return false;
				
	
	}

	
	
	//hacer wue envie a todos los jugadores un mensaje de que alguien se ha unido
	
	
	
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
    
	@EventHandler
	public void onGamemodeChange(PlayerGameModeChangeEvent e){
		Player p = e.getPlayer();
		String nombreJugador = p.getName();
		
		}
	
	
	
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		String nombreJugador = p.getName();
		getServer().broadcastMessage( ChatColor.MAGIC+ "k" + ChatColor.AQUA + nombreJugador + ChatColor.GOLD + " se ha unido al servidor"+ChatColor.MAGIC+ "K" );
	
		
			
		
		
		
		
		if(!nombreJugador.equals("Albex2002")){
			p.setGameMode(GameMode.ADVENTURE);
			p.teleport(new Location(p.getWorld(),-251 , 60, 164));
		}
		
		
		if (nombreJugador.equals("Albex2002")) {
			p.sendMessage("Albex202" + ChatColor.GOLD + ChatColor.MAGIC + "z" + ChatColor.RED + "Hola amo supremo del servidor.");
		}else{
			p.sendMessage(ChatColor.GREEN + "Hola " + ChatColor.AQUA + nombreJugador + ChatColor.GREEN + " bienvenido al servidor");
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
