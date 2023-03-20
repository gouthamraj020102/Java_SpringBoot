package com.jpasample.apicreation.Helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;

// import java.io.FileOutputStream;
// import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    // Static
    // public final String UPLOAD_DIR = "C:\\Users\\Gowtham
    // Raju\\Desktop\\SB_Projects\\relationships\\src\\main\\resources\\static\\image";

    // Dynamic
    public final String UPLOAD_DIR = new ClassPathResource("static/image").getFile().getAbsolutePath();

    public FileUploadHelper() throws IOException {

    }

    public boolean uploadfile(MultipartFile file) {
        boolean f = false;
        try {
            // InputStream i = file.getInputStream();
            // byte data[] = new byte[i.available()];
            // i.read(data);

            // //write
            // FileOutputStream fos = new
            // FileOutputStream(UPLOAD_DIR+"\\"+file.getOriginalFilename());
            // fos.write(data);

            // fos.flush();
            // fos.close();

            Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

}
