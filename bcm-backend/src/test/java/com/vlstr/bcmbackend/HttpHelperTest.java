package com.vlstr.bcmbackend;

import com.vlstr.bcmbackend.domain.enums.Provider;
import com.vlstr.bcmbackend.util.HttpHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest
public class HttpHelperTest {

    @Autowired
    private HttpHelper httpHelper;

    @Test
    public void testEndPointUrlProviderMethod_shouldWork() {
        assertNotNull(httpHelper);
        assertEquals("https://my.api.mockaroo.com/air-jazz/flights", httpHelper.getFullEndpointUrl(Provider.AIR_JAZZ));
    }

    @Test
    public void testHttpEntity_shouldWork() {
        assertNotNull(httpHelper);
        HttpEntity<String> defaultEntity = httpHelper.getDefaultEntity();
        assertEquals(MediaType.APPLICATION_JSON, defaultEntity.getHeaders().getContentType());
        assertEquals("dd764f40", defaultEntity.getHeaders().get("X-API-Key").get(0));
    }
}
