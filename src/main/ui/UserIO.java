package main.ui;

public interface UserIO {

    public void print(String message);

    public int readInt(String prompt);

    public int readInt(String prompt, int min, int max);

    public String readString(String prompt);
    
}
