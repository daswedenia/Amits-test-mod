package net.kaupenjoe.tutorialmod.block.custom;

import net.kaupenjoe.tutorialmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.sound.Sound;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MagicBlock extends Block {
    public MagicBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            world.playSound(null, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 1f, 1f);
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!world.isClient && entity instanceof ItemEntity itemEntity) {
            ItemStack stack = itemEntity.getStack();
                if (stack.getItem() == ModItems.PINK_GARNET) {
                    itemEntity.setStack(new ItemStack(Items.DIAMOND, stack.getCount()));
                } else if (stack.getItem() == Items.DIAMOND) {
                    itemEntity.setStack(new ItemStack(ModItems.PINK_GARNET, stack.getCount()));
                }
            }

        super.onSteppedOn(world, pos, state, entity);
    }
}