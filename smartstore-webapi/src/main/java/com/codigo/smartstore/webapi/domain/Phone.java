package com.codigo.smartstore.webapi.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Phone {

	String type;
	String areaCode;
	String number;

}
