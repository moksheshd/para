/*
 * Copyright 2013-2014 Erudika. http://erudika.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * For issues and patches go to: https://github.com/erudika
 */
package com.erudika.para.security;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * Rest request matcher - returns true if the request is RESTful. 
 * True if the URI starts with /vX.Y.Z (.Y.Z are optional)
 * @author Alex Bogdanovski <alex@erudika.com>
 */
public final class RestRequestMatcher implements RequestMatcher {
	/**
	 * An instance of this class.
	 */
	public static final RequestMatcher INSTANCE = new RestRequestMatcher();
	private static final RegexRequestMatcher regex = new RegexRequestMatcher("^/v\\d[\\.\\d^/]*.*", null, true);

	private RestRequestMatcher() { }

	@Override
	public boolean matches(HttpServletRequest request) {
		// Determine if the request is RESTful.
		return regex.matches(request);
	}

}
