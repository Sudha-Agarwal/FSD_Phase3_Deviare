package com.example.Phase3_Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Phase3_Project.model.Product;
import com.example.Phase3_Project.model.User;
import com.example.Phase3_Project.services.ProductService;
import com.example.Phase3_Project.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/manageproducts")
	public String manageProducts(Model model) {
		List<Product> products = productService.getAllproducts();
		model.addAttribute("products", products);
		return "manageproducts";		
	}
	
	@GetMapping("/addproduct")
	public String showAddProductForm(Model model) {
		model.addAttribute("product", new Product());
		return "addproduct";
	}
	
	@PostMapping("/addproduct")
	public String addProduct(@ModelAttribute("product") Product product) {
		System.out.println("product added");
		productService.saveProduct(product);
		return "redirect:/admin/manageproducts";		
	}
	
	@GetMapping("/editproduct/{id}")
	public String showEditProductForm(@PathVariable("id") Long id, Model model) {
		Product product = productService.getProductById(id);
		
		if(product == null) {
			return "productnotfound";
		}
		model.addAttribute("product",product);
		return "editproduct";
	}
	
	@PostMapping("/editproduct")
	public String editProduct(@ModelAttribute("product") Product product) {
		productService.saveProduct(product);
		return "redirect:/admin/manageproducts";		
	}
	
	@GetMapping("/deleteproduct/{id}")
	public String deleteProduct(@PathVariable("id") Long id, Model model) {
		Product product = productService.getProductById(id);
		
		if(product == null) {
			return "productnotfound";
		}
		productService.deleteProductById(id);
		return "redirect:/admin/manageproducts";	
	}
	
	@GetMapping("/manageusers")
	public String showManageUsersPage(Model model) {
		List<User> users = userService.getAllusers();
		model.addAttribute("users",users);
		return "manageusers";
	}
	
	@PostMapping("/searchUser")
	public String searchusers(@RequestParam("keyword") String keyword, Model model) {
		List<User> users = userService.searchUser(keyword);
		model.addAttribute("users", users);
		return "manageusers";
	}

}
