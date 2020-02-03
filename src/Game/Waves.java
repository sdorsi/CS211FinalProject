package Game;

public class Waves {
	// shorthand variable created for easily making waves
	private static final EnemyOption b = EnemyOption.BRAWLER;
	private static final EnemyOption k = EnemyOption.KNIGHT;
	private static final EnemyOption t = EnemyOption.THIEF;
	private static final EnemyOption c = EnemyOption.CAVALRY;
	private static final EnemyOption d = EnemyOption.DRAGON;
	private static final EnemyOption w = EnemyOption.WAIT;
	
	// array used to hold the waves of enemies
	public static final EnemyOption[][] waves = {
			{b, w, w, w, w, b, w, w, w, w, b, w, w, w, w, b, w, w, w, w, b}, // 1
			{b, b, b, b, b, b, b, b, b, b}, // 2
			{b, b, b, b, b, k, k, k}, // 3
			{k, k, k, k, k}, // 4
			{b, b, b, b, b, b, b, b, b, b, k, k, k, k, k, k, k, k, k, k}, // 5
			{t, t, t, t, t}, // 6
			{b, b, b, k, k, k, t, t, t, c, c, c, d, d, d}, // 7
			{d, d, d, d, d}, // 8
			{c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c}, // 9
			{d, d, d, d, d, d, d, d, d, d}, // 10
	};
}