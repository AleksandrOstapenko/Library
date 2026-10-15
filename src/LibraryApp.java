import java.util.ArrayList;

public class LibraryApp {

    public static void main (String[] args){

        Book book1 = new Book( "Долгий, трудный путь из ада", 1998);

        Book book2 = new Book("Код дурова", 2015);

        Book book3 = new Book("Джонни Депп: Биография",2011);

        Reader reader1 = new Reader("Абдуллозода");
        Reader reader2 = new Reader("Рахмонзода");

        ArrayList<Loan> loans = new ArrayList<>();

        Loan loan1 = new Loan(book1,reader1, 42);
        Loan loan2 = new Loan(book2,reader2,9);
        Loan loan3 = new Loan(book3,reader1,4);
        Loan loan4 = new Loan(book1,reader1,8);

        loans.add(loan1);
        loans.add(loan2);
        loans.add(loan3);
        loans.add(loan4);

        int totalFine = 0;



        for(Loan loan : loans) {
            System.out.println(loan.reader.name + " - " + "\"" + loan.book.title + "\"" + ", " + loan.daysOnHands + " дн.");
            if (loan.daysOnHands > 14) {
                int penalty = (loan.daysOnHands - 14) * 10;
                totalFine += penalty;
                System.out.println("Штраф: " + penalty + " руб.");

            }
        }
        System.out.println("Всего штрафов: " + totalFine + " руб.");

        Book oldestBook = loans.get(0).book;
        for(Loan loan  : loans) {
            if(loan.book.year <oldestBook.year ){
                oldestBook = loan.book;
            }
        }
        System.out.println("Самая старая книга: " + "\"" + oldestBook.title + "\"" + " ( " + oldestBook.year + " )");
    }
}