package dlithe.batchtwo.internship.DLitheBatchTwo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stock")
public class Vehicle 
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="entry_id")
	private Integer stkid;
	@Column(name="stock_model")
	private String model; 
	private String type;
	private int cc, year, quantity, milage;
	private double price;
	
	@Override
	public String toString() {
		return "Vehicle [stkid=" + stkid + ", model=" + model + ", type=" + type + ", cc=" + cc + ", year=" + year
				+ ", quantity=" + quantity + ", milage=" + milage + ", price=" + price + "]";
	}
	public Vehicle(Integer stkid, String model, String type, int cc, int year, int quantity, int milage, double price) {
		super();
		this.stkid = stkid;
		this.model = model;
		this.type = type;
		this.cc = cc;
		this.year = year;
		this.quantity = quantity;
		this.milage = milage;
		this.price = price;
	}
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getStkid() {
		return stkid;
	}
	public void setStkid(Integer stkid) {
		this.stkid = stkid;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getMilage() {
		return milage;
	}
	public void setMilage(int milage) {
		this.milage = milage;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
