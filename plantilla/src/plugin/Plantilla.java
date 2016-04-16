package plugin;


import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

@SuppressWarnings("deprecation")
public class Plantilla extends JavaPlugin implements Listener {






	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	return false;
		
		
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		
		
		ItemStack zanahoria = new ItemStack(Material.GOLDEN_CARROT);
		ItemMeta im =zanahoria.getItemMeta();
		im.setDisplayName(ChatColor.GOLD  + "Zeus`s carrot" );
		im.addEnchant(Enchantment.SILK_TOUCH, 10, true);
		zanahoria.setItemMeta(im);
		
		ShapedRecipe zeusCarrot = new ShapedRecipe(zanahoria);
		zeusCarrot.shape("ICD", "EZE", "ICD");
		zeusCarrot.setIngredient('I', Material.DIAMOND);
		zeusCarrot.setIngredient('C', Material.PACKED_ICE);
		zeusCarrot.setIngredient('D', Material.DIAMOND);
		zeusCarrot.setIngredient('E', Material.ANVIL);
		zeusCarrot.setIngredient('Z', Material.GOLDEN_CARROT);
		getServer().addRecipe(zeusCarrot);
		
	}
	
	
	
	


	@EventHandler
	public void onPlayerClickEvent(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_AIR ){
			ItemStack iEnMano = p.getItemInHand();
			if(iEnMano != null){
				ItemMeta im = iEnMano.getItemMeta();
				if(im != null){
					String nombre = im.getDisplayName();
					if(nombre != null){
						if(nombre.contains(ChatColor.GOLD  + "Zeus`s carrot")){
							Location locRayo = p.getTargetBlock(null, 255).getLocation();
							
							int numVeces = 0;
							
							if(im.getLore()== null ||im.getLore().size()==0){
								ArrayList<String> ss = new ArrayList<>();
								ss.add(numVeces+"");
								im.setLore(ss);
							}else{
								numVeces = Integer.parseInt(im.getLore().get(0));
							}
							//p.sendMessage(numVeces+"");
							if(numVeces < 10){
								numVeces++;
								ArrayList<String> ss = new ArrayList<>();
								ss.add(numVeces+"");
								im.setLore(ss);
								
								
								im.getLore().set(0, numVeces+"");
								im.setDisplayName(ChatColor.GOLD  + "Zeus`s carrot " + (10-numVeces) +" charges.");
								im.addEnchant(Enchantment.SILK_TOUCH, 10, true);
								iEnMano.setItemMeta(im);
								p.getWorld().strikeLightning(locRayo);
							}
						}
					}
				}
			}
		}
	
		
		
	}
	
	

}
