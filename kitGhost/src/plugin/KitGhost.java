package plugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class KitGhost extends JavaPlugin implements Listener{

	@SuppressWarnings("unused")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {	
		
		if(command.getName().equalsIgnoreCase("kitGhost")){
			Player p = (Player) sender;
			
			
			p.removePotionEffect(PotionEffectType.ABSORPTION);
			p.removePotionEffect(PotionEffectType.SPEED);
			p.removePotionEffect(PotionEffectType.JUMP);
			p.removePotionEffect(PotionEffectType.NIGHT_VISION);
			p.removePotionEffect(PotionEffectType.SLOW);
			
			p.getInventory().clear();
			
			ItemStack espada = new ItemStack(Material.IRON_SWORD);
			p.getInventory().addItem(espada);
			
			
			ItemStack botas = new ItemStack(Material.CHAINMAIL_BOOTS);
			//p.getInventory().addItem(botas);
			//ItemMeta botasMeta = botas.getItemMeta();
			//botasMeta.addEnchant(Enchantment.FIRE_ASPECT, 20, true);
			//botas.setItemMeta(botasMeta);
			p.getInventory().setBoots(botas);
			
			p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 20000, 1));
			p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20000, 1));
			
			
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
