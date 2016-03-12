package plugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Brujula extends JavaPlugin implements Listener {

	private ItemStack brujula;
	private Inventory inventario;
	private ItemStack b1;
	private ItemStack b2;

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		brujula = new ItemStack(Material.COMPASS);
		inventario = Bukkit.createInventory(null, 9, ChatColor.GOLD + "Kit selector");
		b1 = new ItemStack(Material.DIAMOND_CHESTPLATE);
		b2 = new ItemStack(Material.CAULDRON);
		inventario.addItem(b1);
		inventario.addItem(b2);
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		p.getInventory().addItem(brujula);




	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();


		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
			ItemStack i = p.getItemInHand();
			if(i != null){
				if(i.getType() == Material.COMPASS){
					p.openInventory(inventario);


				}
			}

		}

	}
	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(p.getOpenInventory().getTopInventory().equals(inventario)){
			e.setCancelled(true);
			ItemStack stack= e.getCurrentItem();
			if(stack != null){
				if(stack.equals(b1)){
					//p.setHealth(0);
				}
			}
		}
	}


}

