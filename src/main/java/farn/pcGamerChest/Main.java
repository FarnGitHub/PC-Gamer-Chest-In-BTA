package farn.pcGamerChest;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.block.BlockChest;
import net.minecraft.core.util.helper.Side;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

import net.minecraft.core.world.World;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockChestLegacy;
import net.minecraft.core.block.entity.TileEntitySign;
import net.minecraft.core.block.entity.TileEntityChest;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;

import java.io.*;
import java.util.Properties;

public class Main implements ModInitializer {
    public static final String MOD_ID = "pc_gamer_chest";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("PC Gamer Chest initialized.");
    }

    public static void initChest(World world) {
        Random gunPowderRand = new Random(19L);
        int chestX = world.getSpawnPoint().x + 2;
        int chestZ = world.getSpawnPoint().z + 2;
        int chestY = world.findTopSolidBlock(chestX, chestZ);

        world.setBlockAndMetadataWithNotify(chestX, chestY, chestZ - 1, Block.chestPlanksOak.id, 6);
        TileEntityChest chest1 = (TileEntityChest)world.getBlockTileEntity(chestX, chestY, chestZ - 1);
        world.setBlockAndMetadataWithNotify(chestX + 1, chestY, chestZ - 1, Block.chestPlanksOak.id, 10);
        TileEntityChest chest2 = (TileEntityChest)world.getBlockTileEntity(chestX + 1, chestY, chestZ - 1);

        world.setBlockWithNotify(chestX, chestY - 4, chestZ, Block.chestPlanksOak.id);
        TileEntityChest chestSecret = (TileEntityChest)world.getBlockTileEntity(chestX, chestY - 4, chestZ);

        world.setBlockWithNotify(chestX, chestY, chestZ, Block.signPostPlanksOak.id);

        if(world.getBlockTileEntity(chestX, chestY, chestZ) != null) {
            ((TileEntitySign)world.getBlockTileEntity(chestX, chestY, chestZ)).signText[0] = "Have some stuff!";
            ((TileEntitySign)world.getBlockTileEntity(chestX, chestY, chestZ)).signText[1] = "/ PC Gamer";
            ((TileEntitySign)world.getBlockTileEntity(chestX, chestY, chestZ)).signText[2] = "p.s. Right click";
            ((TileEntitySign)world.getBlockTileEntity(chestX, chestY, chestZ)).signText[3] = "to open!";
        }

        chest1.setInventorySlotContents(7, new ItemStack(Item.toolFirestriker, 1, 50));
        chest1.setInventorySlotContents(3, new ItemStack(Item.toolAxeIron, 1, 122));
        chest1.setInventorySlotContents(10, new ItemStack(Item.toolPickaxeIron, 1, 140));
        chest1.setInventorySlotContents(23, new ItemStack(Item.foodBread));
        chest1.setInventorySlotContents(24, new ItemStack(Item.foodBread));
        chest1.setInventorySlotContents(15, new ItemStack(Item.foodBread));
        chest1.setInventorySlotContents(16, new ItemStack(Item.foodBread));
        chest1.setInventorySlotContents(26, new ItemStack(Item.foodBread));

        chest2.setInventorySlotContents(7, new ItemStack(Item.string, 4));
        chest2.setInventorySlotContents(10, new ItemStack(Block.torchCoal, 12));
        chest2.setInventorySlotContents(2, new ItemStack(Item.coal, 4));
        chest2.setInventorySlotContents(11, new ItemStack(Item.stick, 2));
        chest2.setInventorySlotContents(26, new ItemStack(Item.toolCompass, 3));

        for(int i7 = 0; i7 < 7; ++i7) {
            chestSecret.setInventorySlotContents(gunPowderRand.nextInt(27), new ItemStack(Item.sulphur, gunPowderRand.nextInt(10) + 1));
        }

    }
}
