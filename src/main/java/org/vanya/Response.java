package org.vanya;

import org.vanya.Singletons.SendBuffer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


public class Response {

    private int userId;
    private String access_token;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void sendResponse() {

    }

    /**
     * Send message that stored in SendBuffer
     * @throws Exception
     */
    public void sendMessageBack() throws Exception {

        String message = SendBuffer.getInstance().getMessage();
        message = message.replace(" ", "%20");
        String json = readUrl("https://api.vk.com/method/messages.send?user_id=" + userId + "&message=" + message + "&access_token=" + access_token);
        System.out.println("Send message: " + message);
    }


    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }
}
