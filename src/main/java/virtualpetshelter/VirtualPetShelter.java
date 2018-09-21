package virtualpetshelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	Map<String, VirtualPet> pets = new HashMap<String, VirtualPet>();

	public void admitPet(VirtualPet newPet) {
		pets.put(newPet.getName(), newPet);
	}

	public VirtualPet getPet(String name) {
		return pets.get(name);
	}

	public void adopt(String name) {
		pets.remove(name);
	}

	public void feedPets() {
		for (VirtualPet current : pets.values()) {
			current.feed();
		}
	}

	public void waterPets() {
		for (VirtualPet current : pets.values()) {
			current.giveWater();
		}
	}

	public void playWith(String name) {
		pets.get(name).play();
	}

	public void tick(int ticks) {
		for (VirtualPet current : pets.values()) {
			current.tick(ticks);
		}
	}

	public Collection<VirtualPet> getAllPets() {
		return pets.values();
	}

}
