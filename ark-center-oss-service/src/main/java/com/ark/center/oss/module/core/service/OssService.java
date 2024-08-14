package com.ark.center.oss.module.core.service;

import cn.hutool.core.collection.CollUtil;
import com.ark.center.oss.module.core.dto.OssUploadReqDTO;
import com.ark.center.oss.module.core.constants.OssTypeEnums;
import com.ark.center.oss.module.core.dto.OssUploadRespDTO;
import com.ark.component.exception.ExceptionFactory;
import com.ark.component.oss.OssStrategy;
import com.ark.component.oss.OssType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class OssService {

    private Map<OssType, OssStrategy> strategyHolder;


    public OssService(List<OssStrategy> ossStrategies) {
        if (CollUtil.isNotEmpty(ossStrategies)) {
            strategyHolder = new HashMap<>(ossStrategies.size());
            for (OssStrategy ossStrategy : ossStrategies) {
                strategyHolder.put(ossStrategy.ossType(), ossStrategy);
            }
        }
    }

    public OssUploadRespDTO upload(OssUploadReqDTO ossUploadDTO) {
        checkBeforeUpload(ossUploadDTO);
        OssStrategy storageService = getStrategy(ossUploadDTO);
        if (storageService == null) {
            throw ExceptionFactory.userException("无效的OSS类型");
        }
        MultipartFile file = ossUploadDTO.getFile();
        String ossUrl = "";
        try {
            ossUrl = storageService.put(ossUploadDTO.getBucket(), ossUploadDTO.getFileName(), file.getInputStream());
        } catch (Exception e) {
            log.error("上传失败", e);
            throw ExceptionFactory.sysException("上传失败", e);
        }
        return toOssUploadRespDTO(ossUploadDTO.getFileName());
    }

    private void checkBeforeUpload(OssUploadReqDTO ossUploadDTO) {
        if (StringUtils.isEmpty(ossUploadDTO.getType())) {
            ossUploadDTO.setType(OssTypeEnums.MINIO.getValue());
        }
        if (StringUtils.isEmpty(ossUploadDTO.getBucket())) {
            ossUploadDTO.setBucket("default");
        }
    }

    private OssStrategy getStrategy(OssUploadReqDTO ossUploadDTO) {
        String type = ossUploadDTO.getType();
        return strategyHolder.get(OssType.valueOf(type));
    }

    private OssUploadRespDTO toOssUploadRespDTO(String ossUrl) {
        OssUploadRespDTO respDTO = new OssUploadRespDTO();
        respDTO.setUrl(ossUrl);
        return respDTO;
    }
}
