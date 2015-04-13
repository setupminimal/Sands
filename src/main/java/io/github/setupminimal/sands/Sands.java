package io.github.setupminimal.sands;

import io.github.setupminimal.sands.handler.ConfigurationHandler;
import io.github.setupminimal.sands.proxy.IProxy;
import io.github.setupminimal.sands.reference.Reference;
import io.github.setupminimal.sands.utility.LogHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(name=Reference.MOD_NAME, modid=Reference.MOD_ID, version=Reference.MOD_VERSION,
		guiFactory=Reference.GUI_FACTORY_CLASS)
public class Sands {
	
	@Mod.Instance(Reference.MOD_ID)
	public static Sands instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS,
			serverSide = Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// Network handling, configuration file, register blocks and items
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		LogHelper.info("Preinitialization complete!");
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		// GUIs, crafting recipes, tile entities, event handlers
		LogHelper.info("Initialization complete!");
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// Cleanup, wrapup
		LogHelper.info("Postinitialization complete!");
	}

}
