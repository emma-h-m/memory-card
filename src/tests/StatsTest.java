package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import models.Stats;

public class StatsTest {

	@Test
	public void testAddScore() {
		Stats stats = new Stats();

		// easyCatHighScore
		stats.addScore("cat", "easy", 12);
		stats.addScore("cat", "easy", 10); // high score will be 10, as the lowest score is the high score in guessing
		stats.addScore("cat", "easy", 15);

		// hardCatHighScore
		stats.addScore("cat", "hard", 18);
		stats.addScore("cat", "hard", 12);
		stats.addScore("cat", "hard", 15);

		// easyCarHighScore
		stats.addScore("car", "easy", 9);
		stats.addScore("car", "easy", 8);

		// hardCarHighScore
		stats.addScore("car", "hard", 20);
		stats.addScore("car", "hard", 14);
		stats.addScore("car", "hard", 1000);

		// easyGalaxyHighScore
		stats.addScore("galaxy", "easy", 30);
		stats.addScore("galaxy", "easy", 20);
		stats.addScore("galaxy", "easy", 20);

		// hardGalaxyHighScore
		stats.addScore("galaxy", "hard", 20);
		stats.addScore("galaxy", "hard", 18);
		stats.addScore("galaxy", "hard", 190);

		assertEquals(10, stats.getEasyCatHighScore());
		assertEquals(12, stats.getHardCatHighScore());
		assertEquals(8, stats.getEasyCarHighScore());
		assertEquals(14, stats.getHardCarHighScore());
		assertEquals(20, stats.getEasyGalaxyHighScore());
		assertEquals(18, stats.getHardGalaxyHighScore());
	}

	@Test
	public void testAverages() {
		Stats stats = new Stats();

		// easyCatAvg
		stats.addScore("cat", "easy", 10);
		stats.addScore("cat", "easy", 15);

		// hardCatAvg
		stats.addScore("cat", "hard", 12);
		stats.addScore("cat", "hard", 14);

		// easyCarAvg
		stats.addScore("car", "easy", 8);
		stats.addScore("car", "easy", 3);
		stats.addScore("car", "easy", 9);

		// hardCarAvg
		stats.addScore("car", "hard", 14);
		stats.addScore("car", "hard", 19);

		// easyGalaxyAvg
		stats.addScore("galaxy", "easy", 20);
		stats.addScore("galaxy", "easy", 21);
		stats.addScore("galaxy", "easy", 0);

		// hardGalaxyAvg
		stats.addScore("galaxy", "hard", 18);
		stats.addScore("galaxy", "hard", 10);
		stats.addScore("galaxy", "hard", 8);
		stats.addScore("galaxy", "hard", 4);

		assertEquals(12, stats.getEasyCatAvg(), 0.001);
		assertEquals(13, stats.getHardCatAvg(), 0.001);
		assertEquals(6, stats.getEasyCarAvg(), 0.001);
		assertEquals(16, stats.getHardCarAvg(), 0.001);
		assertEquals(13, stats.getEasyGalaxyAvg(), 0.001);
		assertEquals(10, stats.getHardGalaxyAvg(), 0.001);
	}
}
