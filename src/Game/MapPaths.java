package Game;

import java.awt.Point;

public final class MapPaths {
//	public static final int[] map1XPoints = {3, 603, 601, 73, 44, 180, 212, 592, 590, 354, 352, 554};
//	public static final int[] map1YPoints = {79, 73, 196, 223, 656, 649, 358, 362, 455, 485, 594, 610};
	// the path for which the enemies take for map 1
	public static final Point[] map1 = {
			new Point(3, 79),
			new Point(603, 73),
			new Point(601, 196),
			new Point(73, 223),
			new Point(44, 656),
			new Point(180, 649),
			new Point(212, 358),
			new Point(592, 362),
			new Point(590, 455),
			new Point(354, 485),
			new Point(352, 594),
			new Point(554, 610)
	};
	
	// the path for which the enemies take for map 2
//	public static final int[] map2XPoints = {277, 562, 634, 114, 177, 557};
//	public static final int[] map2YPoints = {1, 309, 75, 178, 566, 614};
	public static final Point[] map2 = {
			new Point(277, 1), // start point
			new Point(341, 78),
			new Point(428, 175),
			new Point(503, 266),
			new Point(562, 309), // second
			new Point(590, 253),
			new Point(615, 174),
			new Point(628, 117),
			new Point(634, 75), // third
			new Point(524, 92),
			new Point(399, 116),
			new Point(300, 138),
			new Point(178, 151),
			new Point(114, 178), // fourth
			new Point(129, 273),
			new Point(136, 376),
			new Point(154, 494),
			new Point(177, 566), // fifth
			new Point(277, 587),
			new Point(358, 593),
			new Point(446, 602),
			new Point(557, 614) // base
	};
}