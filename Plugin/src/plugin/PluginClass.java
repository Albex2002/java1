package plugin;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
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
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatColor;

public class PluginClass extends JavaPlugin implements Listener {

	private static final double X_FANTASMA = -125;


	private static final double Y_FANTASMA = 117;


	private static final double Z_FANTASMA = 252;


	private static final double X_CAZAFANTASMA = -114;


	private static final double Y_CAZAFANTASMA = 117;


	private static final double Z_CAZAFANTASMA = 364;


	long tiempoCooldown = 0;


	private HashMap<Player, Long> tiempos = new HashMap<>();

	private ArrayList<Player> jugadores = new ArrayList<Player>();
	private ArrayList<Player> cazafantasmas = new ArrayList<Player>();
	private ArrayList<Player> fantasmas = new ArrayList<Player>();
	private ArrayList<Player> listaNoCiegos = new ArrayList<Player>();
	private ArrayList<Player> listaCooldown = new ArrayList<Player>();
	long a = 0;

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		getServer().broadcastMessage("on command se ejecuta");

		if(command.getName().equals("startgb")){
			//comprobar que el tamaño de la lista sea mayor de 3. seleccionar un j8ugador aleatorio y marcarlo como fantasma
			//coger el resto de los jugadores y meterlos en la lista de los cazafantasmas.
			// Math.random()*6 

			int random = (int) (Math.random()*jugadores.size());
			Player fantasma = jugadores.remove(random);
			if(!fantasmas.contains(fantasma)){
				fantasmas.add(fantasma);
				kitFantasma(fantasma);
				getServer().broadcastMessage(ChatColor.DARK_RED + "El jugador " + ChatColor.GOLD + fantasma.getName() + ChatColor.DARK_RED + " ha muerto por vuestra culpa, y se quiere vengar de vosotros, tener cuidado.");

				comenzarCuentaAtras();

			

			}	
			cazafantasmas.addAll(jugadores);



			for (Player p : cazafantasmas){
				p.sendMessage(ChatColor.GREEN + "Tu objetivo como cazafantasma es sobrevivir a los ataques del fantasma, te hemod prporcionado una linterna que te ayudara a quitarte la ceguera unos 4 segundos, con ella podrás pegar al fantasma.");
				p.sendMessage(ChatColor.AQUA + "Para utilizar la linterna comoiluminación utiliza:" + ChatColor.GOLD + " Click Derecho" + ChatColor.AQUA + " para utilizarla como arma:" + ChatColor.GOLD + "Click Izquierdo");
				kitCazafantasma(p);
				p.setGameMode(GameMode.SURVIVAL);
			}
			for (Player p : fantasmas) {
				p.sendMessage(ChatColor.GREEN + "Eres un fantasma y te tienes que vengar de tus compañeros que no te salvaron, tienes un arma para matarles y tienes una ventaja, no tienes ceguera como ellos que la tienen, su arma es una linterna asi que ten cuidado.");
				kitFantasma(fantasma);
				p.setGameMode(GameMode.SURVIVAL);
			}
			//cuando mate un fantasma a un gb que lo nmande a un fantasma.
			BukkitRunnable r = new BukkitRunnable() {

				@Override
				public void run() {

					for (Player p : cazafantasmas){
						if(!listaNoCiegos.contains(p)){
							p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,50000,10000));
						}
					}
				}
			};

			r.runTaskTimer(this, 1, 1);

			return true;
		}
		if(command.getName().equalsIgnoreCase("joingb")){

			if(sender instanceof Player){
				if(!jugadores.contains((Player)sender)){
					jugadores.add((Player)sender);
					getServer().broadcastMessage(ChatColor.DARK_AQUA + ((Player)sender).getName() + ChatColor.RED + " se ha unido al equipo " + ChatColor.GOLD + "CAZA FANTASMAS");
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
				if(cazafantasmas.isEmpty()){
					getServer().broadcastMessage(ChatColor.AQUA +  "Los fantasmas han ganado, los cazafantasmas pierden");
					for (Player p : jugadores){
						p.setHealth(0);
					}
					jugadores.removeAll(cazafantasmas);
					jugadores.removeAll(fantasmas);
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
				getServer().broadcastMessage(ChatColor.AQUA  + "Los fantasmas han perdido, los cazafantasmas ganan");
				for (Player p : jugadores){
					p.setHealth(0);
				}
				jugadores.removeAll(cazafantasmas);
				jugadores.removeAll(fantasmas);
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


	public void kitCazafantasma(Player p){
		p.getInventory().clear();
		ItemStack l  = new ItemStack(Material.REDSTONE_TORCH_ON) ;
		ItemMeta im = l.getItemMeta();
		im.setDisplayName(ChatColor.AQUA + "linterna");
		im.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
		im.addEnchant(Enchantment.KNOCKBACK, 1, true);
		l.setItemMeta(im);
		p.setItemInHand(l);
		tiempos.put(p, 0L);
		Location locFantasma = new Location(p.getWorld(), X_CAZAFANTASMA, Y_CAZAFANTASMA, Z_CAZAFANTASMA);
		p.teleport(locFantasma);

	}

	public void kitFantasma(Player player){

		//kit fantasma
		//quitamos las cosas del jugador
		player.getInventory().clear();
		player.removePotionEffect(PotionEffectType.BLINDNESS);

		//añadimos cosas del kit fantasma
		ItemStack pechera = new ItemStack (Material.CHAINMAIL_CHESTPLATE);
		player.getInventory().setChestplate(pechera);

		ItemStack patucos = new ItemStack(Material.LEATHER_BOOTS, 1);
		LeatherArmorMeta lam = (LeatherArmorMeta)patucos.getItemMeta();
		lam.setColor(Color.fromRGB(255, 255, 255));
		patucos.setItemMeta(lam);
		player.getInventory().setBoots(patucos);


		ItemStack hueso = new ItemStack(Material.BONE);
		ItemMeta huesoMeta = hueso.getItemMeta();
		huesoMeta.addEnchant(Enchantment.DAMAGE_ALL, 3,true);
		hueso.setItemMeta(huesoMeta);
		player.setItemInHand(hueso);
		Location locFantasma = new Location(player.getWorld(), X_FANTASMA, Y_FANTASMA, Z_FANTASMA);
		player.teleport(locFantasma);

	}

	@EventHandler
	public void daños (EntityDamageByEntityEvent e){
		Entity damager = e.getDamager();
		Entity damaged = e.getEntity();
		if(damager instanceof Player && damaged instanceof Player){
			Player pDamager = (Player)damager;
			Player pDamaged = (Player)damaged;

			if(cazafantasmas.contains(pDamager) && cazafantasmas.contains(pDamaged)){
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

		if(e.getPlayer().getGameMode() == GameMode.SURVIVAL){
			e.setCancelled(true);
		}



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
		if(cazafantasmas.contains(p)){
			cazafantasmas.remove(p);
			fantasmas.add(p);
			getServer().broadcastMessage("esto se ejecuta");
			Location locFantasma = new Location(p.getWorld(), X_FANTASMA, Y_FANTASMA, Z_FANTASMA);
			p.teleport(locFantasma);
			
		}
		if(cazafantasmas.isEmpty()){
			getServer().broadcastMessage("no queda nadie en el equipo de los cazafantasmas");
		}
		getServer().broadcastMessage(cazafantasmas.size()+"");
		
	}

	@EventHandler
	public void onPlayerSpawnEvent(PlayerRespawnEvent e){

		Player p = e.getPlayer();
		if (fantasmas.contains(p)){
			Location locFantasma = new Location(p.getWorld(), X_FANTASMA, Y_FANTASMA, Z_FANTASMA);
			e.setRespawnLocation(locFantasma);
			kitFantasma(p);
			p.teleport(locFantasma);
		}




	}












}
