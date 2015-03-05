package org.vanya.Singletons;

/**
 * Used for sored back message before send it into chat
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
