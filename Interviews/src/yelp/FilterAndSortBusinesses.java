package yelp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FilterAndSortBusinesses {

	FilterAndSortBusinesses() {

		Business business = new Business();
		List<Business> businesses = new ArrayList<>();

		business.setId(1);
		business.setRating(4.0);
		business.setVeganFriendly(true);
		business.setPrice(4);
		business.setDistance(10.0);
		businesses.add(business);

		business = new Business();
		business.setId(2);
		business.setRating(2.5);
		business.setVeganFriendly(false);
		business.setPrice(2);
		business.setDistance(5.0);
		businesses.add(business);

		business = new Business();
		business.setId(3);
		business.setRating(4.5);
		business.setVeganFriendly(false);
		business.setPrice(1);
		business.setDistance(1.0);
		businesses.add(business);

		business = new Business();
		business.setId(4);
		business.setRating(3.0);
		business.setVeganFriendly(true);
		business.setPrice(2);
		business.setDistance(3.4);
		businesses.add(business);

		business = new Business();
		business.setId(5);
		business.setRating(4.5);
		business.setVeganFriendly(true);
		business.setPrice(1);
		business.setDistance(6.3);
		businesses.add(business);

		business = new Business();
		business.setId(6);
		business.setRating(3.5);
		business.setVeganFriendly(true);
		business.setPrice(2);
		business.setDistance(1.2);
		businesses.add(business);

		List<Integer> result = new ArrayList<>();
		result.add(3);
		result.add(6);
		result.add(4);
		result.add(2);

		System.out.println(isAssert(result, filterAndSortBusinesses(businesses, false, null, (float) 6.0)));
	}

	public static List<Integer> filterAndSortBusinesses(List<Business> businesses, boolean onlyVeganFriendly,
			Integer maxPrice, Float maxDistance) {

		List<Integer> output = new ArrayList<Integer>();
		List<Business> result = new ArrayList<Business>();

		if (onlyVeganFriendly) {
			for (Business busi : businesses) {
				if (busi.isVeganFriendly()) {
					output.add(busi.getId());
				}
			}
		} else if (maxPrice != null && maxDistance == null) {

			for (Business busi : businesses) {
				if (busi.getPrice() < maxPrice) {
					result.add(busi);
				}
			}
			for (Business busi : sortBusinesses(result)) {
				output.add(busi.getId());
			}

		} else if (maxPrice == null && maxDistance != null) {

			for (Business busi : businesses) {
				if (busi.getDistance() < maxDistance) {
					result.add(busi);
				}
			}
			for (Business busi : sortBusinesses(result)) {
				output.add(busi.getId());
			}

		} else {

			for (Business busi : sortBusinesses(businesses)) {
				output.add(busi.getId());
			}
		}

		Collections.reverse(output);
		return output;
	}

	public static List<Business> sortBusinesses(List<Business> businesses) {
		Collections.sort(businesses, new Comparator<Business>() {

			@Override
			public int compare(Business a, Business b) {
				return Double.compare(a.getRating(), b.getRating());
			}
		});
		return businesses;
	}

	public static void main(String[] args) {
		FilterAndSortBusinesses filterAndSortBusinesses = new FilterAndSortBusinesses();

	}

	boolean isAssert(List<Integer> a, List<Integer> b) {
		return a.equals(b);
	}

}
