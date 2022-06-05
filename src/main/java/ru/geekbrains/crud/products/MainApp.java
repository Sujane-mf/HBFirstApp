package ru.geekbrains.crud.products;

public class MainApp {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        try{
            dao.init();
            dao.showAll();
            dao.selectByID(3L);
            dao.deleteByID(5L);
            dao.createNewProduct();
            dao.updateProduct(3L);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            dao.shutdown();
        }
    }
}
