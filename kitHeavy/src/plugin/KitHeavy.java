package plugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.ChatColor;

public class KitHeavy extends JavaPlugin implements Listener{

	@SuppressWarnings("unused")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		ItemStack i = new ItemStack(Material.IRON_AXE);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(ChatColor.GOLD + "Gods Axe");
		i.setItemMeta(im);
		
		
		if(command.getName().equalsIgnoreCase("kitHeavy")){
			Player p = (Player) sender;
			
			
			p.removePotionEffect(PotionEffectType.ABSORPTION);
			p.removePotionEffect(PotionEffectType.SPEED);
			p.removePotionEffect(PotionEffectType.JUMP);
			p.removePotionEffect(PotionEffectType.NIGHT_VISION);
			p.removePotionEffect(PotionEffectType.SLOW);
			p.removePotionEffect(PotionEffectType.INVISIBILITY);
			
			p.getInventory().clear();
			
			ItemStack espada = new ItemStack(i);
			p.getInventory().addItem(espada);
			
			ItemStack casco = new ItemStack(Material.DIAMOND_HELMET);
			p.getInventory().setChestplate(casco);
			
			ItemStack pechera = new ItemStack(Material.DIAMOND_CHESTPLATE);
			p.getInventory().setLeggings(pechera);
			
			ItemStack pantalones = new ItemStack(Material.DIAMOND_LEGGINGS);
			p.getInventory().setBoots(pantalones);
			
			ItemStack botas = new ItemStack(Material.DIAMOND_BOOTS);
			p.getInventory().setHelmet(botas);
			
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 2000, 1));
			p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 2000, 1));
			
			
			ItemStack goldenapple = new ItemStack(Material.GOLDEN_APPLE,2);
			p.getInventory().addItem(goldenapple);
			
			ItemStack zanahoria = new ItemStack(Material.CARROT_ITEM,32);
			p.getInventory().addItem(zanahoria);
			
			
			
			
		}
		
		
		
		
		return false;
				
	
	}

	
	
	
	
	
	
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
    
}
