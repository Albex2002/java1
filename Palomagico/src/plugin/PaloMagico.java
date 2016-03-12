package plugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class PaloMagico extends JavaPlugin implements Listener{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {	






		if(command.getName().equalsIgnoreCase("PaloMagico")){
			Player p = (Player) sender;


			ItemStack palo = new ItemStack(Material.STICK);

			ItemMeta im = palo.getItemMeta();
			im.setDisplayName(ChatColor.GOLD + "Palo Magico");
			palo.setItemMeta(im);
			p.getInventory().addItem(palo);


		}	

		return false;


	}



	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action a = e.getAction();
		ItemStack i = p.getItemInHand();
		if(a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK){
			if(i !=null){
				ItemMeta im = i.getItemMeta();
				if(im !=null){
					String nombrePalo = im.getDisplayName();
					if(nombrePalo !=null){
						if(nombrePalo.equals(ChatColor.GOLD+ "Palo Magico")){

							Location l = p.getTargetBlock(null, 255).getLocation();
							p.teleport(l);

						}
					}
				}
			}
		}
	}





	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}

}
