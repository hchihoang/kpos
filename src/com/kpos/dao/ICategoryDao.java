package com.kpos.dao;

import com.kpos.domain.MenuCategory;

import java.util.List;

/**
 * Created by kpos.
 * Author: kkwang
 * Date: 3/10/12 11:54 PM
 */
public interface ICategoryDao {
    MenuCategory findByName(String aName);

    List<MenuCategory> listCategoriesByNameAsc();
    List<MenuCategory> listCategoriesByNameAsc(int begin, int maxSize);

    void insertCategory(MenuCategory aCategory);

    boolean deleteCategory(MenuCategory aCategory);

    MenuCategory updateCategory(MenuCategory aCategory);

    List<MenuCategory> listCategories();

    MenuCategory findCategory(long aId);

    List<MenuCategory> findCategoriesInGroup(long aGroupId);

    List<MenuCategory> findCategoriesInGroup(long aGroupId, int start, int maxSize);
}
