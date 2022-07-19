package net.azagwen.aza_utils;

import net.azagwen.aza_utils.registry.GroupedRegistryHolder;
import net.azagwen.aza_utils.registry.Registrar;
import net.azagwen.aza_utils.registry.RegistryHolder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.DyeColor;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

public class BlockRegistry {
    private static final Registrar<Block> BLOCKS = new Registrar<>(Registry.BLOCK, Main::id);
    public static final RegistryHolder<Block> TEST_BLOCK = new RegistryHolder<>(BLOCKS, "test_block", () -> new Block(QuiltBlockSettings.of(Material.STONE)));
    public static final GroupedRegistryHolder<Block, DyeColor> COLORED_TEST_BLOCK = new GroupedRegistryHolder<>(BLOCKS, DyeColor.values(), "test_block", (v) -> () -> new Block(QuiltBlockSettings.of(Material.STONE)));

    public static void init() {
        BLOCKS.check(Main.LOGGER);
    }
}
