package com.navidk.myriadvanish;

import java.rmi.server.Skeleton;
import org.bukkit.ChatColor;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Giant;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Monster;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.NPC;
import org.bukkit.entity.Pig;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.entity.EntityTargetEvent;

/**
 * Handle events for Entities
 * 
 * @author NavidK0
 */
public class MyriadEListener extends EntityListener 
{        
        MyriadVanish plugin;
	MyriadEListener(MyriadVanish par) {
        plugin=par;
        }
	@Override
	public void onEntityTarget(EntityTargetEvent e) {
		
		//Don't bother with non players
		if (!(e.getTarget() instanceof Player))
			return;
	   
                Player player = (Player) e.getTarget();
                String pname = player.getName();
                if (plugin.isPlayerInvisible(pname)){
		//Check the permissions
		if ((!player.hasPermission("vanish.nomobs") && !player.hasPermission("vanish.all")) && !player.isOp()) return;
		
		//Make sure it's a hostile mob
	         LivingEntity le = (LivingEntity) e.getEntity();
		
		//Get the name
		String name = checkMonsters(le);
		
		//If it's not in our list, exit
		if (name.isEmpty()){
                    return;
                }
		
		
		//We've passed all checks, cancel the event
		e.setCancelled(true);
                
		return;
		
	}
        }

	public String checkMonsters(LivingEntity le) {
		String name = "";
		if (le instanceof Chicken) {
			name = "chicken";
		} else if (le instanceof Cow) {
			name = "cow";
		} else if (le instanceof Creeper) {
			name = "creeper";
		} else if (le instanceof Ghast) {
			name = "ghast";
		} else if (le instanceof Giant) {
			name = "giant";
		} else if (le instanceof Pig) {
			name = "pig";
		} else if (le instanceof PigZombie) {
			name = "pigzombie";
		} else if (le instanceof Monster) {
			name = "monster";
		} else if (le instanceof Sheep) {
			name = "sheep";
		} else if (le instanceof Skeleton) {
			name = "skeleton";
		} else if (le instanceof Slime) {
			name = "slime";
		} else if (le instanceof Spider) {
			name = "spider";
		} else if (le instanceof Squid) {
			name = "squid";
		} else if (le instanceof Wolf) {
			name = "wolf";
		} else if (le instanceof Zombie) {
			name = "zombie";
		} else if (le instanceof Silverfish ){
                    name = "silverfish";
                } else if (le instanceof Monster ){
                    name = "monster";
                }else if (le instanceof MagmaCube ){
                    name = "magmacube";
                }else if (le instanceof Enderman ){
                    name = "enderman";
                }else if (le instanceof CaveSpider ){
                    name = "cavespider";
                } else if (le instanceof Blaze ){
                    name = "blaze";
                } else if (le instanceof EnderDragon ){
                    name = "enderdragon";
                } else if (le instanceof MushroomCow ){
                    name = "mooshroom";
                } else if (le instanceof Villager ){
                    name = "villager";
                } else if (le instanceof NPC ){
                    name = "bukkit npc";
                }
		return name;
	}
}
