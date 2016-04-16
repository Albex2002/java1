package plugin;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Minijuego extends JavaPlugin implements Listener {
	private ArrayList<String> equipoAzul = new ArrayList<>();
	private ArrayList<String> equipoRojo = new ArrayList<>();
	int t = 0;


	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		return false;
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onPlayerJoin(PlayerMoveEvent e) {

		WorldCreator.name("capturalabandera").createWorld();
		World cb1 = getServer().getWorld("capturalabandera");
		Player p = e.getPlayer();

		int x = p.getLocation().getBlockX();
		int y = p.getLocation().getBlockY();
		int z = p.getLocation().getBlockZ();

		if(x > -213 && x < -207 && y == 58 && z == 215){


			//-208 58 215 ---- -211 58 215
			p.sendMessage(org.bukkit.ChatColor.MAGIC + "hola" + ChatColor.GREEN+ "Te has unido a: " + ChatColor.DARK_AQUA+"CAPTURA L" + ChatColor.DARK_RED + "A BANDERA"+ ChatColor.GREEN + " disfruta de tu partida" + ChatColor.WHITE + ChatColor.MAGIC + "hola");
			p.teleport(new Location(cb1,212,67,-617));
            
            
            if(t % 2 == 0){
            	equipoAzul.add(p.getName());
            	p.sendMessage(ChatColor.GOLD + "Te has unido al equipo: " + ChatColor.BLUE + ChatColor.ITALIC +"AZUL");
            }else{
            	equipoRojo.add(p.getName());
            	p.sendMessage(ChatColor.GOLD + "Te has unido al equipo: " + ChatColor.RED + ChatColor.ITALIC +"ROJO");
            }
            t++;










		}



	}
	
	@EventHandler
	public void onPlayerDamagePlayer(EntityDamageByEntityEvent e) {
		
		Entity dr = e.getDamager();
		Entity dd = e.getEntity();
		
		
		Player pDamager = (Player) dr;
		Player pDamaged = (Player) dd; 
		
		
		if(equipoAzul.contains(pDamager.getName()) && equipoAzul.contains(pDamaged.getName())){
			e.setCancelled(true);
		}
		if(equipoRojo.contains(pDamager.getName()) && equipoRojo.contains(pDamaged.getName())){
			e.setCancelled(true);
		}
		
		
		
		
	}
	@EventHandler
	public void onPlayerDeathEvent(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		World cb1 =  getServer().getWorld("capturalabandera");
		
		
		
		
		if (p.getWorld().equals("capturalabandera")){
			e.setRespawnLocation( new Location(cb1, 212, 67, -617));
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
