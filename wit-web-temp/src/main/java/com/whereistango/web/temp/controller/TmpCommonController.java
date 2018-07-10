/**
 * 
 */
package com.whereistango.web.temp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.whereistango.common.web.route.WitPage;
import com.whereistango.web.temp.cache.MailCache;
import com.whereistango.web.temp.validator.TestMailValidator;
import com.whereistango.web.temp.validator.TestSubscribeForm;

/**
 * @author resulav
 *
 */
@Controller
public class TmpCommonController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	@Qualifier("emailValidator")
	TestMailValidator testMailValidator;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		if (logger.isTraceEnabled()) {
			logger.trace("index() ");
		}

		MailCache.getInstance().increase();

		TestSubscribeForm form = new TestSubscribeForm();
		model.addAttribute(TestSubscribeForm.FORM_NAME, form);

		return WitPage.HOME.direct();
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String byParameter(@ModelAttribute(TestSubscribeForm.FORM_NAME) TestSubscribeForm form, BindingResult result,
			Model model) {
		if (logger.isDebugEnabled()) {
			logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> mail: ");
		}
		testMailValidator.validate(form, result);
		if (result.hasErrors()) {

			model.addAttribute("msg", "invalid mail format");
			model.addAttribute("css", "warning");

			model.addAttribute(TestSubscribeForm.FORM_NAME, form);

			return WitPage.HOME.direct();
		}
		if (logger.isDebugEnabled()) {
			logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> mail: " + form.getMail());
		}

		MailCache.getInstance().add(form.getMail());

		model.addAttribute("msg",
				"We got your e-mail. Thank you for your interest. We will inform you when we are ready :)");
		model.addAttribute("css", "success");

		return WitPage.HOME.direct();
	}
}
