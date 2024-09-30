package vn.phatbee.ltwebst2.services;

import vn.phatbee.ltwebst2.models.CategoryModel;

import java.util.List;

public interface ICategoryService {
    List<CategoryModel> findAll();
    CategoryModel findById(int id);
    CategoryModel findName(String name);
    void insert(CategoryModel category);
    void update(CategoryModel category);
    void delete(int id);
    List<CategoryModel> searchByName(String keyword);
    void updateStatus(int id, int status);

}
