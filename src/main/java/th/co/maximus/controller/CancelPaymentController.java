package th.co.maximus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CancelPaymentController {

    @RequestMapping(value = {"/cancalPayment"}, method = RequestMethod.GET)
    public String usermgt(Model model) {
        return "cancel-payment-list";
    }
}
