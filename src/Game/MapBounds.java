package Game;

import java.awt.Polygon;

public final class MapBounds {
	// points for map 1 where troops cannot be placed
	private static final int[] map1XPoints = {1, 616, 644, 585, 105, 76, 63, 150, 179, 237, 590, 620, 586, 379, 376, 575, 574, 644, 644, 668, 667, 553, 552, 321, 313, 557, 573, 239, 209, 209, 31, 11, 32, 26, 55, 575, 584, 1};
	private static final int[] map1YPoints = {56, 50, 180, 222, 234, 283, 614, 622, 349, 312, 324, 401, 483, 499, 568, 574, 530, 533, 575, 575, 652, 650, 626, 620, 457, 427, 383, 386, 537, 678, 680, 539, 421, 229, 174, 174, 95, 106};
	public static final Polygon[] map1 = {new Polygon(map1XPoints, map1YPoints, map1XPoints.length)};

	// points for map 2 where troops cannot be placed
	private static final int[] map2XPointsA = {318, 401, 363, 666, 595, 525, 368, 449, 556, 603, 159, 209, 556, 558, 574, 576, 641, 642, 665, 665, 555, 553, 189, 135, 82, 323, 235};
	private static final int[] map2YPointsA = {1, 88, 42, 71, 335, 339, 152, 143, 263, 105, 197, 544, 591, 576, 575, 529, 530, 576, 576, 651, 648, 636, 601, 545, 154, 98, 1};
	private static final int[] map2XPointsB = {319, 350, 380, 389, 384, 425, 438, 491, 526, 592, 618, 620, 627, 606, 600, 557, 480, 435, 415, 373, 266, 241, 225, 243, 244, 231, 219, 221, 244};
	private static final int[] map2YPointsB = {201, 200, 218, 243, 292, 311, 332, 351, 380, 396, 412, 428, 431, 476, 506, 520, 523, 533, 533, 524, 475, 449, 402, 353, 320, 305, 273, 261, 232};
	public static final Polygon[] map2 = {new Polygon(map2XPointsA, map2YPointsA, map2XPointsA.length),
										new Polygon(map2XPointsB, map2YPointsB, map2XPointsB.length)};
}