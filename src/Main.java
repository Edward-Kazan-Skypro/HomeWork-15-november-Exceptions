public class Main {
    public static void main(String[] args) {

        //Создадим объект Data
        String login_1 = "user_123";
        String password_1 = "Qw23_44565646hhih";
        String confirmPass_1 = password_1;
        Data data_1 = new Data(login_1, password_1, confirmPass_1);
        System.out.println(data_1);
        System.out.println("Значения логин/пароль введены правильно? ответ - " + data_1.checkLoginAndPassword());

        System.out.println("---------------------------------------------------------------");
        //Создадим еще один объект Data
        String login_2 = "user_666";
        String password_2 = "Яблоко";
        String confirmPass_2 = password_2;
        Data data_2 = new Data(login_2, password_2, confirmPass_2);
        System.out.println(data_2);
        System.out.println("Значения логин/пароль введены правильно? ответ - " + data_2.checkLoginAndPassword());
        System.out.println("---------------------------------------------------------------");
        //Создадим еще один объект Data
        String login_3 = "user_666";
        String password_3 = "00000000000000000000";
        String confirmPass_3 = password_3;
        Data data_3 = new Data(login_3, password_3, confirmPass_3);
        System.out.println(data_3);
        System.out.println("Значения логин/пароль введены правильно? ответ - " + data_3.checkLoginAndPassword());
        System.out.println("---------------------------------------------------------------");


    }
}