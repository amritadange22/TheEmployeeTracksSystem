package com.jbk.EmployeeCountryAngularProject.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {

	
	/*
	 * @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="country_id_gen")
	 * 
	 * @SequenceGenerator(name="country_id_gen",sequenceName="cid_seq_gen",
	 * initialValue=101)
	 */
	@Id
	@Column(name="cid", unique=true, nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
	private String cname;
	
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Country(Integer cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Country [cid=" + cid + ", cname=" + cname + "]";
	}
}
