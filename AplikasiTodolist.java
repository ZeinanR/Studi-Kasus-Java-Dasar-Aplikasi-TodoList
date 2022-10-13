
public class AplikasiTodolist {
    public static String[]model = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) throws Exception {
        TestViewShowTodoList();
    }
    /**
     * Menampilkan todo list
     */
    public static void ShowTodoList(){
        for (var i = 0; i < model.length; i++){
            var todo = model[i];
            var no = i + 1;
    
            if (todo!=null){
                System.out.println(no+"."+todo);
            }
        }
        
    }
    public static void TestShowTodoList(){
        ShowTodoList();
    }
    /**
     * Menambah todo ke list
     */
    public static void AddTodoList(String todo){
        //cek apakah model penuh?
        var isFull = true;
        for (int i = 0; i<model.length;i++){
            if (model[i]==null){
                //model masih ada yang kosong
                isFull = false;
                break;
            }
        }
        //Jika penuh, kita resize ukuran array 2x lipat
        if (isFull){
            var temp=model;
            model= new String[model.length*2];

            for (int i=0;i<temp.length;i++){
                model[i]=temp[i];
            }
        }
        //Tambahkan ke posisi yang data array nya NULL
        for (var i=0;i<model.length;i++){
            if (model[i]==null) {
                model[i] = todo;
                break;
            }
        }
    }
    public static void TestAddTodoList(){
        for (int i=0;i<25;i++){
            AddTodoList("Contoh Todo Ke."+i);
        }
    }
    /**
     * Menghapus todo dari list
     */
    public static boolean RemoveTodoList(Integer number){
        if ((number - 1) >= model.length){
            return false;
        }
        else if(model[number - 1] == null){
            return false;
        }
        else {
            for (int i = (number - 1); i < model.length ; i++) {
                if (i == (model.length-1)){
                    model[i]=null;
                }else {
                    model[i]=model[i+1];
                }
            }
            return true;
        }
    }
    public static void TestRemoveTodoList(){
        AddTodoList("satu");
        AddTodoList("dua");
        AddTodoList("tiga");
        AddTodoList("empat");
        AddTodoList("lima");
        AddTodoList("enam");

        var result = RemoveTodoList(20);
        System.out.println(result);

        result = RemoveTodoList(7);
        System.out.println(result);

        result = RemoveTodoList(2);
        System.out.println(result);

        ShowTodoList();
    }
    public static String input(String info){
        System.out.println(info + ":");
        String data = scanner.nextLine();
        return data;
    }

    public static void TestInput(){
        var name = input("nama");
        System.out.println("hi"+name);

        var channel = input("channel");
        System.out.println(channel);
    }
    /**
     * Menampilkan menu todo list
     */
    public static void ViewShowTodoList(){
        while (true){
            ShowTodoList();

            System.out.println("Menu : ");
            System.out.println("1. tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input =input("pilih");
            if (input.equals("1")){
                ViewAddTodoList();
            }else if (input.equals("2")){
                ViewRemoveTodoList();
            }else if (input.equals("x")){
                break;
            }else {
                System.out.println("Pilihan Tidak dimengerti");
            }
        }
    }

    public static void TestViewShowTodoList(){
        ViewShowTodoList();
    }
    /**
     * Menampilkan view menambahkan todo ke list
     */
    public static void ViewAddTodoList(){
        System.out.println("Menambah TodoList");
        var todo = input("todo(x jika batal)");
        if (todo.equals("x"));
        //Batal
        else {
            AddTodoList(todo);
        }
    }

    public static void TestViewAddTodoList(){
        AddTodoList("satu");
        AddTodoList("dua");
        ViewAddTodoList();
        ShowTodoList();
    }
    /**
     * Menampilkan view menghapus todo dari list
     */
    public static void ViewRemoveTodoList(){
        System.out.println("Menghapus todoList");

        var number = input("Nomor Yang Dihapus(x jika batal)");
        if (number.equals("x")){
            //batal
        } else {
            boolean success = RemoveTodoList(Integer.valueOf(number));
            if (!success){
                System.out.println("Gagal menghapus TodoList" + number);
            }
        }
    }

    public static void TestViewRemoveTodoList(){
        AddTodoList("Satu");
        AddTodoList("Dua");
        AddTodoList("Tiga");

        ShowTodoList();

        ViewRemoveTodoList();

        ShowTodoList();
    }
}
