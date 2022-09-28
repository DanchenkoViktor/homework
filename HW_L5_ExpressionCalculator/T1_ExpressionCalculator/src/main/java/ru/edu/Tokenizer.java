package ru.edu;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Tokenizer implements Iterator<String> {
    private final String text;
    private int pos;

    public Tokenizer(String text) {
        this.text = text;
        this.pos = 0;
    }

    @Override
    public boolean hasNext() {
        skipSpaces();
        return pos < text.length();
    }

    @Override
    public String next() {
        skipSpaces();
        if (pos >= text.length()) {
            throw new NoSuchElementException();
        }
        int startPos = pos;
        while (pos < text.length()) {
            char ch = text.charAt(pos);
            if (Character.isSpaceChar(ch)) {
                break;
            }
            if (isDelimiter(ch)) {
                break;
            }
            ++pos;
        }
        if (startPos == pos) {
            ++pos;
        }
        return text.substring(startPos, pos);
    }

    private boolean isDelimiter(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '(' || ch == ')' || ch == ',';
    }

    private void skipSpaces() {
        while (pos < text.length()
                && Character.isSpaceChar(text.charAt(pos))) {
            pos++;
        }
    }
}
