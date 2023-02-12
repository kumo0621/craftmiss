package com.github.kumo0621.craftmiss;

import net.kunmc.lab.commandlib.CommandLib;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class craftmiss extends JavaPlugin implements org.bukkit.event.Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        CommandLib.register(this, new intcommand());
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static boolean set = false;
    public static int zyougen = 30;
    public static int kakuritu = 25;

    @EventHandler
    public void onCraftItem(CraftItemEvent event) {
        if(!set){
            return;
        }
        int random = RandomCount.random();
        if(random <= kakuritu) {
            Player player = (Player) event.getWhoClicked();
            player.sendMessage("・ クラフトに失敗しました");
            ItemStack craftedItem = event.getInventory().getResult();
            ItemMeta craftedItemMeta = Objects.requireNonNull(craftedItem).getItemMeta();

            // クラフトされたアイテムのメタデータを変更する場合
            craftedItem.setItemMeta(craftedItemMeta);

            // クラフトされたアイテムを削除して別のアイテムと入れ替える場合
            event.getInventory().setResult(new ItemStack(Material.STONE));
        }
    }

}

