package com.minh.DAO;

import com.minh.DAO.Database.JDBC;
import com.minh.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    private static final String INSERT_PRODUCT = "INSERT INTO Product" +
            " (productName,price,quantity,color,productDescription,category) values (?,?,?,?,?,?);";
    private static final String SELECT_PRODUCT_BY_ID = "select productName,price,quantity,color,productDescription,category from Product where id =?";
    private static final String SELECT_ALL_PRODUCT = "select * from Product;";
    private static final String DELETE_PRODUCT_BY_ID = "delete from Product where id = ?;";
    private static final String UPDATE_PRODUCT = "update Product set productName= ?,price=?,quantity=?,color=?,productDescription=?,category=? where id = ?;";
    private static final String SEARCH_APPROXIMATE_PRODUCT_BY_NAME = "select * from Product where productName like concat('%',?,'%');";
    private static final String SELECT_ALL_CATEGORY = "select category from Category;";
    public ProductDAO() { }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC.getInstance().getJdbcURL(), JDBC.getInstance().getJdbcUser(), JDBC.getInstance().getJdbcPassword());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertProduct(Product product) throws SQLException {
        System.out.println(INSERT_PRODUCT);
        try
                (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT);) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setLong(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getproductDescription());
            preparedStatement.setString(6, product.getCategory());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Product selectProductById(int id) {
        Product product = null;
        try
                (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String productName = resultSet.getString("productName");
                long price = resultSet.getLong("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String productDescription = resultSet.getString("productDescription");
                String category = resultSet.getString("category");

                product = new Product(id, productName, price, quantity, color, productDescription, category);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return product;
    }

    @Override
    public List<Product> searchApproximateProductByName(String name) throws SQLException {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_APPROXIMATE_PRODUCT_BY_NAME);) {
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String productName = rs.getString("productName");
                long price = rs.getLong("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String productDescription = rs.getString("productDescription");
                String category = rs.getString("category");
                products.add(new Product(id, productName, price, quantity, color, productDescription, category));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }


    @Override
    public List<Product> selectAllProduct() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);) {
            System.out.println(preparedStatement+"running preparedStatement");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String productName = rs.getString("productName");
                long price = rs.getLong("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String productDescription = rs.getString("productDescription");
                String category = rs.getString("category");
                products.add(new Product(id, productName, price, quantity, color, productDescription, category));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return products;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        boolean rowUpdated;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);

        preparedStatement.setString(1, product.getProductName());
        preparedStatement.setLong(2, product.getPrice());
        preparedStatement.setInt(3, product.getQuantity());
        preparedStatement.setString(4, product.getColor());
        preparedStatement.setString(5, product.getproductDescription());
        preparedStatement.setString(6, product.getCategory());

        rowUpdated = preparedStatement.executeUpdate() > 0;

        return rowUpdated;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        boolean rowDeleted;
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_BY_ID);
        statement.setInt(1, id);
        rowDeleted = statement.executeUpdate() > 0;
        return rowDeleted;
    }

    @Override
    public List<String> selectAllCategory() throws SQLException {
        List<String> categories = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);) {
            System.out.println(preparedStatement+"running preparedStatement");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String category = rs.getString(1);
                categories.add(category);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return categories;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
