package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public class Movie {
    @JsonProperty("Search")
    private List<Search> search;
    private int totalResults;
    @JsonProperty("Response")
    private Boolean response;

    public List<Search> getSearch() {
        return search;
    }

    public void setSearch(List<Search> search) {
        this.search = search;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public Boolean getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response.equals("True");
    }

    private static class Search {
        public String Title;
        public int Year;
        public String imdbID;
        public String Type;
        public String Poster;
    }
}
