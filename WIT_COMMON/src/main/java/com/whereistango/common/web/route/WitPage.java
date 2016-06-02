/**
 * 
 */
package com.whereistango.common.web.route;

/**
 * @author resulav
 *
 */
public enum WitPage implements IRoute {

	ROOT("/"), HOME("/home"),

	//
	SIGN_IN("/account/signin"), SIGN_UP("/account/signup"), PROFILE("/account/profile"), PROFILE_EDIT(
			"/account/profile_edit"),
			//
			SEARCH("/search"),
			//
			;

	private final String direct;
	private final String redirect;

	private WitPage(String direct) {
		this.direct = direct;
		this.redirect = new StringBuilder(REDIRECT).append(direct).toString();
	}

	public String redirect() {
		return redirect;
	}

	public String direct() {
		return direct;
	}

}
