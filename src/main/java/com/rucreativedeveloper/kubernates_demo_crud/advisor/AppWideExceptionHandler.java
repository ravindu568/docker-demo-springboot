package com.rucreativedeveloper.kubernates_demo_crud.advisor;




import com.rucreativedeveloper.kubernates_demo_crud.exception.EntryNotFoundException;
import com.rucreativedeveloper.kubernates_demo_crud.util.StandardResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(EntryNotFoundException.class)
    public ResponseEntity<StandardResponseDto> handleEntryNotFoundException(
            EntryNotFoundException e
    ) {
        return new ResponseEntity<>(
                new StandardResponseDto(404, e.getMessage(), null),
                HttpStatus.NOT_FOUND
        );
    }
}
