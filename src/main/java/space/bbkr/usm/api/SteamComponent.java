package space.bbkr.usm.api;

import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;

public interface SteamComponent extends ComponentV3, AutoSyncedComponent {
	int getCalories();

	void setCalories(int calories);

	default void addCalories(int calories) {
		setCalories(Math.min(getMaxCalories(), getCalories() + calories));
	}

	int getFullCalories();

	int getMaxCalories();
}
