package th.co.inquiry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MinusOnline {
	
	@RequestMapping(value = {"/minusOnline"}, method = RequestMethod.GET)
    public String minusOnline(Model model) {
        return "minus-online";
    }

}
