package io.github.emberbocor.golemandwitherspawnfix;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;

public final class SummonCells {
    public static final TagKey<Block> SUMMON_IGNORED = TagKey.create(Registries.BLOCK,
            ResourceLocation.tryBuild(GolemAndWitherSpawnFix.MODID, "summon_ignored"));

    private SummonCells() {
    }

    public static boolean isEmpty(BlockInWorld cell) {
        BlockState state = cell.getState();
        return state.isAir()
                || !state.getBlock().hasDynamicShape()
                && state.getCollisionShape(cell.getLevel(), cell.getPos()).isEmpty()
                && !state.hasBlockEntity()
                && state.getFluidState().isEmpty()
                || state.is(SUMMON_IGNORED);
    }
}
