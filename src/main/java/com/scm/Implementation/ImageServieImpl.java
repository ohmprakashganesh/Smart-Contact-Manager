package com.scm.Implementation;

import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import com.scm.Services.ImageService;
import com.scm.helpers.AppConstants;

import groovyjarjarantlr4.v4.parse.ANTLRParser.finallyClause_return;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ImageServieImpl implements ImageService {

    private final Cloudinary cloudinary;

    @Override
    public String uploadImage(MultipartFile profileImg) {
        //save file in cloudinary using  cloudinary 

        String fileName= UUID.randomUUID().toString();
        //if want to change orignal name with unique filename use these
        try {
            //create array of file side 
            byte[] data= new byte[profileImg.getInputStream().available()];
            //add data in the array 
            profileImg.getInputStream().read(data);
            cloudinary.uploader().upload(data, ObjectUtils.asMap(
                "public_id",profileImg.getOriginalFilename()
                
            ));
            
       
       
        } catch (IOException e) {
            e.printStackTrace();
            return null;

        }


        return this.getUrlFromPublicId(fileName);
    }

    @Override
    public String getUrlFromPublicId(String publicId) {

        return cloudinary.url()
        .transformation(
            new Transformation<>()
            .width(AppConstants.imageWidth)
            .height(AppConstants.imageHeight)
            .crop(AppConstants.imageCrop)
        ).generate(publicId);
        
    }

    
    
}
