package org.vanya.Singletons;

/**
 * Created by vanya on 01.03.15.
 */
public class SendBuffer {

    private String message = "";
    private static SendBuffer ourInstance = new SendBuffer();

    public static SendBuffer getInstance() {
        return ourInstance;
    }

    private SendBuffer() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        System.out.println("Buffer state: " + message);
        this.message = message;
    }
}
