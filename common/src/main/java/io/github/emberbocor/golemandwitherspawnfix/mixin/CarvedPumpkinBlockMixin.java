package io.github.emberbocor.golemandwitherspawnfix.mixin;

import io.github.emberbocor.golemandwitherspawnfix.SummonCells;
import java.util.function.Predicate;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(CarvedPumpkinBlock.class)
public class CarvedPumpkinBlockMixin {
    @ModifyArg(
            method = {"getOrCreateIronGolemBase", "getOrCreateIronGolemFull"},
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/pattern/BlockPatternBuilder;where(CLjava/util/function/Predicate;)Lnet/minecraft/world/level/block/state/pattern/BlockPatternBuilder;"),
            index = 1
    )
    private Predicate<BlockInWorld> golemandwitherspawnfix$emptyCell(char symbol, Predicate<BlockInWorld> predicate) {
        return symbol == '~' ? SummonCells::isEmpty : predicate;
    }
}
