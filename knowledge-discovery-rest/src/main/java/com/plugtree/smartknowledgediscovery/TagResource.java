package com.plugtree.smartknowledgediscovery;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.plugtree.smartknowledgediscovery.util.TagRequest;
import com.plugtree.smartknowledgediscovery.util.TagResponse;
import com.plugtree.smartprocessdiscovery.dao.GenericDao;

 
@Path("/tag")
public class TagResource {
    
    private GenericDao<String> tagService;
    
    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    @Path("/add")
    public TagResponse addTag(TagRequest tagRequest) {
            
        for (String tag : tagRequest.getTags()) {
            tagService.save(tag);
        }
                        
        TagResponse tagResponse = new TagResponse();
        tagResponse.setStatus(TagResponse.STATUS_SUCCESS);

        return tagResponse;
    }
    
    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    @Path("/remove")
    public TagResponse removeTag(TagRequest tagRequest) {
            
        for (String tag : tagRequest.getTags()) {
            tagService.remove(tag);
        }
                        
        TagResponse tagResponse = new TagResponse();
        tagResponse.setStatus(TagResponse.STATUS_SUCCESS);

        return tagResponse;
    }
    
    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    @Path("/update")
    public TagResponse updateTag(TagRequest tagRequest) {
            
        for (String tag : tagRequest.getTags()) {
            tagService.update(tag);
        }
                        
        TagResponse tagResponse = new TagResponse();
        tagResponse.setStatus(TagResponse.STATUS_SUCCESS);

        return tagResponse;
    }

    public void setTagService(GenericDao<String> tagService) {
        this.tagService = tagService;
    }

    public GenericDao<String> getTagService() {
        return tagService;
    }
}
