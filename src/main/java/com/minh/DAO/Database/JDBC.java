package com.minh.DAO.Database;

public class JDBC {
    private  String jdbcURL = "jdbc:mysql://localhost:3306/exam?useSSL=false";
    private  String jdbcUser = "conal";
    private  String jdbcPassword = "12345678";
    private static volatile JDBC instance;
    public static JDBC getInstance(){
        if(instance==null){
            instance = new JDBC();
        }
        return  instance;
    }

    public String getJdbcURL() {
        return jdbcURL;
    }

    public String getJdbcUser() {
        return jdbcUser;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }
}
