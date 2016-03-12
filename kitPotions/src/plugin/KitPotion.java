package plugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class KitPotion extends JavaPlugin implements Listener{

	@SuppressWarnings("unused")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {	
		
		if(command.getName().equalsIgnoreCase("kitPotion")){
			Player p = (Player) sender;
			
			p.removePotionEffect(PotionEffectType.ABSORPTION);
			p.removePotionEffect(PotionEffectType.SPEED);
			p.removePotionEffect(PotionEffectType.JUMP);
			p.removePotionEffect(PotionEffectType.NIGHT_VISION);
			p.removePotionEffect(PotionEffectType.SLOW);
			
			p.getInventory().clear();
			ItemStack espada = new ItemStack(Material.WOOD_SWORD);
			p.getInventory().addItem(espada);
			
			ItemStack potion = new ItemStack(Material.POTION,5);
			Potion poti = new Potion(1);
			poti.setType(PotionType.FIRE_RESISTANCE);
			
			poti.apply(potion);
			p.getInventory().addItem(potion);
			
			
			ItemStack potio = new ItemStack(Material.POTION,2);
			Potion pot = new Potion(1);
			poti.setType(PotionType.STRENGTH);
			poti.setSplash(false);
			poti.apply(potio);
			p.getInventory().addItem(potio);
			
			ItemStack potion1 = new ItemStack(Material.POTION,40);
			Potion poti1 = new Potion(1);
			poti.setType(PotionType.INSTANT_DAMAGE);
			poti.setSplash(true);
			poti.apply(potion1);
			p.getInventory().addItem(potion1);
			
			ItemStack potion2 = new ItemStack(Material.POTION,5);
			Potion poti2 = new Potion(1);
			poti.setType(PotionType.INVISIBILITY);	
			poti.setSplash(false);
			poti.apply(potion2);
			p.getInventory().addItem(potion2);
			
			ItemStack potio1 = new ItemStack(Material.POTION,10);
			Potion pot1 = new Potion(1);
			poti.setType(PotionType.INSTANT_HEAL);
			poti.setSplash(true);
			poti.apply(potio1);
			p.getInventory().addItem(potio1);
			
			
			ItemStack potio3 = new ItemStack(Material.POTION,20);
			Potion pot3 = new Potion(1);
			poti.setType(PotionType.WEAKNESS);
			poti.setSplash(true);
			poti.apply(potio3);
			p.getInventory().addItem(potio3);
			
			ItemStack potio4 = new ItemStack(Material.POTION,2);
			Potion pot4 = new Potion(1);
			poti.setType(PotionType.STRENGTH);
			poti.setSplash(false);
			poti.apply(potio4);
			p.getInventory().addItem(potio4);

			ItemStack casco = new ItemStack(Material.CHAINMAIL_LEGGINGS);
			p.getInventory().setLeggings(casco);
			
			ItemStack pechera = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
			p.getInventory().setHelmet(pechera);
			
			
			ItemStack pantalones = new ItemStack(Material.CHAINMAIL_HELMET);
			//p.getInventory().addItem(pantalones);
			p.getInventory().setBoots(pantalones);
			
			ItemStack botas = new ItemStack(Material.CHAINMAIL_BOOTS);
			p.getInventory().setChestplate(botas);
			
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, 200000));
			
			
			
			ItemStack zanahoria = new ItemStack(Material.CARROT_ITEM,30);
			p.getInventory().addItem(zanahoria);
			
			
			
			
		}
		
		
		
		
		return false;
				
	
	}

	
	
	
	
	
	
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
    
}
