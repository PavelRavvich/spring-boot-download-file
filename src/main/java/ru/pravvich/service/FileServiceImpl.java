package ru.pravvich.service;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pravvich.repository.FileRepo;

import java.io.*;

@Component
public class FileServiceImpl implements FileService {

    private final FileRepo repo;

    @Autowired
    public FileServiceImpl(FileRepo repo) {
        this.repo = repo;
    }

    @Override
    public InputStream getFileStream(final String id) {


        InputStream input = null;

        try (InputStream data = repo.getFileAsStream("example.pdf")) {

            final byte[] bytes = IOUtils.toByteArray(data);
            input = new ByteArrayInputStream(bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }
}
