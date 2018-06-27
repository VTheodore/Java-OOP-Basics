package L03_InheritanceEXC.p_02_book_shop;

import java.text.DecimalFormat;

public class Book {
    protected String author;

    protected String title;

    protected double price;

    public Book(String author, String title, double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    private String getTitle() {
        return this.title;
    }

    private void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }

        this.title = title;
    }

    private String getAuthor() {
        return this.author;
    }

    private void setAuthor(String author) {
        String[] bothNames = author.split(" ");

        if (bothNames.length == 2) {
            String lastName = bothNames[1];

            if (Character.isDigit(lastName.charAt(0))) {
                throw new IllegalArgumentException("Author not valid!");
            }
        }
        this.author = author;
    }

    private String getPrice() {
        DecimalFormat df = new DecimalFormat("#.0");

        return df.format(this.price);
    }

    protected void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }

        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());

        return sb.toString();
    }
}
