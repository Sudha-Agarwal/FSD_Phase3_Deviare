package com.example.ExceptionHandling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceController {
	private static Map<String, Product> list = new HashMap();
	static {
		Product honey = new Product();
		honey.setId("1");
		honey.setName("Honey");
		list.put("1", honey);		
		
		Product almond = new Product();
		honey.setId("2");
		honey.setName("Almond");
		list.put("1", almond);		
	}	
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable String id, @RequestBody Product product){
		if(!list.containsKey(id)) throw new ProductNotFoundException();		
		list.remove(id);
		list.put(id, product);
		
		return new ResponseEntity<>("product is updated", HttpStatus.OK);
		
	}

}
