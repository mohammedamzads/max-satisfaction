package com.techolution.maxsatisfaction;

public class RestaurantVO implements Comparable<Integer> {

	int satisfaction;
	int timeTaken;
	int totalAvailableTime;
	int totalDishes;

	public int getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(int satisfaction) {
		this.satisfaction = satisfaction;
	}

	public int getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(int timeTaken) {
		this.timeTaken = timeTaken;
	}

	@Override
	public String toString() {
		return "RestaurantVO [satisfaction=" + satisfaction + ", timeTaken="
				+ timeTaken + "]";
	}

	public RestaurantVO(int satisfaction, int timeTaken) {
		super();
		this.satisfaction = satisfaction;
		this.timeTaken = timeTaken;
	}
	
	public RestaurantVO() {
	}

	public int getTotalAvailableTime() {
		return totalAvailableTime;
	}

	public void setTotalAvailableTime(int totalAvailableTime) {
		this.totalAvailableTime = totalAvailableTime;
	}

	public int getTotalDishes() {
		return totalDishes;
	}

	public void setTotalDishes(int totalDishes) {
		this.totalDishes = totalDishes;
	}

	@Override
	public int compareTo(Integer arg0) {
		return 0;
	}

}
