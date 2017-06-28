package com.techolution.maxsatisfaction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppUtils {
	
	
	/**
	 * Parse the file 
	 * The expected format of the file
	 * [t][Number of items on menu]
	   [amount of satisfaction from eating dish 1][time taken for dish 1]
       [amount of satisfaction from dish 2][time taken for dish 2]
	 * @param file object
	 * @return List of the Restaurant VOs
	 * @throws IOException
	 */
	public static List<RestaurantVO> parseInput(File file) throws IOException {

		RestaurantVO restaurantVO = null;
		String[] tempArray;
		List<RestaurantVO> retList = new ArrayList<RestaurantVO>();
		boolean isFirstElement = true;

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				// process the line.
				line = line.replace(']', ' ');
				tempArray = line.split("\\[");

				if (tempArray.length >= 3) {
					if (isFirstElement) {
						isFirstElement = false;
						restaurantVO = new RestaurantVO();
						restaurantVO.setTotalAvailableTime(Integer
								.parseInt(tempArray[1].trim()));
						restaurantVO.setTotalDishes(Integer
								.parseInt(tempArray[2].trim()));
						retList.add(restaurantVO);
					} else {
						restaurantVO = new RestaurantVO(
								Integer.parseInt(tempArray[1].trim()),
								Integer.parseInt(tempArray[2].trim()));
						retList.add(restaurantVO);
					}
				}

			}
		}
		return retList;

	}

	public static void findMaxSatisfaction() throws IOException {

		List<RestaurantVO> lstRestaurantVOs = parseInput(new File(
				"c:\\input\\input.txt"));

		RestaurantVO restaurantVO = lstRestaurantVOs.remove(0);
		int totalAvailableTime = restaurantVO.getTotalAvailableTime();

		Collections.sort(lstRestaurantVOs, new SortBySatisf());

		System.out.println(lstRestaurantVOs);

		for (RestaurantVO restaurantVOTemp : lstRestaurantVOs) {

			if (restaurantVOTemp.getTimeTaken() <= totalAvailableTime) {
				System.out.println("Max satisfaction time---->>"
						+ restaurantVOTemp.getSatisfaction());
				break;
			}

		}
	}

	/*public static void main(String[] s) throws IOException {

		findMaxSatisfaction();

	}*/

}
