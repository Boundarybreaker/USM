package space.bbkr.usm.block.entity;

import space.bbkr.usm.registry.USMBlocks;
import space.bbkr.usm.registry.USMComponents;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.Tickable;

public class LowPressureBoilerBlockEntity extends BlockEntity implements Tickable {
	public LowPressureBoilerBlockEntity() {
		super(USMBlocks.LOW_PRESSURE_BOILER_BE);
	}

	@Override
	public void tick() {
		USMComponents.STEAM.get(this).addCalories(1);
	}
}
