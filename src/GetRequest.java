import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;

public class GetRequest {

   static String sURL = "http://speller.yandex.net/services/spellservice";

    public static void main(String[] args) throws IOException {
/*
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet("https://speller.yandex.net/services/spellservice/checkText?text=сиe5yнхрафазатрон+в+дубне");

            try (CloseableHttpResponse response1 = httpClient.execute(httpGet)) {
                System.out.println(response1.getCode() + " " + response1.getReasonPhrase()+response1.getEntity());
                HttpEntity entity1 = response1.getEntity();
                // do something useful with the response body
                // and ensure it is fully consumed
                EntityUtils.consume(entity1);


                System.out.println(entity1);
            }

*/
        CloseableHttpResponse resp1 = null;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(sURL+"/checkText?text=Моша+где+ти+бил");
            resp1 = httpClient.execute(httpGet);
            System.out.println(EntityUtils.toString(resp1.getEntity()));
            //System.out.println(resp1.getEntity());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        finally {
            try {
                resp1.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
