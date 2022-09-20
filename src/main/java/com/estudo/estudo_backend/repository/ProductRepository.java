package com.estudo.estudo_backend.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.estudo.estudo_backend.model.Product;
import com.estudo.estudo_backend.model.exception.ResourceNotFoundException;

@Repository
public class ProductRepository {
  private List<Product> products = new ArrayList<Product>();
  private Integer ultimoId = 0;

  /**
   * Metodo para retornar lista de produtos
   * @return Lista de produtos
   */
  public List<Product> getAll() {
    return products;
  }

  /**
   * Método que retorna o produto encontrado pelo seu Id
   * @param id do produto que será localizado.
   * @return Retorna um produto caso seja encontrado.
   */
  public Optional<Product> getById(Integer id) {
    return products
      .stream()
      .filter(product -> product.getId() == id)
      .findFirst();
  }

  /**
   * Método para adicionar um produto na lista de produtos.
   * @param product produto que será adicionado.
   * @return Retorna o produto que foi adicionado na lista.
   */
  public Product add(Product product) {
    ultimoId++;
    product.setId(ultimoId);
    products.add(product);
    return product;
  }

  /**
   * Método para deletar o produto por id.
   * @param id do produto a ser deletado.
   */
  public void delete(Integer id) {
    products
      .removeIf(product -> product.getId() == id);
  }

  /**
   * Método para atualizar o produto na lista.
   * @param product que será atualizado.
   * @return Retorna o produto após atualização da lista.
   */
  public Product update(Product product) {
    Optional<Product> foundProduct = this.getById(product.getId());

    if (foundProduct.isEmpty()) {
      throw new ResourceNotFoundException("Produto não localizado.");
    }
    this.delete(product.getId());
    products.add(product);

    return product;
  }
}
