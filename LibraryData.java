import java.util.ArrayList;

/**
 * Simple in-memory data holder for the app.
 * Keeps books, members and a single librarian account for demo use.
 */
public class LibraryData {

    // single instance (simple singleton)
    private static LibraryData instance = null;

    public ArrayList<Book> books;
    public ArrayList<Member> members;

    public String librarianUsername;
    public String librarianPassword;

    // used to auto-generate ISBN001, ISBN002, ...
    private int isbnCounter = 0;

    // next ID for newly added members (sample members use 101 and 102)
    private int nextMemberId = 103;

    private LibraryData() {
        books = new ArrayList<>();
        members = new ArrayList<>();

        loadSampleBooks();

        // sample members (username, password, displayName, id)
        members.add(new Member("lavish", "1111", "Lavish", 101));
        members.add(new Member("radhika", "2222", "Radhika", 102));

        // single librarian account
        librarianUsername = "admin";
        librarianPassword = "1234";
    }

    // Adds a book with an auto-generated ISBN (ISBN001, ISBN002, ...)
    private void addBook(String title, String author, String category) {
        isbnCounter++;
        String isbn = String.format("ISBN%03d", isbnCounter);
        books.add(new Book(title, author, isbn, category));
    }

    private void loadSampleBooks() {

        // ---------- Spiritual ----------
        addBook("Bhagavad Gita", "Srila Prabhupada", "Spiritual");
        addBook("Ramayana", "Valmiki", "Epic");
        addBook("Autobiography of a Yogi", "Paramahansa Yogananda", "Spiritual");
        addBook("The Power of Now", "Eckhart Tolle", "Spiritual");
        addBook("Man's Search for Meaning", "Viktor E. Frankl", "Spiritual");
        addBook("Wings of Fire", "A.P.J. Abdul Kalam", "Biography");
        addBook("The Monk Who Sold His Ferrari", "Robin Sharma", "Spiritual");
        addBook("Siddhartha", "Hermann Hesse", "Spiritual");
        addBook("The Alchemist", "Paulo Coelho", "Fiction");
        addBook("Gitanjali", "Rabindranath Tagore", "Poetry");

        // ---------- Epic / Indian Literature ----------
        addBook("Mahabharata", "Vyasa", "Epic");
        addBook("Arthashastra", "Kautilya", "History");
        addBook("Godaan", "Munshi Premchand", "Indian Literature");
        addBook("Gunahon Ka Devta", "Dharamvir Bharati", "Indian Literature");
        addBook("Malgudi Days", "R.K. Narayan", "Indian Literature");
        addBook("The Guide", "R.K. Narayan", "Indian Literature");
        addBook("Train to Pakistan", "Khushwant Singh", "Indian Literature");
        addBook("The God of Small Things", "Arundhati Roy", "Indian Literature");
        addBook("A Suitable Boy", "Vikram Seth", "Indian Literature");
        addBook("The White Tiger", "Aravind Adiga", "Indian Literature");
        addBook("Midnight's Children", "Salman Rushdie", "Indian Literature");
        addBook("The Discovery of India", "Jawaharlal Nehru", "History");

        // ---------- Classics ----------
        addBook("Pride and Prejudice", "Jane Austen", "Classic");
        addBook("Jane Eyre", "Charlotte Bronte", "Classic");
        addBook("Wuthering Heights", "Emily Bronte", "Classic");
        addBook("Great Expectations", "Charles Dickens", "Classic");
        addBook("A Tale of Two Cities", "Charles Dickens", "Classic");
        addBook("Oliver Twist", "Charles Dickens", "Classic");
        addBook("Moby-Dick", "Herman Melville", "Classic");
        addBook("The Great Gatsby", "F. Scott Fitzgerald", "Classic");
        addBook("To Kill a Mockingbird", "Harper Lee", "Classic");
        addBook("Crime and Punishment", "Fyodor Dostoevsky", "Classic");
        addBook("The Brothers Karamazov", "Fyodor Dostoevsky", "Classic");
        addBook("War and Peace", "Leo Tolstoy", "Classic");
        addBook("Anna Karenina", "Leo Tolstoy", "Classic");
        addBook("Les Miserables", "Victor Hugo", "Classic");
        addBook("The Count of Monte Cristo", "Alexandre Dumas", "Classic");
        addBook("Don Quixote", "Miguel de Cervantes", "Classic");
        addBook("The Odyssey", "Homer", "Epic");
        addBook("The Iliad", "Homer", "Epic");

        // ---------- Fiction ----------
        addBook("The Kite Runner", "Khaled Hosseini", "Fiction");
        addBook("A Thousand Splendid Suns", "Khaled Hosseini", "Fiction");
        addBook("Life of Pi", "Yann Martel", "Fiction");
        addBook("The Book Thief", "Markus Zusak", "Fiction");
        addBook("The Catcher in the Rye", "J.D. Salinger", "Fiction");
        addBook("One Hundred Years of Solitude", "Gabriel Garcia Marquez", "Fiction");
        addBook("The Old Man and the Sea", "Ernest Hemingway", "Fiction");
        addBook("Of Mice and Men", "John Steinbeck", "Fiction");
        addBook("The Fault in Our Stars", "John Green", "Fiction");
        addBook("The Notebook", "Nicholas Sparks", "Romance");

        // ---------- Science Fiction ----------
        addBook("Dune", "Frank Herbert", "Science Fiction");
        addBook("Foundation", "Isaac Asimov", "Science Fiction");
        addBook("I, Robot", "Isaac Asimov", "Science Fiction");
        addBook("Neuromancer", "William Gibson", "Science Fiction");
        addBook("Ender's Game", "Orson Scott Card", "Science Fiction");
        addBook("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "Science Fiction");
        addBook("1984", "George Orwell", "Science Fiction");
        addBook("Animal Farm", "George Orwell", "Fiction");
        addBook("Brave New World", "Aldous Huxley", "Science Fiction");
        addBook("Fahrenheit 451", "Ray Bradbury", "Science Fiction");
        addBook("The Time Machine", "H.G. Wells", "Science Fiction");
        addBook("The War of the Worlds", "H.G. Wells", "Science Fiction");
        addBook("Twenty Thousand Leagues Under the Seas", "Jules Verne", "Science Fiction");
        addBook("The Martian", "Andy Weir", "Science Fiction");

        // ---------- Fantasy ----------
        addBook("The Hobbit", "J.R.R. Tolkien", "Fantasy");
        addBook("The Fellowship of the Ring", "J.R.R. Tolkien", "Fantasy");
        addBook("The Two Towers", "J.R.R. Tolkien", "Fantasy");
        addBook("The Return of the King", "J.R.R. Tolkien", "Fantasy");
        addBook("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "Fantasy");
        addBook("Harry Potter and the Chamber of Secrets", "J.K. Rowling", "Fantasy");
        addBook("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", "Fantasy");
        addBook("The Lion, the Witch and the Wardrobe", "C.S. Lewis", "Fantasy");
        addBook("A Game of Thrones", "George R.R. Martin", "Fantasy");
        addBook("The Name of the Wind", "Patrick Rothfuss", "Fantasy");
        addBook("Percy Jackson: The Lightning Thief", "Rick Riordan", "Fantasy");
        addBook("The Immortals of Meluha", "Amish Tripathi", "Fantasy");

        // ---------- Mystery / Thriller ----------
        addBook("The Adventures of Sherlock Holmes", "Arthur Conan Doyle", "Mystery");
        addBook("The Hound of the Baskervilles", "Arthur Conan Doyle", "Mystery");
        addBook("And Then There Were None", "Agatha Christie", "Mystery");
        addBook("Murder on the Orient Express", "Agatha Christie", "Mystery");
        addBook("The Girl with the Dragon Tattoo", "Stieg Larsson", "Thriller");
        addBook("Gone Girl", "Gillian Flynn", "Thriller");
        addBook("The Da Vinci Code", "Dan Brown", "Thriller");
        addBook("Angels & Demons", "Dan Brown", "Thriller");
        addBook("The Silence of the Lambs", "Thomas Harris", "Thriller");
        addBook("Rebecca", "Daphne du Maurier", "Mystery");

        // ---------- Horror ----------
        addBook("Dracula", "Bram Stoker", "Horror");
        addBook("Frankenstein", "Mary Shelley", "Horror");
        addBook("The Shining", "Stephen King", "Horror");
        addBook("It", "Stephen King", "Horror");
        addBook("The Strange Case of Dr Jekyll and Mr Hyde", "Robert Louis Stevenson", "Horror");

        // ---------- History / Biography ----------
        addBook("Sapiens: A Brief History of Humankind", "Yuval Noah Harari", "History");
        addBook("Homo Deus", "Yuval Noah Harari", "History");
        addBook("Guns, Germs, and Steel", "Jared Diamond", "History");
        addBook("The Diary of a Young Girl", "Anne Frank", "Biography");
        addBook("My Experiments with Truth", "Mahatma Gandhi", "Biography");
        addBook("Long Walk to Freedom", "Nelson Mandela", "Biography");
        addBook("Steve Jobs", "Walter Isaacson", "Biography");
        addBook("Becoming", "Michelle Obama", "Biography");
        addBook("India After Gandhi", "Ramachandra Guha", "History");
        addBook("The Story of My Life", "Helen Keller", "Biography");

        // ---------- Science ----------
        addBook("A Brief History of Time", "Stephen Hawking", "Science");
        addBook("Cosmos", "Carl Sagan", "Science");
        addBook("The Selfish Gene", "Richard Dawkins", "Science");
        addBook("On the Origin of Species", "Charles Darwin", "Science");
        addBook("Astrophysics for People in a Hurry", "Neil deGrasse Tyson", "Science");
        addBook("The Elegant Universe", "Brian Greene", "Science");
        addBook("Surely You're Joking, Mr. Feynman!", "Richard P. Feynman", "Science");
        addBook("The Gene: An Intimate History", "Siddhartha Mukherjee", "Science");

        // ---------- Technology / Programming ----------
        addBook("Clean Code", "Robert C. Martin", "Technology");
        addBook("The Pragmatic Programmer", "Andrew Hunt and David Thomas", "Technology");
        addBook("Head First Java", "Kathy Sierra and Bert Bates", "Technology");
        addBook("Effective Java", "Joshua Bloch", "Technology");
        addBook("Core Java Volume I", "Cay S. Horstmann", "Technology");
        addBook("Introduction to Algorithms", "Thomas H. Cormen", "Technology");
        addBook("Design Patterns", "Erich Gamma et al.", "Technology");
        addBook("Python Crash Course", "Eric Matthes", "Technology");
        addBook("You Don't Know JS", "Kyle Simpson", "Technology");
        addBook("Database System Concepts", "Abraham Silberschatz", "Technology");
        addBook("Operating System Concepts", "Abraham Silberschatz", "Technology");
        addBook("Computer Networking: A Top-Down Approach", "James Kurose and Keith Ross", "Technology");
        addBook("Artificial Intelligence: A Modern Approach", "Stuart Russell and Peter Norvig", "Technology");
        addBook("The Mythical Man-Month", "Frederick P. Brooks Jr.", "Technology");

        // ---------- Self-Help / Business ----------
        addBook("Atomic Habits", "James Clear", "Self-Help");
        addBook("The 7 Habits of Highly Effective People", "Stephen R. Covey", "Self-Help");
        addBook("How to Win Friends and Influence People", "Dale Carnegie", "Self-Help");
        addBook("Think and Grow Rich", "Napoleon Hill", "Self-Help");
        addBook("Rich Dad Poor Dad", "Robert T. Kiyosaki", "Business");
        addBook("The Psychology of Money", "Morgan Housel", "Business");
        addBook("Thinking, Fast and Slow", "Daniel Kahneman", "Psychology");
        addBook("Deep Work", "Cal Newport", "Self-Help");
        addBook("Zero to One", "Peter Thiel", "Business");
        addBook("The Lean Startup", "Eric Ries", "Business");
        addBook("Ikigai", "Hector Garcia and Francesc Miralles", "Self-Help");
        addBook("The Subtle Art of Not Giving a F*ck", "Mark Manson", "Self-Help");

        // ---------- Philosophy ----------
        addBook("Meditations", "Marcus Aurelius", "Philosophy");
        addBook("The Republic", "Plato", "Philosophy");
        addBook("Nicomachean Ethics", "Aristotle", "Philosophy");
        addBook("Thus Spoke Zarathustra", "Friedrich Nietzsche", "Philosophy");
        addBook("The Art of War", "Sun Tzu", "Philosophy");
        addBook("The Prince", "Niccolo Machiavelli", "Philosophy");
        addBook("Beyond Good and Evil", "Friedrich Nietzsche", "Philosophy");

        // ---------- Poetry ----------
        addBook("Leaves of Grass", "Walt Whitman", "Poetry");
        addBook("The Waste Land", "T.S. Eliot", "Poetry");
        addBook("Madhushala", "Harivansh Rai Bachchan", "Poetry");
        addBook("Milk and Honey", "Rupi Kaur", "Poetry");

        // ---------- Children ----------
        addBook("Alice's Adventures in Wonderland", "Lewis Carroll", "Children");
        addBook("The Jungle Book", "Rudyard Kipling", "Children");
        addBook("Charlotte's Web", "E.B. White", "Children");
        addBook("The Little Prince", "Antoine de Saint-Exupery", "Children");
        addBook("Matilda", "Roald Dahl", "Children");
        addBook("Charlie and the Chocolate Factory", "Roald Dahl", "Children");
        addBook("Panchatantra Tales", "Vishnu Sharma", "Children");
        addBook("The Adventures of Tom Sawyer", "Mark Twain", "Children");
    }

    public static LibraryData getInstance() {
        if (instance == null) instance = new LibraryData();
        return instance;
    }

    // ---------- Member management ----------

    // True if a member with this username already exists (case-insensitive)
    public boolean usernameExists(String username) {
        for (Member m : members) {
            if (m.getUsername().equalsIgnoreCase(username)) return true;
        }
        return false;
    }

    // Next free member ID (highest existing ID + 1, starting from 101)
    public int getNextMemberId() {
        return nextMemberId++;
    }

    // Adds a new member. Returns the new Member, or null if the username is taken.
    public Member addMember(String username, String password, String displayName) {
        if (usernameExists(username)) return null;
        Member m = new Member(username, password, displayName, getNextMemberId());
        members.add(m);
        return m;
    }

    // Authenticate librarian
    public boolean authenticateLibrarian(String username, String password) {
        return librarianUsername.equals(username) && librarianPassword.equals(password);
    }

    // Authenticate member — returns Member object if ok, else null
    public Member authenticateMember(String username, String password) {
        for (Member m : members) {
            if (m.getUsername().equals(username) && m.getPassword().equals(password)) {
                return m;
            }
        }
        return null;
    }
}