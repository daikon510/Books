package com.books.domain;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDateTime;

public interface GoogleCalendarRepositoryInterface {
    void insert(String title, LocalDateTime salesDate) throws GeneralSecurityException, IOException;
}
