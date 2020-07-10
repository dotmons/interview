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
		Point pointer = new Point();
		List<Point> listkclose = new ArrayList<Point>();
		pointer.setX(3);
		pointer.setY(3);
		listkclose.add(pointer);
		pointer = new Point();
		pointer.setX(5);
		pointer.setY(12);
		listkclose.add(pointer);
		pointer = new Point();
		pointer.setX(-2);
		pointer.setY(4);
		listkclose.add(pointer);
		pointer = new Point();
		pointer.setX(0);
		pointer.setY(5);
		listkclose.add(pointer);
		pointer = new Point();
		pointer.setX(9);
		pointer.setY(-4);
		listkclose.add(pointer);
		pointer = new Point();
		pointer.setX(-22);
		pointer.setY(6);
		listkclose.add(pointer);

		for (Point pp : getResult(listkclose, 4)){
			System.out.println(pp.getX() + ",  " + pp.getY());
		}

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
