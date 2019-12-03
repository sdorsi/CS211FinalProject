package Game;

import java.awt.Point;

public final class MapPaths {
//	public static final int[] map1XPoints = {3, 603, 601, 73, 44, 180, 212, 592, 590, 354, 352, 554};
//	public static final int[] map1YPoints = {79, 73, 196, 223, 656, 649, 358, 362, 455, 485, 594, 610};
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
	
//	public static final int[] map2XPoints = {277, 562, 634, 114, 177, 557};
//	public static final int[] map2YPoints = {1, 309, 75, 178, 566, 614};
	public static final Point[] map2 = {
			new Point(277, 1),
			new Point(562, 309),
			new Point(634, 75),
			new Point(114, 178),
			new Point(177, 566),
			new Point(557, 614)
	};
	
	/*
	public static void main(String[] args) {
		for(int i = 0; i < map2XPoints.length; i++) {
			System.out.println("new Point(" + map2XPoints[i] + ", " + map2YPoints[i] + "),");
		}
	}
	*/
}