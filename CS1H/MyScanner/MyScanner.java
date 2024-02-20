package MyScanner;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class MyScanner {
    private char delimiters[] = new char[] { ' ', '\t', '\n' };

    public char[] setDelimiters(char delimiter) {
        return setDelimiters(new char[] { delimiter });
    }

    public char[] setDelimiters(char[] delimiters) {
        var t = this.delimiters;
        this.delimiters = delimiters;
        return t;
    }

    public char[] getDelimiters() {
        return this.delimiters;
    }

    public String nextLine() {
        return next(new char[] { '\n' });
    }

    public String next() {
        return next(this.delimiters);
    }

    public String next(char end) {
        return next(new char[] { end });
    }

    public String next(char[] end) {
        String line = "";
        int scan;
        read: while (true) {
            try {
                scan = System.in.read();
            } catch (IOException e) {
                scan = -1;
            }
            if (scan == -1)
                break;
            for (char c : end)
                if (scan == (int) c)
                    break read;

            line += (char) scan;
        }
        return line;
    }

    public int nextInt(int radix) {
        return Integer.parseInt(next(), radix);
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public byte nextByte() {
        return Byte.parseByte(next());
    }

    public byte nextByte(int radix) {
        return Byte.parseByte(next(), radix);
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public long nextLong(int radix) {
        return Long.parseLong(next(), radix);
    }

    public short nextShort() {
        return Short.parseShort(next());
    }

    public short nextShort(int radix) {
        return Short.parseShort(next(), radix);
    }

    public BigInteger nextBigInteger() {
        return new BigInteger(next());
    }

    public BigInteger nextBigInteger(int radix) {
        return new BigInteger(next(), radix);
    }

    public BigDecimal nextBigDecimal() {
        return new BigDecimal(next());
    }

    public float nextFloat() {
        return Float.parseFloat(next());
    }

    public boolean nextBoolean() {
        return Boolean.parseBoolean(next());
    }

    MyScanner() {
    }

    MyScanner(char delimiter) {
        this.setDelimiters(delimiter);
    }

    MyScanner(char[] delimiters) {
        this.setDelimiters(delimiters);
    }
}
