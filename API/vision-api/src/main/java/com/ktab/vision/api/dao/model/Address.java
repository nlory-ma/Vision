package com.ktab.vision.api.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	long addressId;
	String houseNumber;
	String building;
	@Column(nullable = false, name = "LandMark")
	String landmark;
	String street;
	long pincode;
	String area;
	double latitude;
	double longitude;
	boolean isLocationVerified;
	boolean mapURL;
	String additionalNotes;

	public Address() {
	}

	public Address(String houseNumber, String landmark, String area, long pincode) {
		super();
		this.houseNumber = houseNumber;
		this.landmark = landmark;
		this.area = area;
		this.pincode = pincode;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public boolean isLocationVerified() {
		return isLocationVerified;
	}

	public void setLocationVerified(boolean isLocationVerified) {
		this.isLocationVerified = isLocationVerified;
	}

	public String getAdditionalNotes() {
		return additionalNotes;
	}

	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}

	public boolean isMapURL() {
		return mapURL;
	}

	public void setMapURL(boolean mapURL) {
		this.mapURL = mapURL;
	}

}
