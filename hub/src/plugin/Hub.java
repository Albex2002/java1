package plugin;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Hub extends JavaPlugin implements Listener{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {	
		
		if(command.getName().equalsIgnoreCase("Hub")){
			Player p = (Player) sender;
			World w = getServer().getWorld("world");
	        int i = 0;
			ItemStack nose = new ItemStack(Material.YELLOW_FLOWER);
			p.getName();
			p.teleport(new Location(w,-251,58,164));
	        p.updateInventory();
	        p.getInventory().clear();
	        p.getInventory().addItem(nose);
			
	        while (i<20){
	        	p.setFoodLevel(30);
	        }
		
		}
		
		
		
		
		return false;
				
	
	}

	
	
	
	
	@EventHandler
	public void playerMoveEvent(PlayerMoveEvent e){
		/*World w = getServer().getWorld("world");
		Player p = e.getPlayer();
		p.teleport(new Location(w,212,90,-617));*/
	}
	
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
    
}
