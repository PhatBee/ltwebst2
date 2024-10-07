package vn.phatbee.ltwebst2.services.impl;

import vn.phatbee.ltwebst2.dao.ICategoryDaoEntity;
import vn.phatbee.ltwebst2.dao.impl.CategoryDaoEntityImpl;
import vn.phatbee.ltwebst2.entity.Category;
import vn.phatbee.ltwebst2.services.ICategoryServiceEntity;

import java.util.List;

public class CategoryServiceEntityImpl implements ICategoryServiceEntity {
    ICategoryDaoEntity cateDao = new CategoryDaoEntityImpl();
    @Override
    public void insert(Category category) {
        cateDao.insert(category);

    }

    @Override
    public void update(Category category) {
        cateDao.update(category);

    }

    @Override
    public void delete(int cateid) throws Exception {
        cateDao.delete(cateid);

    }

    @Override
    public Category findById(int id) {
        return cateDao.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return cateDao.findAll();
    }

    @Override
    public List<Category> findByCategoryName(String catName) {
        return cateDao.findByCategoryName(catName);
    }

    @Override
    public List<Category> findAll(int page, int size) {
        return cateDao.findAll(page, size);
    }

    @Override
    public int count() {
        return cateDao.count();
    }
}
