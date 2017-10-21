package ru.pravvich.service;

import java.io.InputStream;

public interface FileService {
    InputStream getFileStream(String id);
}
