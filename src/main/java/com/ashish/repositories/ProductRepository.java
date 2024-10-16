package com.ashish.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ashish.models.Product;
import com.ashish.models.ProductCategory;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>
{
	List<Product> findByBrand(String brand);
	List<Product> findByCategory(ProductCategory category);
	
	@Query("select p from Product p where p.price<=:price")
	List<Product> underPrice(@Param("price") Integer under);
	
	@Query("select p from Product p where p.price between :price1 and :price2")
	List<Product> betweenPrice(@Param("price1") Integer price1,@Param("price2") Integer price2);
	
	@Query("select p from Product p where p.price>=:price")
	List<Product> abovePrice(@Param("price") Integer above);

}
