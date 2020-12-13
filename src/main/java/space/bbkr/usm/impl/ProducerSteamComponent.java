package space.bbkr.usm.impl;

import space.bbkr.usm.api.SteamComponent;

import net.minecraft.nbt.CompoundTag;

public class ProducerSteamComponent implements SteamComponent {
	private final int fullCalories;
	private int calories;

	public ProducerSteamComponent(int fullCalories) {
		this.fullCalories = fullCalories;
	}

	@Override
	public int getCalories() {
		return calories;
	}

	@Override
	public void setCalories(int calories) {
		this.calories = Math.min(calories, fullCalories);
	}

	@Override
	public int getFullCalories() {
		return fullCalories;
	}

	@Override
	public int getMaxCalories() {
		return fullCalories;
	}

	@Override
	public void readFromNbt(CompoundTag tag) {
		this.calories = tag.getInt("Calories");
	}

	@Override
	public void writeToNbt(CompoundTag tag) {
		tag.putInt("Calories", calories);
	}
}
