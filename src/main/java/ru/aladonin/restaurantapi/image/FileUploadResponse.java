package ru.aladonin.restaurantapi.image;

import lombok.Data;

@Data
public class FileUploadResponse {
    private final String name;
    private final String downloadUrl;
    private final long size;

    public FileUploadResponse(String name, String downloadUrl, long size) {
        this.name = name;
        this.downloadUrl = downloadUrl;
        this.size = size;
    }
}
