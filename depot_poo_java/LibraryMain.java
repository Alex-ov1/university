public class LibraryMain {
    public static void main(String[] args) {
        Author author1 = new Author("Tolkien","JRR",1892);
        Author author2 = new Author("Hebert","Frank",1920);

        Book book1 = new Book("Le Seigneur des Anneaux",author1,1954, 1600);
        System.out.println(book1);

        Book book2 = new Book("Bilbo le Hobbit",author1,1937, 408);
        Book book3 = new Book("Dune",author2,1965);
        
        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        
        library.displayBooks();
        System.out.println("Nombre de livres avec un nombre de pages connu : "
        + library.getBooksWithPages());
    }
}
