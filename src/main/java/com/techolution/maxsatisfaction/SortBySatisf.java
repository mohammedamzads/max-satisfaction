package com.techolution.maxsatisfaction;

import java.util.Comparator;

public class SortBySatisf implements Comparator<RestaurantVO>
{
    public int compare(RestaurantVO a, RestaurantVO b)
    {
        return b.getSatisfaction() - a.getSatisfaction();
    }
}
 