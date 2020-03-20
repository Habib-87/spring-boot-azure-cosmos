package com.habib.sample.cosmosdb.config;

import java.io.IOException;
import java.util.Random;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

/**
 * Filter class to add Correlation ID with every request and attach to log to identify separately.
 * Send the id in the response.
 * @author 
 *
 */

public class CorrelationIDHeaderFilter implements Filter {
	
	private static final Logger logger = LoggerFactory.getLogger(CorrelationIDHeaderFilter.class);
	public static final String CORRELATION_ID = "CorrelationId";
	public static final String CORRELATION_ID_HEADER = "X-Correlation-Id";
	private Random random = new Random();

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		try {

			final String token;
			if (req instanceof HttpServletRequest) {

				HttpServletRequest request = (HttpServletRequest) req;

				if (!StringUtils.isEmpty(request.getHeader(CORRELATION_ID_HEADER))) {
					token = request.getHeader(CORRELATION_ID_HEADER);
					logger.info("Correlation Id Exists.Attaching the same in the request {}",token);
					MDC.put(CORRELATION_ID, token);
				} else {
					token = getCorrelationId();
					logger.info("Correlation Id doesnt Exists in the request. Generating new id {}",token);
					MDC.put(CORRELATION_ID, token);
				}

				HttpServletResponse response = (HttpServletResponse) res;
				response.addHeader(CORRELATION_ID_HEADER, token);
			}

			chain.doFilter(req, res);
		} finally {

			MDC.remove(CORRELATION_ID);
		}

	}

	@Override
	public void destroy() {

	}

	@Override
	public void init(FilterConfig fc) throws ServletException {

	}

	private String getCorrelationId() {
		// return UUID.randomUUID().toString();
		long randomNum = random.nextLong();
		return encodeBase62(randomNum);
	}

	private String encodeBase62(long n) {

		final String base62Chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

		StringBuilder builder = new StringBuilder();

		// NOTE: Appending builds a reverse encoded string. The most significant value
		// is at the end of the string. You could prepend(insert) but appending
		// is slightly better performance and order doesn't matter here.

		// perform the first selection using unsigned ops to get negative
		// numbers down into positive signed range.
		long index = Long.remainderUnsigned(n, 62);
		builder.append(base62Chars.charAt((int) index));
		n = Long.divideUnsigned(n, 62);
		// now the long is unsigned, can just do regular math ops
		while (n > 0) {
			builder.append(base62Chars.charAt((int) (n % 62)));
			n /= 62;
		}
		return builder.toString();
	}

}
