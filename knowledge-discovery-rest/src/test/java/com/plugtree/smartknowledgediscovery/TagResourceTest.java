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

import com.plugtree.smartknowledgediscovery.util.OperationType;
import com.plugtree.smartknowledgediscovery.util.TagRequest;
import com.plugtree.smartknowledgediscovery.util.TagResponse;

public class TagResourceTest {

    @Test
    public void addPost() {

        String tag = new String("Test");

        TagRequest tagRequest = new TagRequest();
        tagRequest.setOperationType(OperationType.ADD);
        tagRequest.getTags().add(tag);
        tagRequest.getTags().add(new String("Magic"));

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpHost httpHost = new HttpHost("127.0.0.1", 8080, "http");
        HttpPost httpPost = new HttpPost("/knowledge-discovery-rest/tag/add");
        httpPost.setHeader("Content-type", "application/xml");

        try {
            JAXBContext requestContext = JAXBContext.newInstance(TagRequest.class);
            Marshaller marshaller = requestContext.createMarshaller();

            StringWriter requestWriter = new StringWriter();
            marshaller.marshal(tagRequest, System.out);

            StringEntity requestEntity = new StringEntity(requestWriter.toString());
            httpPost.setEntity(requestEntity);

            HttpResponse httpResponse = httpClient.execute(httpHost, httpPost);
            HttpEntity responseEntity = httpResponse.getEntity();

            InputStream responseStream = responseEntity.getContent();
            
            JAXBContext responseContext = JAXBContext.newInstance(TagResponse.class);
            Unmarshaller unmarhaller = responseContext.createUnmarshaller();

            TagResponse tagResponse = (TagResponse)unmarhaller.unmarshal(responseStream);

            Assert.assertEquals(tagResponse.getStatus(), TagResponse.STATUS_SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
