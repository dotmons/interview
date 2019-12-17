package hackerrank;

import java.util.*;

public class Distance {

	public Distance() {
		List<List<Integer>> allLocations = new ArrayList<List<Integer>>();
		List<Integer> values = new ArrayList<Integer>();

		values.add(1);
		values.add(-3);
		allLocations.add(new ArrayList<Integer>(values));
		values = new ArrayList<Integer>();
		values.add(1);
		values.add(2);
		allLocations.add(new ArrayList<Integer>(values));
		values = new ArrayList<Integer>();
		values.add(3);
		values.add(4);
		allLocations.add(new ArrayList<Integer>(values));
		values = new ArrayList<Integer>();

		nearesXsteakHouses(3, allLocations, 2);
	}

	@SuppressWarnings("unchecked")
	List<List<Integer>> nearesXsteakHouses(int totalSteakhouses, List<List<Integer>> allLocations, int numSteakHouses) {

		Map<List<Integer>, Double> map = new HashMap<List<Integer>, Double>();
		List<List<Integer>> genLocations = new ArrayList<List<Integer>>();
		
		for (List<Integer> ll : allLocations) {
			map.put(ll, verifyCloseSteak(ll.get(0), ll.get(1)));
		}
		
		
		
		Object steakHouseValue[] = map.entrySet().toArray();
		
		Arrays.sort(steakHouseValue, new Comparator<Object>() {
			public int compare(Object aa, Object bb){
				return (((Map.Entry<List<Integer>, Double>)aa).getValue().compareTo(((Map.Entry<List<Integer>, Double>) bb).getValue()));
			}
		});
		
		int counter = 0;
		for (Object selectedSteakHouse : steakHouseValue){
			if (++counter<=numSteakHouses){
				genLocations.add(((Map.Entry<List<Integer>, Double>)selectedSteakHouse).getKey());
				System.out.println("Sorted Steak House : " + ((Map.Entry<List<Integer>, Double>)selectedSteakHouse).getKey());	
			}
		}
		
		return genLocations;
	}

	Double verifyCloseSteak(int x, int y) {

		return Math.sqrt(x * x + y * y);
	}

	public static void main(String[] args) {
		new Distance();
	}

}
