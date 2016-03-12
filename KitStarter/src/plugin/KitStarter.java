package plugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

public class KitStarter extends JavaPlugin implements Listener{

	@SuppressWarnings("unused")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {	
		
		if(command.getName().equalsIgnoreCase("kitStarter")){
			Player p = (Player) sender;
			
			p.removePotionEffect(PotionEffectType.ABSORPTION);
			p.removePotionEffect(PotionEffectType.SPEED);
			p.removePotionEffect(PotionEffectType.JUMP);
			p.removePotionEffect(PotionEffectType.NIGHT_VISION);
			p.removePotionEffect(PotionEffectType.SLOW);
			
			p.getInventory().clear();
			
			ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
			p.getInventory().addItem(espada);
			
			ItemStack casco = new ItemStack(Material.IRON_HELMET);
			p.getInventory().addItem(casco);
			
			ItemStack pechera = new ItemStack(Material.IRON_CHESTPLATE);
			p.getInventory().addItem(pechera);
			
			ItemStack pantalones = new ItemStack(Material.IRON_LEGGINGS);
			p.getInventory().addItem(pantalones);
			
			ItemStack botas = new ItemStack(Material.IRON_BOOTS);
			p.getInventory().addItem(botas);
			
			ItemStack flechas = new ItemStack(Material.ARROW,64);
			p.getInventory().addItem(flechas);
			
			ItemStack arco = new ItemStack(Material.BOW);
			p.getInventory().addItem(arco);
			
			ItemStack goldenapple = new ItemStack(Material.GOLDEN_APPLE,2);
			p.getInventory().addItem(goldenapple);
			
			ItemStack comida = new ItemStack(Material.CARROT,64);
			p.getInventory().addItem(comida);
			
			
		}
		
		
		
		
		return false;
				
	
	}

	
	
	
	
	
	
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
    
}
