package com.books.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
public class Items {
    @Getter
    String title;
    String titleKana;
    String subTitle;
    String subTitleKana;
    String seriesName;
    String seriesNameKana;
    String contents;
    String author;
    String authorKana;
    String publisherName;
    String size;
    String isbn;
    String itemCaption;
    String salesDate;
    String itemPrice;
    String listPrice;
    String discountRate;
    String discountPrice;
    String itemUrl;
    String affiliateUrl;
    String smallImageUrl;
    String mediumImageUrl;
    String largeImageUrl;
    String chirayomiUrl;
    String availability;
    String postageFlag;
    String limitedFlag;
    String reviewCount;
    String reviewAverage;
    String booksGenreId;

    public boolean isTargetMonthReleased(LocalDateTime localDateTime) {
        return YearMonth.from(localDateTime).equals(YearMonth.parse(salesDate, DateTimeFormatter.ofPattern("yyyy年MM月dd日")));
    }

    public LocalDateTime getSalesDate() {
        return LocalDate.parse(salesDate, DateTimeFormatter.ofPattern("yyyy年MM月dd日")).atTime(LocalTime.MIN);
    }
}
