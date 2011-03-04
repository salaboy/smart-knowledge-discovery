package com.plugtree.smartknowledgediscovery;

import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import junit.framework.Assert;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

import com.plugtree.smartknowledgediscovery.util.CategoryRequest;
import com.plugtree.smartknowledgediscovery.util.CategoryResponse;
import com.plugtree.smartknowledgediscovery.util.OperationType;
import com.plugtree.smartprocessdiscovery.model.common.Category;

public class CategoryResourceTest {

    @Test
    public void addPost() {

        Category category = new Category();
        category.setName("Test");
        category.setRank(0);

        CategoryRequest categoryRequest = new CategoryRequest();
        categoryRequest.setOperationType(OperationType.ADD);
        categoryRequest.getCategories().add(category);

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpHost httpHost = new HttpHost("127.0.0.1", 8080, "http");
        HttpPost httpPost = new HttpPost("/knowledge-discovery-rest/category/add");
        httpPost.setHeader("Content-type", "application/xml");

        try {
            JAXBContext requestContext = JAXBContext.newInstance(CategoryRequest.class);
            Marshaller marshaller = requestContext.createMarshaller();

            StringWriter requestWriter = new StringWriter();
            marshaller.marshal(categoryRequest, requestWriter);

            StringEntity requestEntity = new StringEntity(requestWriter.toString());
            httpPost.setEntity(requestEntity);

            HttpResponse httpResponse = httpClient.execute(httpHost, httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();

            InputStream responseStream = responseEntity.getContent();

            JAXBContext responseContext = JAXBContext.newInstance(CategoryResponse.class);
            Unmarshaller unmarhaller = responseContext.createUnmarshaller();

            CategoryResponse categoryResponse = (CategoryResponse)unmarhaller.unmarshal(responseStream);

            Assert.assertEquals(categoryResponse.getStatus(), CategoryResponse.STATUS_SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
