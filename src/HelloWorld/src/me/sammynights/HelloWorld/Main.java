package me.sammynights.HelloWorld;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        //Fired when the server enables the plugin
    }

    @Override
    public void onDisable(){
        //Fired when the server stops and disables all plugins
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    
    	if(label.equalsIgnoreCase("hello")) {
    		if(!(sender instanceof Player)) {
    			sender.sendMessage("You need to be a player to run this command");
    			return true;
    		}
    		if(!sender.hasPermission("helloworld.use")) {
    			sender.sendMessage("You do not have permission!");
    			return true;
    		}
    		NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, "Pedro");
    		Player p = (Player) sender;
    		Location location = p.getLocation();
    		p.sendMessage("Hello " + p.getName());
    		npc.spawn(location);
/*    		npc.addTrait(builder); */
    		return true;
    		}
    return false;
}

	private Location getLocation(Player p) {
		// TODO Auto-generated method stub
		return null;
	}
}