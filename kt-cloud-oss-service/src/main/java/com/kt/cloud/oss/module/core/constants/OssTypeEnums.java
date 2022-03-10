package com.kt.cloud.oss.module.core.constants;

import lombok.Getter;

@Getter
public enum OssTypeEnums {

    MINIO("MINIO"),
    ALIYUN("ALIYUN");

    private final String value;

    OssTypeEnums(String value) {
        this.value = value;
    }

}
