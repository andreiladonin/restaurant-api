package ru.aladonin.restaurantapi.image;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.aladonin.restaurantapi.utils.FileUtil;
import ru.aladonin.restaurantapi.utils.FileUtil;

import java.io.IOException;

@RestController
public class ImageController {

    @PostMapping("/uploadFile")
    public ResponseEntity<FileUploadResponse> upload(@RequestParam("file") MultipartFile multipartFile)
            throws IOException {
        String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        long size = multipartFile.getSize();

        filename = FileUtil.saveFile(filename, multipartFile);
        FileUploadResponse response = new FileUploadResponse(filename, "/images/" + filename, size);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/images/{fileName}")
    public ResponseEntity<?> downloadFile(@PathVariable("fileName") String fileCode) {

        Resource resource = null;
        try {
            resource = FileUtil.getFileAsResource(fileCode);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }

        if (resource == null) {
            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        }

        String contentType = "image/png";
        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";

        ResponseEntity<Object> body = ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_TYPE, headerValue)
                .body(resource);
        return body;
    }
}
