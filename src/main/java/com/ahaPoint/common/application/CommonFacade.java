package com.ahaPoint.common.application;

import com.ahaPoint.common.domain.Image;
import com.ahaPoint.common.domain.ImageCommand;
import com.ahaPoint.common.domain.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CommonFacade {

    private final ImageService imageService;

    // 이미지 저장
    public Image saveImage(ImageCommand.Save save) {
        return imageService.saveImage(save);
    }
}
