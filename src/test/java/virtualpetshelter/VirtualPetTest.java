package virtualpetshelter;

import org.junit.Assert;
import org.junit.Test;

public class VirtualPetTest {
	//this is slightly altered, but the original tests
	@Test
	public void shouldChangeWithTick() {
		VirtualPet underTest = new VirtualPet("Kitty the Cat", "");
		underTest.tick(1);
		Assert.assertEquals(1, underTest.hunger);
	}
	
	@Test
	public void shouldStillChangeWithTick() {
		VirtualPet underTest = new VirtualPet("Kitty the Cat", "");
		underTest.tick(1);
		underTest.tick(1);
		Assert.assertEquals(2, underTest.hunger);
	}
	
	@Test
	public void shouldRepeatTick() {
		VirtualPet underTest = new VirtualPet("Kitty the Cat", "");
		underTest.tick(2);
		Assert.assertEquals(2, underTest.hunger);
	}
	
	@Test
	public void shouldFeed() {
		VirtualPet underTest = new VirtualPet("Kitty the Cat", "");
		underTest.tick(20);
		underTest.feed();
		Assert.assertEquals(5, underTest.hunger);
	}
	
	@Test
	public void shouldStillFeed() {
		VirtualPet underTest = new VirtualPet("Kitty the Cat", "");
		underTest.tick(30);
		underTest.feed();
		Assert.assertEquals(15, underTest.hunger);
	}
	
	@Test
	public void shouldNotDropBelowZero() {
		VirtualPet underTest = new VirtualPet("Kitty the Cat", "");
		underTest.feed();
		underTest.tick(1);
		Assert.assertEquals(0, underTest.hunger);
	}
	
	//after this, all new tests
	@Test
	public void shouldGetName() {
		VirtualPet underTest = new VirtualPet("Kitty the Cat", "Calico kitten");
		Assert.assertEquals("Kitty the Cat", underTest.getName());
	}
	
	@Test
	public void shouldGetDesc() {
		VirtualPet underTest = new VirtualPet("Kitty the Cat", "Calico kitten");
		Assert.assertEquals("Calico kitten", underTest.getDesc());
	}
	
	@Test
	public void shouldGetHunger() {
		VirtualPet underTest = new VirtualPet("Kitty the Cat", "Calico kitten", 22, 20, 21);
		Assert.assertEquals(22, underTest.getHunger());
	}
	
	@Test
	public void shouldGetThirst() {
		VirtualPet underTest = new VirtualPet("Kitty the Cat", "Calico kitten", 22, 20, 21);
		Assert.assertEquals(20, underTest.getThirst());
	}

	@Test
	public void shouldGetBoredom() {
		VirtualPet underTest = new VirtualPet("Kitty the Cat", "Calico kitten", 22, 20, 21);
		Assert.assertEquals(21, underTest.getBoredom());
	}
}
