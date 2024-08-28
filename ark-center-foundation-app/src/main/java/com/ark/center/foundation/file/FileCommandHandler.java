package com.ark.center.foundation.file;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.ark.center.foundation.client.file.command.FileBatchUploadCommand;
import com.ark.center.foundation.infra.file.File;
import com.ark.center.foundation.infra.file.FileService;
import com.ark.component.exception.ExceptionFactory;
import com.ark.component.web.util.bean.BeanConvertor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileCommandHandler {

    private final FileService fileService;

    public void upload(FileBatchUploadCommand command) {
        List<File> files = BeanConvertor.copyList(command.getFiles(), File.class);
        fileService.saveBatch(files, 50);
    }

    /**
     * 根据逗号分隔的字符串中的文件 ID，批量删除文件。如果字符串为空或 null，将直接返回。如果字符串中表示文件 ID 的数量超过 50 个，将抛出 IllegalArgumentException。否则，将字符串列表中的每个 ID 解析为 Long 类型，排序后作为参数传递给 fileService 的 removeByIds 方法。
     *
     * @param ids 逗号分隔的文件 ID 字符串
     */
    public void delete(String ids) {
        List<String> split = StrUtil.split(ids, StrUtil.COMMA);
        if (CollUtil.isEmpty(split)) {
            return;
        }
        Assert.isTrue(split.size() <= 50,
                ExceptionFactory.userExceptionSupplier("一次最多只能删除 50 个文件"));

        List<Long> idList = split.stream()
                .map(Long::parseLong)
                .sorted()
                .toList();
        fileService.removeByIds(idList);
    }

}
