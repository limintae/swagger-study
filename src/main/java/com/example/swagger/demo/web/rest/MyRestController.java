package com.example.swagger.demo.web.rest;

import com.example.swagger.demo.dto.ApiResult;
import com.example.swagger.demo.dto.FileInfoResponse;
import com.example.swagger.demo.dto.FileUploadResponse;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import static com.example.swagger.demo.dto.ApiResult.succeed;

import java.io.IOException;

@RestController
@RequestMapping(value = "/file")
public class MyRestController {

    @GetMapping(value = "/{user}:search/{fileId}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "파일조회 API", notes = "파일을 조회 합니다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success"),
            @ApiResponse(code = 500,message = "Internal server error")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "사용자", required = true, paramType = "path", example = "lim"),
            @ApiImplicitParam(name = "fileId", value = "파일ID", required = true, paramType = "path", example = "aaa")
    })
    public ApiResult<FileInfoResponse> getSampleResponse(
            @PathVariable(value = "user") String user,
            @PathVariable(value = "fileId") String fileId
    ) {
        return succeed(FileInfoResponse.builder().fileId(fileId).filePath("/"+user+"/path/aaa_file.jpg").build());
    }

    @PutMapping(value = "/{user}:upload")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "파일업로드 API", notes = "파일을 업로드 합니다.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "created"),
            @ApiResponse(code = 500,message = "Internal server error")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "사용자", required = true, paramType = "path", example = "lim")
    })
    public ApiResult<FileUploadResponse> uploadFile(
            @PathVariable(value = "user") String user,
            @RequestParam(value = "file") MultipartFile file) throws IOException {
        byte[] fileToByte = file.getBytes();

        return succeed(FileUploadResponse.builder().fileId("aaa").build());
    }

}
