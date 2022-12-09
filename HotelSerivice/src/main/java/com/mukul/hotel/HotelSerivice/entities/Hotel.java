/**
 * 
 */
package com.mukul.hotel.HotelSerivice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author mukul
 *
 * 22-Nov-2022
 */


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="hotels")
public class Hotel {
	
  @Id
  @Column(length=10000)
  private String id;
  private String name;
  private String location;
  private String about;
  
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getAbout() {
	return about;
}
public void setAbout(String about) {
	this.about = about;
}

}
