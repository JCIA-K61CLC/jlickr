package com.jcia.jlickr.service;

import org.apache.commons.io.FilenameUtils;

public class UploadImageService {
    public static String RenameFileUpload(String fileName){
        return FilenameUtils.getBaseName(fileName)+"_"+System.nanoTime()+"."+FilenameUtils.getExtension(fileName);
    }
}
