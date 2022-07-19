package net.azagwen.aza_utils;

import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Aza Utils");
	public static final String ID = "aza_utils";

	public static Identifier id(String path) {
		return new Identifier(ID, path);
	}

	@Override
	public void onInitialize(ModContainer mod) {
		BlockRegistry.init();
		ItemRegistry.init();

		LOGGER.info("Aza Utils ready 😳");
	}
}
