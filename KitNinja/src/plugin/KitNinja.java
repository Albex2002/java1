package plugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class KitNinja extends JavaPlugin implements Listener{

	@SuppressWarnings("unused")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {	
		
		if(command.getName().equalsIgnoreCase("kitNinja")){
			Player p = (Player) sender;
			
			p.removePotionEffect(PotionEffectType.ABSORPTION);
			p.removePotionEffect(PotionEffectType.SPEED);
			p.removePotionEffect(PotionEffectType.JUMP);
			p.removePotionEffect(PotionEffectType.NIGHT_VISION);
			p.removePotionEffect(PotionEffectType.SLOW);
			
			p.getInventory().clear();
			
			ItemStack espada = new ItemStack(Material.IRON_SWORD);
			p.getInventory().addItem(espada);
			
			ItemStack casco = new ItemStack(Material.LEATHER_HELMET);
			p.getInventory().addItem(casco);
			
			ItemStack pechera = new ItemStack(Material.LEATHER_CHESTPLATE);
			p.getInventory().addItem(pechera);
			
			ItemStack pantalones = new ItemStack(Material.LEATHER_LEGGINGS);
			p.getInventory().addItem(pantalones);
			
			ItemStack botas = new ItemStack(Material.LEATHER_BOOTS);
			p.getInventory().addItem(botas);
			
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2000, 2));
			p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 2000, 2));
			p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 2000, 2));
			
			
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
