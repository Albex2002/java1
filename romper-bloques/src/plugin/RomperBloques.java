package plugin;


import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class RomperBloques extends JavaPlugin implements Listener{

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
	public void blockBreakEvent(BlockBreakEvent e){
		Player p = e.getPlayer();
		World w = p.getWorld();



		if(w.getName().contains("capturalabandera")){

			//if(!e.getBlock().getType().equals(Material.WOOL)){
			//e.setCancelled(false);
		}
	}
	//}
	@EventHandler
	public void blockPLace(BlockPlaceEvent e){
		Player p = e.getPlayer();
		World w = p.getWorld();



		if(w.getName().contains("capturalabandera")){

			//if(!e.getBlock().getType().equals(Material.WOOL)){
			//e.setCancelled(false);
		}
	}
	//}


	@EventHandler
	public void playerMoveEvent(PlayerMoveEvent e){


		WorldCreator.name("capturalabandera").createWorld();
		World cb1 = getServer().getWorld("capturalabandera");
		Player p = e.getPlayer();
		//captura la bandera
		int x = p.getLocation().getBlockX();
		int y = p.getLocation().getBlockY();
		int z = p.getLocation().getBlockZ();
		//p.sendMessage("x: " + x+" y: " + y+" z: " + z);
		if(x == -208){

			if(y == 58){

				if(z == 215){
					//-218 58 215 ---- -211 58 215
					p.sendMessage(org.bukkit.ChatColor.MAGIC + "hola" + ChatColor.GREEN+ "Te has unido a: " + ChatColor.DARK_AQUA+"CAPTURA L" + ChatColor.DARK_RED + "A BANDERA"+ ChatColor.GREEN + " disfruta de tu partida" + ChatColor.WHITE + ChatColor.MAGIC + "hola");
					p.teleport(new Location(cb1,212,90,-617));
				}
			}
		}


	}





}


























