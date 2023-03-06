package co.com.prueba.lulo.bank.exceptions;


import java.util.logging.Logger;

public class StatusCodeException extends Exception {

    private static final Logger LOGGER = Logger.getLogger("InfoLogging");

    public StatusCodeException(IllegalArgumentException e) {
        LOGGER.info(e.getMessage()+ ": It was not possible to establish the connection with the API");

    }
}