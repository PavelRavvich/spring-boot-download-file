package ru.pravvich.repository;

import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * Author : Pavel Ravvich.
 * Created : 21/10/2017.
 */
@Component
public class FileRepoImpl implements FileRepo {

    @Override
    public InputStream getFileAsStream(final String filename) {
        return Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("download_example_data/" + filename);
    }
}
