package net.javaguides.springboot.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Products;



public interface ProductsRepository extends JpaRepository<Products, Long>  {
	
}
