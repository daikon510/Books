package com.books.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
public class BookSearchResponse {
    String count;
    String page;
    String first;
    String last;
    String hits;
    String carrier;
    String pageCount;
    @Getter
    @JsonProperty("Items")
    List<Items> items;
    @JsonProperty("GenreInformation")
    List<String> genreInformation;

}
