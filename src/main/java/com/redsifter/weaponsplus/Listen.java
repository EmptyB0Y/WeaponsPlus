package com.redsifter.weaponsplus;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class Listen implements Listener {

    @EventHandler
    public void playerLeftClick(PlayerInteractEvent e){
        if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK && e.hasItem()){
            ItemStack it = e.getPlayer().getActiveItem();
            int cmd = it.getItemMeta().getCustomModelData();
            if(cmd >= 3){
                Entity entity = e.getPlayer().getWorld().spawnEntity()
            }
        }
    }
}
