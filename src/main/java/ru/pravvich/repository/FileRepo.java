package ru.pravvich.repository;

import java.io.InputStream;

public interface FileRepo {
    InputStream getFileAsStream(String filename);
}
