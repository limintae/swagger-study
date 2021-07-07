package com.example.swagger.demo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Data
@Builder
@ToString
public class FileUploadResponse {

    private final String fileId;

}
