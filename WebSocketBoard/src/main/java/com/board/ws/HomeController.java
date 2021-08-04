package com.board.ws;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.ws.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		return "redirect:/board/list";
	}
	
	
	@RequestMapping(value = "/import/head", method = RequestMethod.GET)
	public String importHead(Locale locale, Model model) {
		return "common/head";
	}
	
	@RequestMapping(value = "/import/header/{tab}", method = RequestMethod.GET)
	public String importHeader(Locale locale, Model model,
			@PathVariable(name = "tab") String tab) {
		model.addAttribute("tab", tab);
		return "common/header";
	}

	@RequestMapping(value = "/import/footer", method = RequestMethod.GET)
	public String importFooter(Locale locale, Model model) {
		return "common/footer";
	}

	@RequestMapping(value = "/import/section", method = RequestMethod.GET)
	public String importSection(Locale locale, Model model) {
		return "common/section";
	}
}
