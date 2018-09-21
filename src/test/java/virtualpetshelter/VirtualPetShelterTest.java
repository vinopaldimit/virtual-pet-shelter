package virtualpetshelter;

import static org.hamcrest.Matchers.containsInAnyOrder;

import org.junit.Assert;
import org.junit.Test;

public class VirtualPetShelterTest {

	@Test
	public void shouldAddPet() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.admitPet(new VirtualPet("Kitty the Cat", "Calico kitten", 22, 20, 21));
		Assert.assertEquals(1, underTest.pets.size());
	}

	@Test
	public void shouldAddCorrectPet() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.admitPet(new VirtualPet("Kitty the Cat", "Calico kitten", 22, 20, 21));
		Assert.assertEquals(22, underTest.pets.get("Kitty the Cat").getHunger());
	}

	@Test
	public void shouldGetPetWithName() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		VirtualPet catOne = new VirtualPet("Kitty the Cat", "Calico kitten", 22, 20, 21);
		VirtualPet catTwo = new VirtualPet("Marty", "Black kitten", 20, 23, 20);
		underTest.admitPet(catOne);
		underTest.admitPet(catTwo);
		Assert.assertEquals("Black kitten", underTest.getPet("Marty").getDesc());
	}

	@Test
	public void shouldAdoptPet() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		VirtualPet catOne = new VirtualPet("Kitty the Cat", "Calico kitten", 22, 20, 21);
		VirtualPet catTwo = new VirtualPet("Marty", "Black kitten", 20, 23, 20);
		underTest.admitPet(catOne);
		underTest.admitPet(catTwo);
		underTest.adopt("Marty");
		Assert.assertEquals(1, underTest.pets.size());
	}

	@Test
	public void shouldFeedPets() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		VirtualPet catOne = new VirtualPet("Kitty the Cat", "Calico kitten", 22, 20, 21);
		VirtualPet catTwo = new VirtualPet("Marty", "Black kitten", 20, 23, 20);
		underTest.admitPet(catOne);
		underTest.admitPet(catTwo);
		underTest.feedPets();
		Assert.assertEquals(7, underTest.getPet("Kitty the Cat").getHunger());
	}

	@Test
	public void shouldWaterPets() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		VirtualPet catOne = new VirtualPet("Kitty the Cat", "Calico kitten", 22, 20, 21);
		VirtualPet catTwo = new VirtualPet("Marty", "Black kitten", 20, 23, 20);
		underTest.admitPet(catOne);
		underTest.admitPet(catTwo);
		underTest.waterPets();
		Assert.assertEquals(5, underTest.getPet("Kitty the Cat").getThirst());
	}

	@Test
	public void shouldPlayWithPet() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		VirtualPet catOne = new VirtualPet("Kitty the Cat", "Calico kitten", 22, 20, 21);
		VirtualPet catTwo = new VirtualPet("Marty", "Black kitten", 20, 23, 20);
		underTest.admitPet(catOne);
		underTest.admitPet(catTwo);
		underTest.playWith("Marty");
		Assert.assertEquals(5, underTest.getPet("Marty").getBoredom());
	}

	@Test
	public void shouldChangeWithTick() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		VirtualPet catOne = new VirtualPet("Kitty the Cat", "Calico kitten", 22, 20, 21);
		VirtualPet catTwo = new VirtualPet("Marty", "Black kitten", 20, 23, 20);
		underTest.admitPet(catOne);
		underTest.admitPet(catTwo);
		underTest.tick(2);
		Assert.assertEquals(22, underTest.getPet("Marty").getBoredom());
	}

	@Test
	public void shouldReturnCollection() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		VirtualPet catOne = new VirtualPet("Kitty the Cat", "Calico kitten", 22, 20, 21);
		VirtualPet catTwo = new VirtualPet("Marty", "Black kitten", 20, 23, 20);
		underTest.admitPet(catOne);
		underTest.admitPet(catTwo);
		Assert.assertThat(underTest.getAllPets(), containsInAnyOrder(catOne, catTwo));
	}
}
