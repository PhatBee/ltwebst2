package vn.phatbee.ltwebst2.services.impl;

import vn.phatbee.ltwebst2.dao.ICategoryDao;
import vn.phatbee.ltwebst2.dao.impl.CategoryDaoImpl;
import vn.phatbee.ltwebst2.models.CategoryModel;
import vn.phatbee.ltwebst2.services.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    private ICategoryDao cateDao = new CategoryDaoImpl();
    @Override
    public List<CategoryModel> findAll() {
        return cateDao.findAll();
    }

    @Override
    public CategoryModel findById(int id) {
        return cateDao.findById(id);
    }

    @Override
    public CategoryModel findName(String name) {
        return cateDao.findByName(name);
    }

    @Override
    public void insert(CategoryModel category) {
        CategoryModel cate = this.findName(category.getCategoryname());
        if (cate.getCategoryname() == null) {
            cateDao.insert(category);
        }
    }

    @Override
    public void update(CategoryModel category) {
        CategoryModel cate = new CategoryModel();
        cate = cateDao.findById(cate.getCategoryid());
        if (cate != null) {
            cateDao.update(category);
        }

    }

    @Override
    public void delete(int id) {
        CategoryModel cate = new CategoryModel();
        cate = cateDao.findById(id);
        if (cate != null) {
            cateDao.delete(id);
        }
    }

    @Override
    public List<CategoryModel> searchByName(String keyword) {
        return cateDao.searchByName(keyword);
    }

    @Override
    public void updateStatus(int id, int status) {
        cateDao.updateStatus(id, status);
    }
}
