package ws.synospis.trainingpercyquezada.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ws.synospis.trainingpercyquezada.bean.response.Response;
import ws.synospis.trainingpercyquezada.exception.TrainingException;

@ControllerAdvice
public class TrainingAdvice {
	
	@ExceptionHandler({TrainingException.class})
	public ResponseEntity<?> field(TrainingException e){
		Response response = Response.builder().message(e.getMessage()).build();
		return ResponseEntity.internalServerError().body(response);
	}
}
