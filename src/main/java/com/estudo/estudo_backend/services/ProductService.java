package com.estudo.estudo_backend.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.estudo.estudo_backend.model.Product;
import com.estudo.estudo_backend.repository.ProductRepository;

@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  /**
   * Metodo para retornar lista de produtos
   * @return Lista de produtos
   */
  public List<Product> getAll() {
    return productRepository.getAll();
  }

  /**
   * Método que retorna o produto encontrado pelo seu Id
   * @param id do produto que será localizado.
   * @return Retorna um produto caso seja encontrado.
   */
  public Optional<Product> getById(Integer id) {
    return productRepository.getById(id);
  }

   /**
   * Método para adicionar um produto na lista de produtos.
   * @param product produto que será adicionado.
   * @return Retorna o produto que foi adicionado na lista.
   */
  public Product add(Product product) {
    return productRepository.add(product);
  }

  /**
   * Método para deletar o produto por id.
   * @param id do produto a ser deletado.
   */
  public void delete(Integer id) {
    productRepository.delete(id);
  }

   /**
   * Método para atualizar o produto na lista.
   * @param product que será atualizado.
   * @return Retorna o produto após atualização da lista.
   */
  public Product update(Integer id, Product product) {
    product.setId(id);
    return productRepository.update(product);
  }
  
}
