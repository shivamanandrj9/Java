import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.net.ssl.*;
import java.security.cert.X509Certificate;
import java.io.*;

public class ChatGPTClient {
    private static final String API_KEY = "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";
    private static final String API_URL = "https://api.groq.com/openai/v1/chat/completions";
    private static String usage = "";


    private static void disableSSLVerification() throws Exception {
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() { return null; }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) { }
                    public void checkServerTrusted(X509Certificate[] certs, String authType) { }
                }
        };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        HostnameVerifier allHostsValid = (hostname, session) -> true;
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
    }

    public static void main(String[] args) {
        int retries = 0;
        int maxRetries = 5;

        while (retries < maxRetries) {
            try {
                disableSSLVerification();
                // Set up the HTTP connection
                URL url = new URL(API_URL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Authorization", "Bearer " + API_KEY);
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setDoOutput(true);

                // Create JSON body
                JSONObject messageObject = new JSONObject();
                messageObject.put("role", "user");
                messageObject.put("content", "List the ingredients used to "+usage+". Just give me list like response with numbering. No need for explanation or any header. Just the list. Also exclude the items that are not generally ordered from an online platform");

                JSONArray messagesArray = new JSONArray();
                messagesArray.put(messageObject);

                JSONObject jsonBody = new JSONObject();
                jsonBody.put("model", "llama3-8b-8192");
                jsonBody.put("messages", messagesArray);

                // Write JSON body to the request
                try (OutputStream os = conn.getOutputStream()) {
                    byte[] input = jsonBody.toString().getBytes("utf-8");
                    os.write(input, 0, input.length);
                }

                // Read the response
                if (conn.getResponseCode() == 429) {
                    // Rate limit hit, retry after a delay
                    retries++;
                    System.out.println("Rate limit exceeded. Retrying in " + (2 * retries) + " seconds...");
                    Thread.sleep(2000 * retries);  // Exponential backoff
                    continue;
                }

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line.trim());
                }
                in.close();

                // Parse and print the response
                JSONObject jsonResponse = new JSONObject(response.toString());
                String reply = jsonResponse.getJSONArray("choices").getJSONObject(0).getJSONObject("message").getString("content");
                System.out.println(reply);

                break; // Exit loop if successful

            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }

        if (retries == maxRetries) {
            System.out.println("Failed after maximum retries. Please try again later.");
        }
    }
}
