package com.ahaPoint.common.domain;

public interface ImageStore {
    Long saveImage(ImageCommand.Save input);
}
