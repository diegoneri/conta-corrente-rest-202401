package com.br.fatecrl.conta.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler {
	@Nullable
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		APIError error = new APIError();
		error.setStatus(status.value());
		error.setDataHora(LocalDateTime.now());
		error.setPath(((ServletWebRequest) request).getRequest().getRequestURI().toString());
		error.setMessagem("Um ou mais campos estão inválidos");
		error.setCampos(recuperaListaDeCamposDeErro(ex));
		return super.handleExceptionInternal(ex, error, headers, status, request);
	}

	private List<ErrorField> recuperaListaDeCamposDeErro(MethodArgumentNotValidException ex) {
		List<ErrorField> erros = new ArrayList<>();
		for (ObjectError error : ex.getBindingResult().getAllErrors())
			erros.add(new ErrorField(((FieldError) error).getField(), error.getDefaultMessage()));
		return erros;
	}
}
