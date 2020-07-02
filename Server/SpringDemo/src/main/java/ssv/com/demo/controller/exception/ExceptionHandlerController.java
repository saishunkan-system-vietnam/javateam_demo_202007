package ssv.com.demo.controller.exception;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ssv.com.demo.exception.DataNotFoundException;
import ssv.com.demo.util.JsonResult;

@RestControllerAdvice
public class ExceptionHandlerController {

	@SuppressWarnings("rawtypes")
	@ExceptionHandler(value = { DataNotFoundException.class })
	public JsonResult handleDataNotFoundException(Exception e, HttpServletRequest request,
			HttpServletResponse response) {
		return JsonResult.fail(e.getMessage(), new ArrayList());
	}
}
