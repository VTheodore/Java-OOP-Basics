package L03_InheritanceEXC.p_02_book_shop;

public class GoldenEditionBook extends Book{

    public GoldenEditionBook(String title, String author, double price) {
        super(title, author, price);
    }

    @Override
    protected void setPrice(double price) {
        price = price * 1.3;
        super.setPrice(price);
    }
}
