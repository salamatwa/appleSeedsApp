package com.example.salam.androidappappleseeds;

import java.util.Set;
/**
 * Created by salam on 12/20/2017.
 */

public interface IHistoryRepository {


    /**
     * Saves a query to the search history
     *
     * @param query to save
     */
    void addSearchQuery(String query);

    /**
     * Get all the added search history
     *
     * @return Set of all saved searches
     */
    Set<String> getSearchHistory();
}
