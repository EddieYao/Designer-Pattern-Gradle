package util.httpClientUtils;


import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class HttpClientUtil {
    private CloseableHttpClient httpClient = HttpClients.createDefault();

    public HttpClientUtil() {
    }



    public String executeByPOST(String url, Map<String, String> params) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        HttpMethod method = new GetMethod();
        method.getParams().setCookiePolicy("compatibility");
        httpPost.setHeader("Referer", url);
        List<NameValuePair> nvps = new ArrayList();
        Set<String> keySet = params.keySet();
        Iterator response = keySet.iterator();

        String responseJson;
        while(response.hasNext()) {
            responseJson = (String)response.next();
            nvps.add(new BasicNameValuePair(responseJson, (String)params.get(responseJson)));
        }

        responseJson = "";

        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvps, "UTF-8");
            httpPost.setEntity(uefEntity);
            CloseableHttpResponse response2 = httpclient.execute(httpPost);
            if (response2.getStatusLine().getStatusCode() == 200) {
                responseJson = EntityUtils.toString(response2.getEntity(), "utf-8");
            }
        } finally {
            this.httpClient.getConnectionManager().closeExpiredConnections();
            this.httpClient.getConnectionManager().closeIdleConnections(30L, TimeUnit.SECONDS);
        }

        return responseJson;
    }

}
