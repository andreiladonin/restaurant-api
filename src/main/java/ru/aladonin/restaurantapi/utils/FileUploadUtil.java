package ru.aladonin.restaurantapi.utils;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUploadUtil {
    private static final String UPLOADS = "uploads";

    public static String saveFile(String fileName, MultipartFile multipartFile)
            throws IOException {
        Path uploadPath = Paths.get(UPLOADS);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }


        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("COULD_NOT_SAVE_FILE: " + fileName, ioe);
        }
        return fileName;
    }

    static Path foundFile;
    public static Resource getFileAsResource(String fileName) throws IOException {


        Path dirPath = Paths.get(UPLOADS);

        Files.list(dirPath).forEach(file -> {
            if (file.getFileName().toString().startsWith(fileName)) {
                foundFile = file;
                return;
            }
        });

        if (foundFile != null) {
            return new UrlResource(foundFile.toUri());
        }

        return null;
    }
}
