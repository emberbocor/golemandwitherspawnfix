package io.github.emberbocor.golemandwitherspawnfix;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

@Mod(GolemandWitherSpawnFix.MODID)
public class GolemandWitherSpawnFix {
    public static final String MODID = "golemandwitherspawnfix";
    public static final Logger LOGGER = LogUtils.getLogger();

    public GolemandWitherSpawnFix(IEventBus modEventBus, ModContainer modContainer) {
    }
}
