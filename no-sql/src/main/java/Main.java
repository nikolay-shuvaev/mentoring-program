import services.NoteService;

public class Main {
    public static void main(String[] args) {
        NoteService service = new NoteService();

//        Note note = new Note(LocalDate.now(), "Hello tag", " This is first Hello message");
//
//        service.save(note);

        service.findAll().forEach(System.out::println);

        System.out.println("By tag");
        service.findByTag("Hello tag").forEach(System.out::println);

        System.out.println("By text search");
        service.findByTextSearch("tag2 first").forEach(System.out::println);
    }

}