package com.forward.system.controller;

import com.forward.response.Result;
import com.forward.system.service.AliOssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description:
 * @Author : 王俊
 * @date :  2020/12/5
 */
@Api(value = "头像上传",tags = "头像管理接口")
@RestController("/oss")
@CrossOrigin
public class AliOssController {

    @Autowired
    private AliOssService ossService;

    @ApiOperation(value = "上传图片文件")
    @PostMapping("/uploadImgFile")
    public Result uploadImgFile(MultipartFile file){
        String s = ossService.upload(file);
        ossService.listFile();
        return Result.ok().data("url",s);
    }

    @ApiOperation(value = "删除上传替换之后的头像")
    @PostMapping("/deleteImgFile")
    public Result deleteImgFile(String file){
        file = "https://springboot-oss-test.oss-cn-beijing.aliyuncs.com/2020/12/05/39030cbd981b44ff99315f19c80dc8be.jpg";
        try {
            String[] splitFile = file.split(".com/");
            ossService.deleteFile(splitFile[1]);
            return Result.ok();
        }catch (Exception e){
            return Result.error();
        }
    }


}
