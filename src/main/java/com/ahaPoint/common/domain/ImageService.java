package com.ahaPoint.common.domain;

import org.springframework.stereotype.Service;


public interface ImageService {
    Image saveImage(ImageCommand.Save save);
}
