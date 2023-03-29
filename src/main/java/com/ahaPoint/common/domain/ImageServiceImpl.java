package com.ahaPoint.common.domain;

import com.ahaPoint.common.infrastructure.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    @Override
    public Image saveImage(ImageCommand.Save save) {
        Image saveImage = ImageCommand.Save.toEntity(save);
        return imageRepository.save(saveImage);
    }
}
