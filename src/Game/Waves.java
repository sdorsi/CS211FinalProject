package Game;

public class Waves {
	private static final EnemyOption b = EnemyOption.BRAWLER;
	private static final EnemyOption k = EnemyOption.KNIGHT;
	private static final EnemyOption t = EnemyOption.THIEF;
	private static final EnemyOption c = EnemyOption.CAVALRY;
	private static final EnemyOption d = EnemyOption.DRAGON;
	
	public static final EnemyOption[][] waves = {
			{b, b, b, b, b}, // 1
			{b, b, b, b, b, b, b, b, b, b}, // 2
			{b, b, b, b, b, k, k, k}, // 3
			{k, k, k, k, k}, // 4
			{b, b, b, b, b, b, b, b, b, b, k, k, k, k, k, k, k, k, k, k}, // 5
			{t, t, t, t, t}, // 6
			{b, b, b, k, k, k, t, t, t, c, c, c, d, d, d}, // 7
			{d, d, d, d, d}, // 8
			{c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c, c}, // 9
			{d, d, d, d, d, d, d, d, d, d}, // 10
			{}, // 11
			{}, // 12
			{}, // 13
			{}, // 14
			{}, // 15
			{}, // 16
			{}, // 17
			{}, // 18
			{}, // 19
			{}, // 20
			{}, // 21
			{}, // 22
			{}, // 23
			{}, // 24
			{}, // 25
			{}, // 26
			{}, // 27
			{}, // 28
			{}, // 29
			{}, // 30
			{}, // 31
			{}, // 32
			{}, // 33
			{}, // 34
			{}, // 35
			{}, // 36
			{}, // 37
			{}, // 38
			{}, // 39
			{}, // 40
			{}, // 41
			{}, // 42
			{}, // 43
			{}, // 44
			{}, // 45
			{}, // 46
			{}, // 47
			{}, // 48
			{}, // 49
			{} // 50
	};
}