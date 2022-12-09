/**
 * 
 */
package com.mukul.rating.service.interceptor;

import javax.servlet.http.HttpServletRequest;
import static com.mukul.rating.service.serviceImpl.VerifyHotelIdClassImpl.verifyHotelId;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.mukul.rating.service.serviceImpl.VerifyHotelIdClassImpl;

/**
 * @author mukul
 *
 * 05-Dec-2022
 */
public class Rating_interceptors implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		
	String userId =	request.getParameter("userId");
	String hotelId= request.getParameter("hotelID");
	boolean hotelResult = VerifyHotelIdClassImpl.verifyHotelId(hotelId);
	System.out.println(hotelResult);
		return hotelResult;
	}

	/**
	 * @param hotelId
	 */
	

	
}
