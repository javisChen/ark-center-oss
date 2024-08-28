package com.ark.center.foundation.infra.file;

import com.ark.center.foundation.infra.file.dao.FileMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class FileService extends ServiceImpl<FileMapper, File> {

}
