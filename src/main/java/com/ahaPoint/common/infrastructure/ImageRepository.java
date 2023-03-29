package com.ahaPoint.common.infrastructure;

import com.ahaPoint.common.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository  extends JpaRepository<Image, Long> {
}
