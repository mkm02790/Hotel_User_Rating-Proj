/**
 * 
 */
package com.mukul.rating.service.entites;

/**
 * @author mukul
 *
 * 07-Dec-2022
 */
public class RatingResponseObj {

	private String ratingId;
	private String userId;
	private String userName;
	private String hotelId;
	private String hotelName;
	private double rating ;
	private String feedback;
	
	
	@Override
	public String toString() {
		return "RatingResponseObj [ratingId=" + ratingId + ", userId=" + userId + ", userName=" + userName
				+ ", hotelId=" + hotelId + ", hotelName=" + hotelName + ", rating=" + rating + ", feedback=" + feedback
				+ "]";
	}
	public RatingResponseObj() {
		
	}
	public String getRatingId() {
		return ratingId;
	}
	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
}
