package com.ahaPoint.store.interfaces;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
@Data
public class CategoryFilter {
    private List<String> categories;
    private String keyWord;
}
