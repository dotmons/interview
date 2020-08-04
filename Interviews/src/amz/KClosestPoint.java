package amz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class KClosestPoint {

	int x;
	int y;

	public KClosestPoint() {

		for (Point pp : getResult(getQuestionOne(), 2)) {
			// System.out.println(pp.getX() + ", " + pp.getY());
		}

		int[][] poit = kClosest(getQuestionTwo(), 2);

		System.out.println(poit);
	}

	public List<Point> getResult(List<Point> listkclose, int n) {

		Map<Double, Point> tmap = new TreeMap<Double, Point>();
		List<Point> result = new ArrayList<Point>();

		int count = 0;
		for (Point kclo : listkclose) {
			tmap.put(getCoordinates(kclo), kclo);
		}

		Iterator<Entry<Double, Point>> iterator = tmap.entrySet().iterator();
		while (iterator.hasNext() && n > count++) {
			Entry<Double, Point> entry = iterator.next();
			result.add(new Point(entry.getValue().getX(), entry.getValue().getY()));
		}
		return result;
	}

	Double getCoordinates(Point k) {

		return Math.sqrt(k.x * k.x + k.y * k.y);
	}

	Double getCoordinates(int x, int y) {

		return Math.sqrt(x * x + y * y);
	}

	public int[][] kClosest(int[][] points, int K) {

		Map<Double, Point> tmap = new TreeMap<Double, Point>();
		List<Point> result = new ArrayList<Point>();

		int mlenght = points.length;
		int nlenght = points[0].length;

		int[][] results = new int[mlenght][nlenght];

		int count = 0;
		int x = 0;
		int y = 0;
		int co = 0;

		for (int m = 0; m < mlenght; m++) {
			for (int n = 0; n < nlenght; n++) {

				x = points[m][n];
				if ((n % 2 != 0)) {
					y = points[m][n];
					
					System.out.println("x:"+x + " y:" + y);
					tmap.put(getCoordinates(x, y), new Point(x, y));
				}
			}

		}

		int m = 0;
		int n = 0;

		Iterator<Entry<Double, Point>> iterator = tmap.entrySet().iterator();
		while (iterator.hasNext() && K > count++) {
			Entry<Double, Point> entry = iterator.next();
			if (nlenght - 1 == n) {
				n = 0;
				m++;
			}
			//System.out.println(entry.getValue().getX() + "  :  " + entry.getValue().getY());
			// results[m][n++] = entry.getValue().getX();
			// results[m][n++] = entry.getValue().getY();
		}
		return results;
	}

	public List<Point> getQuestionOne() {
		Point pointer = new Point();
		List<Point> listkclose = new ArrayList<Point>();
		pointer.setX(3);
		pointer.setY(3);
		listkclose.add(pointer);
		pointer = new Point();
		pointer.setX(5);
		pointer.setY(-1);
		listkclose.add(pointer);
		pointer = new Point();
		pointer.setX(-2);
		pointer.setY(4);
		listkclose.add(pointer);
		return listkclose;

	}

	public int[][] getQuestionTwo() {

		int[][] point = new int[3][2];
		point[0][0] = 3;
		point[0][1] = 3;
		point[1][0] = 5;
		point[1][1] = -1;
		point[2][0] = -2;
		point[2][1] = 4;

		return point;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KClosestPoint KClosestPoint = new KClosestPoint();
	}

	class Point {
		int x;
		int y;

		public Point() {
		}

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

	}

}
