package com.books.datasource;

import com.books.domain.BookSearchResponse;
import com.books.domain.RakutenBooksReferRepositoryInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class RakutenBooksReferRepositoryJson implements RakutenBooksReferRepositoryInterface {

    private static final String URL = "https://app.rakuten.co.jp/services/api/BooksBook/Search/20170404";

    @Override
    public BookSearchResponse refer(final String title) {
        Map<String, String> params = new HashMap<>();
        params.put("applicationId", "アプリケーションID");
        params.put("title", title);
        params.put("formatVersion", "2");
        params.put("sort", "-releaseDate");
        params.put("size", "9");
        params.put("hits", "3");
        StringBuffer buffer = new StringBuffer();
        params.forEach((key, value) -> buffer.append("&").append(String.format("%s={%s}", key, key)));
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(String.format("%s?%s", URL, buffer.toString()), String.class, params);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(response);
        BookSearchResponse bookSearchResponse = null;  //todo:NULL消す
        try {
            bookSearchResponse = mapper.readValue(response, BookSearchResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookSearchResponse;
    }
}