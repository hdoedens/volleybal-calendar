package eu.splender.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class Connection {

    // private final static Logger LOGGER = Logger.getLogger(Calendar.class.getName());

    private final String USER_AGENT = "voetbalnl/270 CFNetwork/811.5.4 Darwin/16.7.0";
    private static String BASEURL = "https://app-vnl-production.sportlink.com";

    public byte[] sendPost(String endpoint, String urlParameters, byte[] body) throws IOException {
        return sendPost(endpoint, urlParameters, body, null);
    }

    public byte[] sendPost(String endpoint, String urlParameters) throws IOException {
        return sendPost(endpoint, urlParameters, null, null);
    }

    public String readFullyAsString(InputStream inputStream, String encoding) throws IOException {
        return readFully(inputStream).toString(encoding);
    }

    private ByteArrayOutputStream readFully(InputStream inputStream) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = inputStream.read(buffer)) != -1) {
            baos.write(buffer, 0, length);
        }
        return baos;
    }

    public byte[] sendPostCompressed(String endpoint, String urlParameters, byte[] body, Map<String, String> headers) throws IOException {
        return Compressor.decompress(sendPost(endpoint, urlParameters, Compressor.compress(body), headers));
    }

    // HTTP POST request
    public byte[] sendPost(String endpoint, String urlParameters, byte[] body, Map<String, String> headers) throws IOException {

        URL obj = new URL(BASEURL + endpoint);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        // add request header
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        // Always set the same user agent
        con.setRequestProperty("User-Agent", USER_AGENT);
        if (headers == null) {
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        } else {
            for (String key : headers.keySet()) {
                con.setRequestProperty(key, headers.get(key));
            }
        }

        // Add the body
        if (body != null)
            con.getOutputStream().write(body);

        // Send post request
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        if (urlParameters != null)
            wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        // int responseCode = con.getResponseCode();
        // LOGGER.info("Sending 'POST' request to URL : " + BASEURL + endpoint);
        // LOGGER.info("Post parameters : " + urlParameters);
        // LOGGER.info("Response Code : " + responseCode);
        StringBuilder builder = new StringBuilder();
        builder.append(con.getResponseCode()).append(" ").append(con.getResponseMessage()).append("\n");
        Map<String, List<String>> map = con.getHeaderFields();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() == null)
                continue;
            builder.append(entry.getKey()).append(": ");

            List<String> headerValues = entry.getValue();
            Iterator<String> it = headerValues.iterator();
            if (it.hasNext()) {
                builder.append(it.next());

                while (it.hasNext()) {
                    builder.append(", ").append(it.next());
                }
            }

            builder.append("\n");
        }

        // LOGGER.info(builder.toString());

        byte[] responseContent = readFully(con.getInputStream()).toByteArray();

        return responseContent;

    }

}
