package com.CoderYogi.SuperMarket;

import com.CoderYogi.SuperMarket.DAO.ProductDAOInterface;
import com.CoderYogi.SuperMarket.Entity.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SuperMarketApplication {
    Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		SpringApplication.run(SuperMarketApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(ProductDAOInterface productDAOInt)
	{
		return runner -> {
			System.out.println("Enter the Action:");
			System.out.println("1.To add new Product\n2.To retrieve product List\n3.To Find product by Name \n4.To Find product by Code");
			System.out.println("5.To update existing Product\n6.To Delete product product List\n7.To delete all product\n");
			String choice=sc.nextLine();
			switch(choice)
			{
				case "1":createProduct(productDAOInt);break;
				case "2":RetrieveAllProducts(productDAOInt);;break;
				case "3":findAllByName(productDAOInt);;break;
				case "4":findAllByCode(productDAOInt);;break;
				case "5":updateProduct(productDAOInt);break;
				case "6":deleteProduct(productDAOInt);break;
				case "7":deleteAllProduct(productDAOInt);break;
				default:System.out.println("Invalid Input");break;
			}
		};
	}

	//Method to save new product details in table
	private void createProduct(ProductDAOInterface productDAOInt) {
		String code, name, brand, category;
		int quantity;
			System.out.println("Enter the following details:");
			System.out.println("Product code:");
			code = sc.nextLine();
			System.out.println("Product name:");
			name = sc.nextLine();
			System.out.println("Product brand:");
			brand = sc.nextLine();
			System.out.println("Product category:");
			category = sc.nextLine();
			System.out.println("Product Quantity:");
			quantity = sc.nextInt();
			Product theProduct= new Product(code, name, brand, category, quantity);
			productDAOInt.save(theProduct);
			Product theProduct1 = productDAOInt.findById(theProduct.getId());
			System.out.println("Newly inserted Product" + theProduct);
			RetrieveAllProducts(productDAOInt);

	}
	//Method to find all product list from table
	private void RetrieveAllProducts(ProductDAOInterface productDAOInt) {
		List<Product> theProductList=new ArrayList<Product>();
		theProductList=productDAOInt.findAll();
		System.out.println("The list of Products\n"+theProductList);
	}

	//Method to find all product list from table by Name

	private void findAllByName(ProductDAOInterface productDAOInt) {
		System.out.println("Enter the name:");
		String name = sc.nextLine();
		List<Product> theList = productDAOInt.findByProductName(name);
		if (theList == null) {
			System.out.println("No such product found");
		} else {
			System.out.println(theList);
		}
	}
	private void findAllByCode(ProductDAOInterface productDAOInt) {
		System.out.println("Enter the code:");
		String code = sc.nextLine();
		List<Product> theListByCode=productDAOInt.findByCode(code);
		System.out.println("The list by Code "+theListByCode);
	}

	private void updateProduct(ProductDAOInterface productDAOInt) {
		RetrieveAllProducts(productDAOInt);
		System.out.println("Enter the id:");
		String strId = sc.nextLine();
		int id=Integer.valueOf(strId);
		Product theProduct=productDAOInt.findById(id);
		System.out.println("Enter 1 -To update name:\n2-To update brand\n3-To update category\n4-To update Quantity");
		String op=sc.nextLine();
		switch (op)
		{
			case "1":
				System.out.println("Enter Name to update");
				String n=sc.nextLine();
				theProduct.setName(n);break;
			case "2":
				System.out.println("Enter brand to update");
				String b=sc.nextLine();
				theProduct.setName(b);break;
			case "3":
				System.out.println("Enter category to update");
				String c=sc.nextLine();
				theProduct.setName(c);break;
			case "4":
				System.out.println("Enter quantity to update");
				String q=sc.nextLine();
				theProduct.setName(q);break;
			default:
				System.out.println("Invalid input");
				break;

		}
		productDAOInt.update(theProduct);
		System.out.println("The updated product "+theProduct);
	}

	private void deleteProduct(ProductDAOInterface productDAOInt) {
		RetrieveAllProducts(productDAOInt);
		System.out.println("Enter the id:");
		int id = sc.nextInt();
		productDAOInt.delete(id);
		System.out.println("List of products after deletion");
		RetrieveAllProducts(productDAOInt);

	}
	private void deleteAllProduct(ProductDAOInterface productDAOInt) {

		int row=productDAOInt.deleteAll();
		System.out.println("Deleted row "+row);
	}



}



