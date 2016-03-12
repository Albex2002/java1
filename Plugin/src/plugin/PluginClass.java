package plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginClass extends JavaPlugin implements Listener {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {







		return false;
		
		
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}



}
