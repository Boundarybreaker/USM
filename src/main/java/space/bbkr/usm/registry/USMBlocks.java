package space.bbkr.usm.registry;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Supplier;

import space.bbkr.usm.USM;
import space.bbkr.usm.block.LowPressureBoilerBlock;
import space.bbkr.usm.block.entity.LowPressureBoilerBlockEntity;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;

public class USMBlocks {

	public static final Block COPPER_BLOCK = register("copper_block", new Block(FabricBlockSettings.of(Material.METAL).hardness(3.5F).breakByTool(FabricToolTags.PICKAXES)), USM.USM_GROUP);
	public static final Block ZINC_BLOCK = register("zinc_block", new Block(FabricBlockSettings.of(Material.METAL).hardness(1.5F).breakByTool(FabricToolTags.PICKAXES)), USM.USM_GROUP);
	public static final Block BRASS_BLOCK = register("brass_block", new Block(FabricBlockSettings.of(Material.METAL).hardness(4F).breakByTool(FabricToolTags.PICKAXES)), USM.USM_GROUP);
	public static final Block STEEL_BLOCK = register("steel_block", new Block(FabricBlockSettings.of(Material.METAL).hardness(5F).breakByTool(FabricToolTags.PICKAXES)), USM.USM_GROUP);
	public static final Block COPPER_ORE = register("copper_ore", new Block(FabricBlockSettings.of(Material.STONE).strength(2.5F).breakByTool(FabricToolTags.PICKAXES, 2)), USM.USM_GROUP);
	public static final Block MALACHITE_ORE = register("malachite_ore", new Block(FabricBlockSettings.of(Material.STONE).strength(2.5F).breakByTool(FabricToolTags.PICKAXES, 2)), USM.USM_GROUP);
	public static final Block SPHALERITE_ORE = register("sphalerite_ore", new Block(FabricBlockSettings.of(Material.STONE).strength(2.5F).breakByTool(FabricToolTags.PICKAXES, 2)), USM.USM_GROUP);
	public static final Block LOW_PRESSURE_BOILER = register("low_pressure_boiler", new LowPressureBoilerBlock(FabricBlockSettings.of(Material.METAL).breakByTool(FabricToolTags.PICKAXES).hardness(3.5F)), USM.USM_GROUP);
	public static final BlockEntityType<LowPressureBoilerBlockEntity> LOW_PRESSURE_BOILER_BE = register("low_pressure_boiler", LowPressureBoilerBlockEntity::new, LOW_PRESSURE_BOILER);

	public static void init() {

	}

	private static Block register(String name, Block block) {
		return Registry.register(Registry.BLOCK, new Identifier(USM.MODID, name), block);
	}

	private static Block register(String name, Block block, ItemGroup group) {
		Registry.register(Registry.ITEM, new Identifier(USM.MODID, name), new BlockItem(block, new Item.Settings().group(group)));
		return register(name, block);
	}

	private static <T extends BlockEntity> BlockEntityType<T> register(String name, Supplier<T> beSupplier, Block... blocks) {
		return Registry.register(
				Registry.BLOCK_ENTITY_TYPE,
				new Identifier(USM.MODID, name),
				new BlockEntityType<>(beSupplier, new HashSet<>(Arrays.asList(blocks)), null)
		);
	}
}
