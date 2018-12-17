package com.books.datasource;

import com.books.domain.TargetDateCreatorInterface;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class TargetDateCreator implements TargetDateCreatorInterface {
    @Override
    public LocalDateTime create() {
        return LocalDateTime.now();
    }
}
