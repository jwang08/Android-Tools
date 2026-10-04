package com.example.q33;

public class Model
{
    private int key;

    public void set(int key)
    {
        this.key = key;
    }

    public String encrypt(String input)
    {
        String output = "";

        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i)))
                output = output + encrypt(input.charAt(i));
            else
                output = output + input.charAt(i);
        }

        return output;
    }

    public String decrypt(String input)
    {
        String output = "";

        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i)))
                output = output + decrypt(input.charAt(i));
            else
                output = output + input.charAt(i);
        }

        return output;
    }

    private char encrypt(char letter)
    {
        int code = code(letter);

        code = (code + key%52)%52;

        return character(code);
    }

    private char decrypt(char letter)
    {
        int code = code(letter);

        code = (code - key%52 + 52)%52;

        return character(code);
    }

    private int code(char letter)
    {
        if (Character.isLowerCase(letter))
            return (int)letter - (int)'a';
        else
            return (int)letter - (int)'A' + 26;
    }

    private char character(int code)
    {
        if (code < 26)
            return (char)((int)'a' + code);
        else
            return (char)((int)'A' + code - 26);
    }
}