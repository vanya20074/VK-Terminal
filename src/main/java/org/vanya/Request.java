package org.vanya;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import org.vanya.Singletons.LastCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by vanya on 01.03.15.
 */
public class Request {

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

    public Request() {
    }

    public String getRequest() throws Exception {

        String json = null;
        String command = null;
        json = readUrl("https://api.vk.com/method/messages.getDialogs?user_id=" + userId + "&access_token=" + access_token);


        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(json);
        while (!parser.isClosed()) {
            // get the token
            JsonToken token = parser.nextToken();
            if (JsonToken.FIELD_NAME.equals(token) && "body".equals(parser.getCurrentName())) {
                token = parser.nextToken();
                command = parser.getText();
            }
        }
        if(!LastCommand.getInstance().getLastCommand().equals(command)) {
            LastCommand.getInstance().setLastCommand(command);
            System.out.println("Recieved command: " + command);
        }
        return command;
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
