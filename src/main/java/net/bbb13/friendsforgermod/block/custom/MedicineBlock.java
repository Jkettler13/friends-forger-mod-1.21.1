package net.bbb13.friendsforgermod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MedicineBlock extends Block {


    public MedicineBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isPlayerInRange(pos.getX(), pos.getY(), pos.getZ(), 5.0)) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 240, 2));
        }
        return ActionResult.SUCCESS;

    }
}
