package ru.pravvich.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.pravvich.service.FileService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

@RestController
public class DownloadFilesController {

    private final static Logger logger = Logger.getLogger(String.valueOf(DownloadFilesController.class));

    private final FileService service;

    @Autowired
    public DownloadFilesController(FileService service) {
        this.service = service;
    }

    @RequestMapping("/download")
    public void getFile(@RequestParam(name = "id", required = false) String id,
                        HttpServletResponse resp) {

        resp.setContentType("application/pdf");

        // get your file as InputStream
        try (final InputStream input = service.getFileStream(id)) {

            // copy it to resp's OutputStream
            org.apache.commons.io.IOUtils.copy(input, resp.getOutputStream());
            resp.flushBuffer();

        } catch (IOException ex) {
            logger.info("Error writing file to output stream. Filename was '{}'" + id + ex);
            throw new RuntimeException("IOError writing file to output stream");
        }
    }
}
