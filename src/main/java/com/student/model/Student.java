package com.student.model;

public class Student {
   private int id;
   private String name;
   private double amount;
public Student(int id, String name, double amount) {
	super();
	this.id = id;
	this.name = name;
	this.amount = amount;
}
public Student(int id) {
	super();
	this.id = id;
}
public Student() {
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public Student(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}
public void setName(String name) {
	this.name = name;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", amount=" + amount + "]";
}
}
