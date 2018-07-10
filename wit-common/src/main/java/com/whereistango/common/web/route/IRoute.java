/**
 * 
 */
package com.whereistango.common.web.route;

/**
 * @author resulav
 *
 */
public interface IRoute {

	public static final String PATH_SEPERATOR = "/";

	public static final String REDIRECT = "redirect:";

	public String redirect();

	public String direct();
}
