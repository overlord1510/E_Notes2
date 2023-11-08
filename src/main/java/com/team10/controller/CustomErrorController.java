package com.team10.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

	@GetMapping("/error")
	public String handelError(HttpServletRequest request, Model model) {

		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if (status != null) {
			int statusCode = Integer.parseInt(status.toString());
			model.addAttribute("status", statusCode);
			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				return "error";
			} else if (statusCode == HttpStatus.FORBIDDEN.value()) {
				return "error";
			} else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return "error";
			}else if(statusCode==HttpStatus.METHOD_NOT_ALLOWED.value()) {
				return "error";
			}
		}

		return "error";
	}

}
