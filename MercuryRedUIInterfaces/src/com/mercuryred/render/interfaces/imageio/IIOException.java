package com.mercuryred.render.interfaces.imageio;


import java.io.IOException;

public class IIOException extends IOException {
    public IIOException() {
    }

    public IIOException(String message) {
        super(message);
    }

    public IIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public IIOException(Throwable cause) {
        super(cause);
    }

}
