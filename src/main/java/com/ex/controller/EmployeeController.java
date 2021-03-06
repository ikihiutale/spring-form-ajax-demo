package com.ex.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ex.model.Employee;
import com.ex.validator.EmployeeValidator;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 * 
 */
@Controller
@RequestMapping(value = "/join")
public class EmployeeController {

	private static final String INFO_ATTR = "info";
	private static final String SUCCESS_ATTR = "success";
	private static final String DEFAULT_PAGE = "employee";
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);
	
//	@InitBinder
//    protected void initBinder(WebDataBinder binder) {
//		if (binder.getTarget() != null && Employee.class.equals(binder.getTarget().getClass())) {
//			binder.setValidator(new EmployeeValidator());
//		}
//    }
	
	@Autowired
    private MessageSource messageSource;

	@ModelAttribute("employee")
	public Employee createEmployee()
	{
		return new Employee();
	}
	
    @GetMapping
    public String doRegister(final Model model,  @ModelAttribute(INFO_ATTR) final String info, 
    		@ModelAttribute(SUCCESS_ATTR) final String success) {
    	
    	LOG.info("doRegister: info={}, success={} ++", info, success);
    	if (StringUtils.isNotBlank(info)) {
    		model.addAttribute(INFO_ATTR, info);
    	}
    	if (StringUtils.isNotBlank(success)) {
    		model.addAttribute(SUCCESS_ATTR, success);
    	}
    	LOG.info("*** doRegister --");

    	return getPage();        
    }

    @PostMapping
    public String register(@Valid @ModelAttribute("employee") Employee employee, BindingResult result, Model model,
			final HttpServletRequest request, final HttpServletResponse response, 
			final RedirectAttributes redirectAttr) {
    	LOG.info("*** register redirect ++");
    	
    	if (result.hasErrors()) {
        	LOG.info("register error: {}", result);
        	model.addAttribute(INFO_ATTR, messageSource.getMessage("employee.general.error", null, Locale.getDefault()));
        	return getPage();
        }
    	redirectAttr.addFlashAttribute(SUCCESS_ATTR, Boolean.TRUE);
    	LOG.info("*** register redirect --");
    	return "redirect:/join";
    }
    
    private String getPage() {
    	return DEFAULT_PAGE;
    }
}
