package com.example.firstSpring;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="SUBSCRIBER")
public class Subscriber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SUBSC_ID")
	private int SUBSC_ID;

	@Column(name = "SUBSC_NAME")
	private String SUBSC_NAME;

	@Column(name = "SUBSC_SURNAME")
	private String SUBSC_SURNAME;

	@Column(name = "MSISDN")
	private String MSISDN;

	@Column(name = "TARIFF_ID")
	private int TARIFF_ID;

	@Column(name = "START_DATE")
	private String START_DATE;

	public int getSUBSC_ID() {
		return SUBSC_ID;
	}

	public void setSUBSC_ID(int sUBSC_ID) {
		SUBSC_ID = sUBSC_ID;
	}

	public String getSUBSC_NAME() {
		return SUBSC_NAME;
	}

	public void setSUBSC_NAME(String sUBSC_NAME) {
		SUBSC_NAME = sUBSC_NAME;
	}

	public String getSUBSC_SURNAME() {
		return SUBSC_SURNAME;
	}

	public void setSUBSC_SURNAME(String sUBSC_SURNAME) {
		SUBSC_SURNAME = sUBSC_SURNAME;
	}

	public String getMSISDN() {
		return MSISDN;
	}

	public void setMSISDN(String mSISDN) {
		MSISDN = mSISDN;
	}

	public int getTARIFF_ID() {
		return TARIFF_ID;
	}

	public void setTARIFF_ID(int tARIFF_ID) {
		TARIFF_ID = tARIFF_ID;
	}

	public String getSTART_DATE() {return START_DATE;}

	public void setSTART_DATE(String sTART_DATE) {START_DATE = sTART_DATE;
	}


}
