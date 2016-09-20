package org.master.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kaenry on 2016/9/20.
 * RestExceptionHandler
 */
@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private <T> RestResult<T> runtimeExceptionHandler(Exception e) {
        LOGGER.error("---------> huge error!", e);
        return RestResultGenerator.genErrorResult(ErrorCode.SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private <T> RestResult<T> illegalParamsExceptionHandler(MethodArgumentNotValidException e) {
        LOGGER.error("---------> invalid request!", e);
        return RestResultGenerator.genErrorResult(ErrorCode.ILLEGAL_PARAMS);
    }

}
