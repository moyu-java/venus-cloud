package com.junmoyu.venus.cloud.starter.core.exception;

import com.junmoyu.venus.cloud.starter.core.model.dto.Response;
import com.junmoyu.venus.cloud.starter.core.model.dto.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * ControllerMethodResolver.
 *
 * @author moyu.jun
 * @date 2022/3/11
 * @see <a href="https://dzone.com/articles/global-exception-handling-with-controlleradvice">global-exception-handling-with-controlleradvice</a>
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(Exception.class)
    protected Response<String> handleExceptionHandler(final Exception exception) {
        log.error(exception.getMessage(), exception);
        String message;
        if (exception instanceof VenusException) {
            VenusException venusException = (VenusException) exception;
            message = venusException.getMessage();
        } else {
            message = "The system is busy, please try again later";
        }
        return Response.failure(message);
    }
//
//    @ExceptionHandler(DuplicateKeyException.class)
//    protected ShenyuAdminResult handleDuplicateKeyException(final DuplicateKeyException exception) {
//        log.error("duplicate key exception ", exception);
//        return ShenyuAdminResult.error(ShenyuResultMessage.UNIQUE_INDEX_CONFLICT_ERROR);
//    }
//
//    @ExceptionHandler(UnauthorizedException.class)
//    protected ShenyuAdminResult handleUnauthorizedException(final UnauthorizedException exception) {
//        log.error("unauthorized exception", exception);
//        return ShenyuAdminResult.error(CommonErrorCode.TOKEN_NO_PERMISSION, ShenyuResultMessage.TOKEN_HAS_NO_PERMISSION);
//    }
//
//    @ExceptionHandler(NullPointerException.class)
//    protected ShenyuAdminResult handleNullPointException(final NullPointerException exception) {
//        log.error("null pointer exception ", exception);
//        return ShenyuAdminResult.error(CommonErrorCode.NOT_FOUND_EXCEPTION, ShenyuResultMessage.NOT_FOUND_EXCEPTION);
//    }
//
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    protected ShenyuAdminResult handleHttpRequestMethodNotSupportedException(final HttpRequestMethodNotSupportedException e) {
//        LOG.warn("http request method not supported", e);
//        StringBuilder sb = new StringBuilder();
//        sb.append(e.getMethod());
//        sb.append(
//                " method is not supported for this request. Supported methods are ");
//        Objects.requireNonNull(e.getSupportedHttpMethods()).forEach(t -> sb.append(t).append(" "));
//        return ShenyuAdminResult.error(sb.toString());
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    protected ShenyuAdminResult handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
//        LOG.warn("method argument not valid", e);
//        BindingResult bindingResult = e.getBindingResult();
//        String errorMsg = bindingResult.getFieldErrors().stream()
//                .map(f -> f.getField().concat(": ").concat(Optional.ofNullable(f.getDefaultMessage()).orElse("")))
//                .collect(Collectors.joining("| "));
//        return ShenyuAdminResult.error(String.format("Request error! invalid argument [%s]", errorMsg));
//    }
//
//    @ExceptionHandler(MissingServletRequestParameterException.class)
//    protected ShenyuAdminResult handleMissingServletRequestParameterException(final MissingServletRequestParameterException e) {
//        LOG.warn("missing servlet request parameter", e);
//        return ShenyuAdminResult.error(String.format("%s parameter is missing", e.getParameterName()));
//    }
//
//    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
//    protected ShenyuAdminResult handleMethodArgumentTypeMismatchException(final MethodArgumentTypeMismatchException e) {
//        LOG.warn("method argument type mismatch", e);
//        return ShenyuAdminResult.error(String.format("%s should be of type %s", e.getName(), Objects.requireNonNull(e.getRequiredType()).getName()));
//    }
//
//    @ExceptionHandler(ConstraintViolationException.class)
//    protected ShenyuAdminResult handleConstraintViolationException(final ConstraintViolationException e) {
//        LOG.warn("constraint violation exception", e);
//        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//        return ShenyuAdminResult.error(violations.stream()
//                .map(v -> v.getPropertyPath().toString().concat(": ").concat(v.getMessage()))
//                .collect(Collectors.joining("| ")));
//    }
//
//    @ExceptionHandler(ShenyuAdminException.class)
//    protected ShenyuAdminResult handleVenusException(final ShenyuAdminException exception) {
//        log.error("null pointer exception ", exception);
//        return ShenyuAdminResult.error(CommonErrorCode.NOT_FOUND_EXCEPTION, exception.getMessage());
//    }
}
