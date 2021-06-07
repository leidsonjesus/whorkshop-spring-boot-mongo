package com.leidsonjesus.whorkshopmongo.resources.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.leidsonjesus.whorkshopmongo.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundException e, HttpServletResponse x) {
			HttpStatus status = HttpStatus.NOT_FOUND;
			StandarError err = new StandarError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), x.getCharacterEncoding());
			return ResponseEntity.status(status).body(err);
		}
}
