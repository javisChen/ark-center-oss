package com.ark.center.foundation.client.file.constants;

import lombok.Getter;

@Getter
public enum OssTypeEnum {

    MINIO("MINIO"),

    ALIYUN("ALIYUN");

    private final String value;

    OssTypeEnum(String value) {
        this.value = value;
    }

}
