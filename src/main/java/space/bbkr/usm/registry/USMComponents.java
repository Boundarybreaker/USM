package space.bbkr.usm.registry;

import dev.onyxstudios.cca.api.v3.block.BlockComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.block.BlockComponentInitializer;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import space.bbkr.usm.USM;
import space.bbkr.usm.api.SteamComponent;
import space.bbkr.usm.block.entity.LowPressureBoilerBlockEntity;
import space.bbkr.usm.impl.ProducerSteamComponent;

import net.minecraft.util.Identifier;

public class USMComponents implements BlockComponentInitializer {
	public static final ComponentKey<SteamComponent> STEAM = ComponentRegistryV3.INSTANCE.getOrCreate(new Identifier(USM.MODID, "steam"), SteamComponent.class);

	@Override
	public void registerBlockComponentFactories(BlockComponentFactoryRegistry registry) {
		registry.registerFor(LowPressureBoilerBlockEntity.class, STEAM, be -> new ProducerSteamComponent(1600));
	}
}
