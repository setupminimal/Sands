package io.github.setupminimal.sands.handler;

import io.github.setupminimal.sands.reference.Reference;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ConfigurationHandler {

	public static Configuration configuration;
	public static boolean blockNormalSandSmelting = true;

	public static void init(File configFile) {
		if (configuration == null) {
			configuration = new Configuration(configFile);
			loadConfiguration();
		}

	}

	@SubscribeEvent
	public void onConfigChangedEvent(ConfigChangedEvent event) {
		if (event.modID.equalsIgnoreCase(Reference.MOD_ID)) {
			// Resync configs
			loadConfiguration();
		}
	}

	private static void loadConfiguration() {
		blockNormalSandSmelting = configuration.get(
				Configuration.CATEGORY_GENERAL, "blockNormalSandSmelting",
				true,
				"This will prevent furnaces from smelting sand into glass.")
				.getBoolean(true);

		// Save the configuration
		if (configuration.hasChanged()) {
			configuration.save();
		}

	}

}
