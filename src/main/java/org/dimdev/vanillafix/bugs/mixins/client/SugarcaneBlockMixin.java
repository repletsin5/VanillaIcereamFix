package org.dimdev.vanillafix.bugs.mixins.client;

import net.minecraft.block.Block;
import net.minecraft.block.BlockReed;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockReed.class)
public abstract class SugarcaneBlockMixin extends Block {
    public SugarcaneBlockMixin(Material materialIn) {
        super(materialIn);
    }

    @Inject(method = "canPlaceBlockAt",at =@At(value = "INVOKE",target ="Lnet/minecraft/world/World;getBlockState(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/block/state/IBlockState;"),cancellable = true)
    public void inWaterTest(World worldIn, BlockPos pos, CallbackInfoReturnable<Boolean> cir){
        if(worldIn.getBlockState(pos).getMaterial() == Material.WATER)
            cir.setReturnValue(false);
    }
}
