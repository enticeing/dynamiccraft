package com.chrmills.dynamiccraft;

import com.chrmills.dynamiccraft.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.apache.logging.log4j.Logger;

@Mod(modid = DynamicCraft.MOD_ID,
    name = DynamicCraft.MOD_NAME,
    version = DynamicCraft.MOD_VERSION,
    dependencies = "required-after:forge@[14.23.4.2759,)",
    useMetadata = true)
public class DynamicCraft {
    public static final String MOD_ID = "dynamiccraft";
    public static final String MOD_NAME = "DynamicCraft";
    public static final String MOD_VERSION = "0.0.1";

    @SidedProxy(clientSide = "com.chrmills.dynamiccraft.proxy.ClientProxy",
                serverSide = "com.chrmills.dynamiccraft.proxy.ServerProxy")
    public static CommonProxy commonProxy;

    @Mod.Instance
    public static DynamicCraft dynamicCraft;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        commonProxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        commonProxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        commonProxy.postInit(e);
    }
}
