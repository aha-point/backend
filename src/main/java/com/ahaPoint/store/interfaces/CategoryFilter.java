package com.ahaPoint.store.interfaces;

import com.ahaPoint.store.domain.StoreCategory;
import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.Locale;

@Getter
@Data
public class CategoryFilter {
    private List<String> categories;
}
