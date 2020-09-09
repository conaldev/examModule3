package com.minh.DAO;

import com.minh.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    void insertProduct(Product product) throws SQLException;
    Product selectProductById(int id)throws SQLException;
    List<Product> searchApproximateProductByName(String name) throws SQLException;
    List<Product> selectAllProduct()throws SQLException;
    boolean updateProduct(Product product) throws SQLException;
    boolean deleteProduct(int id) throws SQLException;
    List<String> selectAllCategory () throws SQLException;
}
