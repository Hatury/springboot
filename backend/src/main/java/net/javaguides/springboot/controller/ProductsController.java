package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Products;
import net.javaguides.springboot.repository.ProductsRepository;


@CrossOrigin(origins = "*", maxAge = 3600)
	@RestController
	@RequestMapping("/api/prd")
public class ProductsController {
	@Autowired
	private ProductsRepository productsRepository;
	
	@GetMapping("/products")
	public List<Products> getAllProducts(){
		return productsRepository.findAll();
	}
	
	
	
	@PostMapping("/products/add")
	public Products createProducts(@RequestBody Products products) {
	   return productsRepository.save(products);
	}
	
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Products> updateProducts(@PathVariable Long id, @RequestBody Products productsDetails){
		Products products = productsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Products not exist with id :" + id));
		
		products.setProductname(productsDetails.getProductname());
		products.setCategoryid(productsDetails.getCategoryid());
		products.setAvatar(productsDetails.getAvatar());
		products.setTrash(productsDetails.getTrash());
		products.setStatus(productsDetails.getStatus());

		
		Products updatedproducts = productsRepository.save(products);
		return ResponseEntity.ok(updatedproducts);
	}

	
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProducts(@PathVariable Long id){
		Products products = productsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Products not exist with id :" + id));
		
		productsRepository.delete(products);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	
}
