package space.bbkr.usm.registry;

import org.lwjgl.system.CallbackI;
import space.bbkr.usm.USM;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class USMItems {
	public static final Item COPPER_INGOT = register("copper_ingot", new Item(new Item.Settings().group(USM.USM_GROUP)));
	public static final Item COPPER_NUGGET = register("copper_nugget", new Item(new Item.Settings().group(USM.USM_GROUP)));
	public static final Item ZINC_INGOT = register("zinc_ingot", new Item(new Item.Settings().group(USM.USM_GROUP)));
	public static final Item ZINC_NUGGET = register("zinc_nugget", new Item(new Item.Settings().group(USM.USM_GROUP)));
	public static final Item BRASS_INGOT = register("brass_ingot", new Item(new Item.Settings().group(USM.USM_GROUP)));
	public static final Item BRASS_NUGGET = register("brass_nugget", new Item(new Item.Settings().group(USM.USM_GROUP)));
	public static final Item STEEL_INGOT = register("steel_ingot", new Item(new Item.Settings().group(USM.USM_GROUP)));
	public static final Item STEEL_NUGGET = register("steel_nugget", new Item(new Item.Settings().group(USM.USM_GROUP)));
	public static final Item MALACHITE_GEM = register("malachite_gem", new Item(new Item.Settings().group(USM.USM_GROUP)));
	public static final Item SPHALERITE_GEM = register("sphalerite_gem", new Item(new Item.Settings().group(USM.USM_GROUP)));

	public static void init() {

	}

	private static Item register(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(USM.MODID, name), item);
	}
}
