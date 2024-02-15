package com.redsifter.weaponsplus;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;


public final class WeaponsPlus extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        ItemStack katana = new ItemStack(Material.IRON_SWORD,1);
        ItemMeta katanaMeta = katana.getItemMeta();
        katanaMeta.setCustomModelData(1);
        katanaMeta.displayName(Component.text("Katana"));

        Multimap<Attribute,AttributeModifier> ml = ArrayListMultimap.create();
        ml.put(Attribute.GENERIC_ATTACK_SPEED,new AttributeModifier(UUID.randomUUID(),"generic.attack_speed",3.0,AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
        ml.put(Attribute.GENERIC_ATTACK_DAMAGE,new AttributeModifier(UUID.randomUUID(),"generic.attack_damage",8.0,AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));

        katanaMeta.setAttributeModifiers(ml);
        katana.setItemMeta(katanaMeta);

        ShapedRecipe katanaRecipe = new ShapedRecipe(new NamespacedKey(this,"katana"),katana);
        katanaRecipe.shape(" I ","GIG","SIS");
        katanaRecipe.setIngredient('I',Material.IRON_INGOT);
        katanaRecipe.setIngredient('G',Material.GOLD_INGOT);
        katanaRecipe.setIngredient('S',Material.STICK);

        Bukkit.addRecipe(katanaRecipe);
        ml.clear();

        ItemStack hammer = new ItemStack(Material.IRON_SWORD,1);
        ItemMeta hammerMeta = hammer.getItemMeta();
        hammerMeta.setCustomModelData(2);
        hammerMeta.displayName(Component.text("Hammer"));
        ml.put(Attribute.GENERIC_ATTACK_DAMAGE,new AttributeModifier(UUID.randomUUID(),"generic.attack_damage",10.0,AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));

        hammerMeta.setAttributeModifiers(ml);
        hammer.setItemMeta(hammerMeta);

        ShapedRecipe hammerRecipe = new ShapedRecipe(new NamespacedKey(this,"hammer"),hammer);
        hammerRecipe.shape("   ","III"," S ");
        hammerRecipe.setIngredient('I',Material.IRON_INGOT);
        hammerRecipe.setIngredient('S',Material.STICK);
        Bukkit.addRecipe(hammerRecipe);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
