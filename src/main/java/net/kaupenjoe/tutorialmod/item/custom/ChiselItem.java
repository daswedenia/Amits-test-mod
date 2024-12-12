package net.kaupenjoe.tutorialmod.item.custom;

import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class ChiselItem extends Item {

    public static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,               //Block X, to Block y
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.ANDESITE, Blocks.POLISHED_ANDESITE,
                    ModBlocks.BLOCK_OF_MAGYORK, ModBlocks.BLOCK_OF_BABAE_VIKTOR,
                    ModBlocks.BLOCK_OF_LEPINE, Blocks.DIRT

            );


    public ChiselItem(Settings settings) {
        super(settings);  //Its just an item for now, no extra functions...
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(CHISEL_MAP.containsKey(clickedBlock)){
            if(!world.isClient()) {
                world.setBlockState(context.getBlockPos(), CHISEL_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1,((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);
            }
        }
        return ActionResult.SUCCESS;
    }
}
