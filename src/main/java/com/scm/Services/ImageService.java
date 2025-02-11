package com.scm.Services;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    String uploadImage(MultipartFile profileImg, String fileName);
    String getUrlFromPublicId(String publicId);
    
}
