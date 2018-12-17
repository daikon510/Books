package com.books.service;

import com.books.domain.BookSearchResponse;
import com.books.domain.GoogleCalendarRepositoryInterface;
import com.books.domain.RakutenBooksReferRepositoryInterface;
import com.books.domain.TargetDateCreatorInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookReleaseDateRegisterService {

    @Autowired
    private RakutenBooksReferRepositoryInterface rakutenBooksReferRepositoryInterface;
    @Autowired
    private TargetDateCreatorInterface targetDateCreatorInterface;
    @Autowired
    private GoogleCalendarRepositoryInterface googleCalendarRepositoryInterface;

    private final String PATH = "title.txt";

    public void register() {
        LocalDateTime targetDateTime = targetDateCreatorInterface.create();
        try {
            List<String> lines = Files.lines(Paths.get(PATH), StandardCharsets.UTF_8).collect(Collectors.toList());
            lines.forEach(
                    l -> {
                        BookSearchResponse bookSearchResponse = rakutenBooksReferRepositoryInterface.refer(l);
                        bookSearchResponse.getItems().forEach(
                                i -> {
                                    if (i.isTargetMonthReleased(targetDateTime)) {
                                        try {
                                            googleCalendarRepositoryInterface.insert(i.getTitle(), i.getSalesDate());
                                        } catch (GeneralSecurityException | IOException e) {
                                            e.printStackTrace();
                                        }
                                    }

                                }
                        );
                    }
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
