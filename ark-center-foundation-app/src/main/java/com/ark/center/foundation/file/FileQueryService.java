package com.ark.center.foundation.file;

import com.ark.center.foundation.client.file.dto.FileDTO;
import com.ark.center.foundation.client.file.query.FileQuery;
import com.ark.center.foundation.infra.config.FoundationProperties;
import com.ark.center.foundation.infra.file.File;
import com.ark.center.foundation.infra.file.FileService;
import com.ark.component.web.util.bean.BeanConvertor;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileQueryService {

    private final FileService fileService;
    private final FoundationProperties foundationProperties;

    public IPage<FileDTO> queryPages(FileQuery query) {
        return fileService.lambdaQuery()
                .eq(query.getGroupId() != null, File::getGroupId, query.getGroupId())
                .page(new Page<>(query.getCurrent(), query.getSize()))
                .convert(file -> {
                    FileDTO dto = BeanConvertor.copy(file, FileDTO.class);
                    dto.setUri(foundationProperties.getFile().getEndPoint() + dto.getUri());
                    return dto;
                });
    }

    public FileDTO queryDetails(FileQuery query) {
        File file = fileService.getById(query.getId());
        return BeanConvertor.copy(file, FileDTO.class);
    }

}
