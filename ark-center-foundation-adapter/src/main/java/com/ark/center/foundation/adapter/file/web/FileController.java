package com.ark.center.foundation.adapter.file.web;//package com.ark.center.oss.module.demo.controller;
import com.ark.center.foundation.client.file.command.FileBatchUploadCommand;
import com.ark.center.foundation.client.file.dto.FileDTO;
import com.ark.center.foundation.client.file.query.FileQuery;
import com.ark.center.foundation.file.FileCommandHandler;
import com.ark.center.foundation.file.FileQueryService;
import com.ark.component.dto.PageResponse;
import com.ark.component.dto.ServerResponse;
import com.ark.component.dto.SingleResponse;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.util.MimeType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "文件管理")
@RequestMapping("/v1/files")
@RestController
@Slf4j
@RequiredArgsConstructor
public class FileController {

    private final FileCommandHandler commandHandler;
    private final FileQueryService queryService;

    @Operation(summary = "上传文件")
    @PostMapping(value = "")
    public ServerResponse upload(@RequestBody @Validated FileBatchUploadCommand command) {
        commandHandler.upload(command);
        return ServerResponse.ok();
    }

    @Operation(summary = "删除文件", description = "删除文件支持批量，用\",\"号分隔）")
    @DeleteMapping(value = "")
    public ServerResponse delete(String ids) {
        commandHandler.delete(ids);
        return ServerResponse.ok();
    }

    @Operation(summary = "分页查询文件列表")
    @GetMapping(value = "")
    public PageResponse<FileDTO> queryPages(FileQuery query) {
        IPage<FileDTO> pages = queryService.queryPages(query);
        return PageResponse.of(pages);
    }

    @Operation(summary = "查询文件详情")
    @GetMapping(value = "/details")
    public SingleResponse<FileDTO> queryDetails(FileQuery query) {
        FileDTO details = queryService.queryDetails(query);
        return SingleResponse.ok(details);
    }

}
