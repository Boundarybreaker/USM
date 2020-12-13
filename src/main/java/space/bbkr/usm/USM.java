package space.bbkr.usm;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import space.bbkr.usm.registry.USMBlocks;
import space.bbkr.usm.registry.USMItems;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class USM implements ModInitializer {
	public static final String MODID = "usm";
	public static final Logger LOGGER = LogManager.getLogger(MODID);

	public static final ItemGroup USM_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "usm"), () -> new ItemStack(USMBlocks.LOW_PRESSURE_BOILER));

	@Override
	public void onInitialize() {
		USMBlocks.init();
		USMItems.init();
	}
}
