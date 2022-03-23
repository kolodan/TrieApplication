package eu.senla.services;

import eu.senla.services.api.FileService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileServiceImpl implements FileService {

    @Override
    public String readFromFile(String path) throws IOException {
        return Files.readString(Path.of(path));
    }

}
