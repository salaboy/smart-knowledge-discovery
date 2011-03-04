package com.plugtree.smartknowledgediscovery;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.plugtree.smartknowledgediscovery.util.CategoryRequest;
import com.plugtree.smartknowledgediscovery.util.CategoryResponse;
import com.plugtree.smartknowledgediscovery.util.QuestionResponse;
import com.plugtree.smartprocessdiscovery.dao.GenericDao;
import com.plugtree.smartprocessdiscovery.model.common.Category;

 
@Path("/category")
public class CategoryResource {
    
    private GenericDao<Category> categoryService;
    
    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    @Path("/add")
    public CategoryResponse addCategory(CategoryRequest categoryRequest) {
            
        for (Category category : categoryRequest.getCategories()) {
            categoryService.save(category);
        }
                        
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setStatus(QuestionResponse.STATUS_SUCCESS);

        return categoryResponse;
    }
    
    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    @Path("/remove")
    public CategoryResponse removeCategory(CategoryRequest categoryRequest){
                                    
        for (Category category : categoryRequest.getCategories()) {
            categoryService.remove(category);
        }
        
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setStatus(QuestionResponse.STATUS_SUCCESS);

        return categoryResponse;
    }
    
    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    @Path("/update")
    public CategoryResponse updateCategory(CategoryRequest categoryRequest){
        
        for (Category category : categoryRequest.getCategories()) {
            categoryService.remove(category);
        }
        
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setStatus(QuestionResponse.STATUS_SUCCESS);

        return categoryResponse;
    }

    public void setCategoryService(GenericDao<Category> categoryService) {
        this.categoryService = categoryService;
    }

    public GenericDao<Category> getCategoryService() {
        return categoryService;
    }
}
