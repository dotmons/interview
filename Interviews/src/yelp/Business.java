package yelp;

public class Business {

	int id;
	double rating;
	boolean veganFriendly;
	int price;
	double distance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double d) {
		this.rating = d;
	}

	public boolean isVeganFriendly() {
		return veganFriendly;
	}

	public void setVeganFriendly(boolean veganFriendly) {
		this.veganFriendly = veganFriendly;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

}
