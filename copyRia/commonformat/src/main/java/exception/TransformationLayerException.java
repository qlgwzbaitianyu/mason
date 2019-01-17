package com.luxottica.ria.commonformat.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.luxottica.ria.commonformat.enumeration.StatusCode;

public class TransformationLayerException extends Exception {

    private final StatusCode status;

    private static final long serialVersionUID = 1L;

    public TransformationLayerException(StatusCode status, String message,Throwable cause) {
        super(message, cause);
        this.status=status;
    }

    public TransformationLayerException(StatusCode status, String message) {
        super(message);
        this.status=status;
    }

    public StatusCode getStatus() {
        return status;
    }

}

