package io.github.setupminimal.sands.configuration;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {
	
	public static void init(File configFile) {
		boolean blockNormalSandSmelting = true;
		Configuration configuration = new Configuration(configFile);
		try {
			// Load the config and read in properties
			configuration.load();
			
			blockNormalSandSmelting = 
					configuration.get(Configuration.CATEGORY_GENERAL, 
							"blockNormalSandSmelting", 
							true, 
							"This will prevent furnaces from smelting sand into glass.").getBoolean(true);
		} catch (Exception ex) {
			// Log the exception
		} finally {
			// Save the configuration
			configuration.save();
		}
		
		if (blockNormalSandSmelting) {
			System.out.println("Sands will prevent furnaces from smelting sand.");
		}
		
	}

}
