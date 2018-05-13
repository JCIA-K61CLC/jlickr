package com.jcia.jlickr.service;

import org.apache.commons.io.FilenameUtils;

public class UploadImageService {
    public static String RenameFileUpload(String fileName, int idUser){
        return FilenameUtils.getBaseName(fileName)+"_"+ idUser +"_"+System.nanoTime()+"."+FilenameUtils.getExtension(fileName);
    }
}
