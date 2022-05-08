package test.usage.other;

import test.Assert;
import usage.other.HanoiTower;

public class HanoiTowerTest {

	public static void main(String[] args) {
		testFn();
	}
	
	public static void testFn() {
		Assert.equal(HanoiTower.fn(1), 1);
		Assert.equal(HanoiTower.fn(2), 3);
		Assert.equal(HanoiTower.fn(3), 7);
		Assert.equal(HanoiTower.fn(4), 15);
	}
}
