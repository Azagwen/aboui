package net.azagwen.aza_utils;

import net.azagwen.aza_utils.registry.GroupedRegistryHolder;
import net.azagwen.aza_utils.registry.Registrar;
import net.azagwen.aza_utils.registry.RegistryHolder;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.DyeColor;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {
    private static final Registrar<Item> ITEMS = new Registrar<>(Registry.ITEM, Main::id);
    public static final RegistryHolder<Item> TEST_BLOCK = new RegistryHolder<>(ITEMS, "test_block", () -> new BlockItem(BlockRegistry.TEST_BLOCK.get(), new Item.Settings()));
    public static final GroupedRegistryHolder<Item, DyeColor> COLORED_TEST_BLOCK = new GroupedRegistryHolder<>(ITEMS, DyeColor.values(), "test_block", (v) -> () -> new BlockItem(BlockRegistry.COLORED_TEST_BLOCK.get(v), new Item.Settings()));

    public static void init() {
        ITEMS.check(Main.LOGGER);
    }
}
