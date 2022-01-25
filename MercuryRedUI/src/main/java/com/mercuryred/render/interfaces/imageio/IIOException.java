package com.mercuryred.render.interfaces.imageio;




public class IIOException extends Exception {
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

    public IIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
