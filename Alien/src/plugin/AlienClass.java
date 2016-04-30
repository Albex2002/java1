package plugin;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatColor;

public class AlienClass extends JavaPlugin implements Listener {

	private static final double X_ASTRONAUTA = -410;


	private static final double Y_ASTRONAUTA = 62;


	private static final double Z_ASTRONAUTA = -48;


	private static final double X_ALIEN = -434;


	private static final double Y_ALIEN = 41;


	private static final double Z_ALIEN = -67;


	long tiempoCooldown = 0;


	private HashMap<Player, Long> tiempos = new HashMap<>();

	private ArrayList<Player> jugadores = new ArrayList<Player>();
	private ArrayList<Player> astronautas = new ArrayList<Player>();
	private ArrayList<Player> alien = new ArrayList<Player>();
	private ArrayList<Player> listaNoCiegos = new ArrayList<Player>();
	private ArrayList<Player> listaCooldown = new ArrayList<Player>();
	long a = 0;

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		getServer().broadcastMessage("on command se ejecuta");

		if(command.getName().equals("startAlien")){
			//comprobar que el tamaño de la lista sea mayor de 3. seleccionar un j8ugador aleatorio y marcarlo como fantasma
			//coger el resto de los jugadores y meterlos en la lista de los cazafantasmas.
			// Math.random()*6 

			int random = (int) (Math.random()*jugadores.size());
			Player aliens = jugadores.remove(random);
			if(!alien.contains(aliens)){
				alien.add(aliens);
				kitAlien(aliens);
				getServer().broadcastMessage(ChatColor.YELLOW + "NASA-- " + ChatColor.GREEN + "Hola, os hemos enviado a " + org.bukkit.ChatColor.GOLD + "nostromo" + ChatColor.GREEN + " para investigar los problemas de comunicación, su unico deber arreglar la nave.");
                getServer().broadcastMessage(ChatColor.YELLOW + "NASA-- " + ChatColor.RED + "acabamos de descubrir ed que no había fallos, resulta que " + ChatColor.MAGIC + "oljbhgdlsjn" + ChatColor.AQUA + "fin e la transmisión.");
				comenzarCuentaAtras();

			

			}	
			astronautas.addAll(jugadores);



			for (Player p : astronautas){
				p.sendMessage(ChatColor.GREEN + "Tu objetivo como cazafantasma es sobrevivir a los ataques del fantasma, te hemod prporcionado una linterna que te ayudara a quitarte la ceguera unos 4 segundos, con ella podrás pegar al fantasma.");
				p.sendMessage(ChatColor.AQUA + "Para utilizar la linterna comoiluminación utiliza:" + ChatColor.GOLD + " Click Derecho" + ChatColor.AQUA + " para utilizarla como arma:" + ChatColor.GOLD + "Click Izquierdo");
				KitAstronauta(p);
				p.setGameMode(GameMode.SURVIVAL);
			}
			for (Player p : alien) {
				p.sendMessage(ChatColor.GREEN + "Eres un fantasma y te tienes que vengar de tus compañeros que no te salvaron, tienes un arma para matarles y tienes una ventaja, no tienes ceguera como ellos que la tienen, su arma es una linterna asi que ten cuidado.");
				kitAlien(aliens);
				p.setGameMode(GameMode.SURVIVAL);
			}
			//cuando mate un fantasma a un gb que lo nmande a un fantasma.
			BukkitRunnable r = new BukkitRunnable() {

				@Override
				public void run() {

					for (Player p : astronautas){
						if(!listaNoCiegos.contains(p)){
							p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,50000,10000));
						}
					}
				}
			};

			r.runTaskTimer(this, 1, 1);

			return true;
		}
		if(command.getName().equalsIgnoreCase("joinAlien")){
			
			Player p = (Player) sender;
			WorldCreator.name("lobby gb").createWorld();
			World An = getServer().getWorld("lobby gb");
			p.teleport(new Location(An,-398,44,-54));
			

			if(sender instanceof Player){
				if(!jugadores.contains((Player)sender)){
					jugadores.add((Player)sender);
					getServer().broadcastMessage(ChatColor.DARK_AQUA + ((Player)sender).getName() + ChatColor.RED + " se ha unido a" + ChatColor.GOLD + " Alien");
				}
			}
			return true;
		}
		return false;
	}


	private void comenzarCuentaAtras() {
		long tiempoActual = System.currentTimeMillis();
		long tiempoTranscurrido = tiempoActual - a;
		BukkitRunnable br1 = new BukkitRunnable() {

			@Override
			public void run() {
				if(astronautas.isEmpty()){
					getServer().broadcastMessage(ChatColor.YELLOW + "NASA-- " + ChatColor.DARK_AQUA + "Hemos Perdido contacto con los astronautas, demonios... que, ¿que ha pasado?");
					for (Player p : jugadores){
						p.setHealth(0);
					}
					jugadores.removeAll(astronautas);
					jugadores.removeAll(alien);
					jugadores.removeAll(listaNoCiegos);
					jugadores.removeAll(listaCooldown);
					jugadores.clear();
					cancel();
				}

			}
		};
		br1.runTaskTimer(this, 0, 20);

		BukkitRunnable br = new BukkitRunnable() {

			@Override
			public void run() {
				getServer().broadcastMessage("se acabo el tiempo");
				a = System.currentTimeMillis();
				getServer().broadcastMessage(ChatColor.YELLOW + "NASA--" + ChatColor.GREEN + "Equipo A1. equipo A1, salgan de la nave resulta qe hay un alienígena, sagan de ahí, menuda suerte que hallamos contactado y que ustedes siguieran vivos.");
				for (Player p : jugadores){
					p.setHealth(0);
				}
				jugadores.removeAll(astronautas);
				jugadores.removeAll(alien);
				jugadores.removeAll(listaNoCiegos);
				jugadores.removeAll(listaCooldown);
				jugadores.clear();


			}
		};
		br.runTaskLater(this, 20*300);
		if(tiempoTranscurrido > 300000){
			/*a = System.currentTimeMillis();
			getServer().broadcastMessage(ChatColor.AQUA + fantasma.getName() + " ha perdido, los cazafantasmas ganan");
			for (Player p : jugadores){
				p.setHealth(0);
			}
			jugadores.removeAll(cazafantasmas);
			jugadores.removeAll(fantasmas);
			jugadores.removeAll(listaNoCiegos);
			jugadores.removeAll(listaCooldown);
			jugadores.clear();

			if(cazafantasmas.isEmpty()){
				getServer().broadcastMessage(ChatColor.AQUA + fantasma.getName() + " ha ganado, los cazafantasmas p");
				for (Player p : jugadores){
					p.setHealth(0);
				}
				jugadores.removeAll(cazafantasmas);
				jugadores.removeAll(fantasmas);
				jugadores.removeAll(listaNoCiegos);
				jugadores.removeAll(listaCooldown);
				jugadores.clear();
			}*/

		}
	}


	public void KitAstronauta(Player p) {
		
		 p.setGameMode(GameMode.ADVENTURE);
		 p.getInventory().clear();
		getServer().getPluginManager().registerEvents(this, this);
		p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION,20, 480000 ));
		ItemStack patucos = new ItemStack(Material.LEATHER_BOOTS, 1);
		LeatherArmorMeta lam0 = (LeatherArmorMeta)patucos.getItemMeta();
		lam0.setColor(Color.fromRGB(255, 255, 255));
		patucos.setItemMeta(lam0);
		p.getInventory().setBoots(patucos);

		ItemStack pantacalones = new ItemStack (Material.LEATHER_LEGGINGS);
		LeatherArmorMeta lam1 = (LeatherArmorMeta)patucos.getItemMeta();
		lam1.setColor(Color.fromBGR(255, 255, 255));
		pantacalones.setItemMeta(lam1);
		p.getInventory().setLeggings(pantacalones);

		ItemStack pechera = new ItemStack (Material.LEATHER_CHESTPLATE);
		LeatherArmorMeta lam2 = (LeatherArmorMeta)pechera.getItemMeta();
		lam2.setColor(Color.fromRGB(255, 255, 255));
		pechera.setItemMeta(lam2);
		p.getInventory().setChestplate(pechera);

		ItemStack pistola = new ItemStack (Material.BOW);
		ItemMeta lam3 = (ItemMeta) pistola.getItemMeta();
		lam3.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, true);
		p.getInventory().addItem(pistola);
		
		ItemStack Magia = new ItemStack (Material.GLASS);
		p.getInventory().setHelmet(Magia);
		
		ItemStack bullet = new ItemStack(Material.ARROW, 3);
		p.getInventory().addItem(bullet);
		Location locAstronauta = new Location(p.getWorld(), X_ASTRONAUTA, Y_ASTRONAUTA, Z_ASTRONAUTA);

		}

		@EventHandler
		public void gg(InventoryOpenEvent e){
		e.setCancelled(true);
		}

	public void kitAlien(Player p){
		PlayerInventory pi = p.getInventory();
		p.getInventory().clear();
        p.setGameMode(GameMode.ADVENTURE);

		p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,20,480000));
		p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION,20, 480000 ));
		p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,20, 480000 ));
		p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,20, 480000 ));
	
		
		ItemStack botas = new ItemStack(Material.LEATHER_BOOTS, 1);
		LeatherArmorMeta imb = (LeatherArmorMeta)botas.getItemMeta();
		imb.setColor(Color.fromRGB(53,	94,	59));
		botas.setItemMeta(imb);
		pi.setBoots(botas);

		ItemStack pants = new ItemStack(Material.LEATHER_BOOTS, 1);
		LeatherArmorMeta imp = (LeatherArmorMeta)pants.getItemMeta();
		imp.setColor(Color.BLACK);
		pants.setItemMeta(imp);
		pi.setLeggings(pants);

		ItemStack pech = new ItemStack(Material.LEATHER_BOOTS, 1);
		LeatherArmorMeta imch = (LeatherArmorMeta)pech.getItemMeta();
		imch.setColor(Color.BLACK);
		pech.setItemMeta(imch);
		pi.setBoots(pech);

		ItemStack casc = new ItemStack(Material.LEATHER_BOOTS, 1);
		LeatherArmorMeta imc = (LeatherArmorMeta)casc.getItemMeta();
		imc.setColor(Color.BLACK);
		casc.setItemMeta(imc);
		pi.setBoots(casc);

		ItemStack colmillo = new ItemStack(Material.GOLD_NUGGET);
		ItemMeta im = colmillo.getItemMeta();
		im.setDisplayName("colmillo");
		im.addEnchant(Enchantment.DAMAGE_ALL, 100, true);
		colmillo.setItemMeta(im);
		p.setItemInHand(colmillo);
		Location locAlien = new Location(p.getWorld(), X_ALIEN, Y_ALIEN, Z_ALIEN);
		
		}

	@EventHandler
	public void daños (EntityDamageByEntityEvent e){
		Entity damager = e.getDamager();
		Entity damaged = e.getEntity();
		if(damager instanceof Player && damaged instanceof Player){
			Player pDamager = (Player)damager;
			Player pDamaged = (Player)damaged;

			if(astronautas.contains(pDamager) && astronautas.contains(pDamaged)){
				e.setCancelled(true);
				return;
			}

			if(pDamager.getItemInHand()!= null && pDamager.getItemInHand().getItemMeta() != null && pDamager.getItemInHand().getItemMeta().getDisplayName() != null && 
					pDamager.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "linterna")){

				//AQUI SABEMOS QUE EL JUGADOR QUE HA HECHO DAÑO A OTRO TIENE LA LINTERNA

				pDamaged.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION,20,1));



			}
		}

	}



	@EventHandler
	public void onBlockPlaceEvent (BlockPlaceEvent e){

	
		



	}



	@EventHandler
	public void onBlockBreakEvent (BlockBreakEvent e){

		if(e.getPlayer().getGameMode() == GameMode.SURVIVAL){
			e.setCancelled(true);
		}


	}





	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}



	@EventHandler
	public void playerDeaths(PlayerDeathEvent e)
	{

		Player p = e.getEntity();
		e.getDrops().clear();
		if(astronautas.contains(p)){
			p.setGameMode(GameMode.SPECTATOR);
			getServer().broadcastMessage("esto se ejecuta");
			
			
		}
		if(astronautas.isEmpty()){
			getServer().broadcastMessage(ChatColor.YELLOW + "NASA-- " + ChatColor.DARK_AQUA + "Hemos Perdido contacto con los astronautas, demonios... que, ¿que ha pasado?");
		}
		getServer().broadcastMessage(ChatColor.YELLOW + "Nasa" + ChatColor.GREEN + "Un astronauta ha muerto, solo quedaís " + astronautas.size());
		
	}

	@EventHandler
	public void onPlayerSpawnEvent(PlayerRespawnEvent e){

		/*Player p = e.getPlayer();
		if (alien.contains(p)){
			//Location locFantasma = new Location(p.getWorld(), X_FANTASMA, Y_FANTASMA, Z_FANTASMA);
			e.setRespawnLocation(locFantasma);
			kitAlien(p);
			p.teleport(locFantasma);*/
		//}




	}












}
