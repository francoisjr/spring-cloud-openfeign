package br.com.hdiseguros.hdisegurosms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.hdiseguros.hdisegurosms.dto.DefaultError;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

//	@ExceptionHandler(Exception.class)
//	public ResponseEntity handleException(Exception e) {
//		log.info("Caiu no handler");
//		
//		return new ResponseEntity("erro", HttpStatus.NOT_FOUND);
//	}
	
	@ExceptionHandler(FeignException.class)
	public ResponseEntity handleFeignException(Exception e) {
		log.info("Caiu no handleFeignException");
		
		DefaultError erro = new DefaultError(HttpStatus.NOT_FOUND.value(), "Este corretor não esta ativo.");
		return new ResponseEntity(erro, HttpStatus.NOT_FOUND);
	}
	
	
}
