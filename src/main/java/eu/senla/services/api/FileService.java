package eu.senla.services.api;

import java.io.IOException;

public interface FileService {

    String readFromFile(String path) throws IOException;

}
