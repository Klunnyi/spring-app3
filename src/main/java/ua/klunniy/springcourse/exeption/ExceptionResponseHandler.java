//package ua.klunniy.springcourse.exeption;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ProblemDetail;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.util.Map;
//import java.util.Objects;
//import java.util.stream.Collectors;
//

// 6.1.12

//@RestControllerAdvice
//@Slf4j
//public class ExceptionResponseHandler {
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ProblemDetail handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
//        Map<String, Map<String, String>> errors = ex.getFieldErrors()
//                .stream()
//                .collect(Collectors.toMap(
//                        FieldError::getField,
//                        v -> Map.of("Fields required", Objects.requireNonNull(v.getDefaultMessage())),
//                        (v1, v2) -> v1
//                ));
//        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Validation errors");
//        problemDetail.setProperty("errors", errors);
//        return problemDetail;
//    }
//
//}