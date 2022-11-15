import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Data {

    String defaultMessage = "может содержать в себе только латинские буквы," +
            " цифры и знак подчеркивания, длина - не более 20 символов.";
    private String login = defaultMessage;
    private String password = defaultMessage;
    private String confirmPassword = "Введенные пароли не совпадают";


    public Data(String login, String password, String confirmPassword) {

        //Можно было бы сделать код короче,
        //но тогда теряем информативность - не понятно что введено неправильно - логин или пароль, или оба вместе
        //if (checkLoginAndPassword()) {
        //    this.login = login;
        //    this.password = password;
        //    this.confirmPassword = confirmPassword;
        //}
        try {
            if (checkInputString(login)) {
                this.login = login;
            } else {
                throw new WrongLoginException("Ошибка! Логин введен не правильно!\nОн " + defaultMessage);
            }
        } catch (Exception message) {
            System.out.println(message.getMessage());
        }
        try {
            if (checkInputString(password)) {
                this.password = password;
            } else {
                throw new WrongPasswordException("Ошибка! Пароль введен не правильно!\nОн " + defaultMessage);
            }
        } catch (Exception message) {
            System.out.println(message.getMessage());
        }

        if (checkInputString(password) && password.equals(confirmPassword)) this.confirmPassword = confirmPassword;
    }

    public boolean checkLoginAndPassword (){
        return checkInputString(login) && checkInputString(password) && checkInputString(password) && password.equals(confirmPassword);
    }

    private static boolean checkInputString(String inputString) {
        Pattern p = Pattern.compile("(^[^а-яА-Я]\\w{1,19}+$)", Pattern.CASE_INSENSITIVE);
        if (inputString != null) {
            if (!inputString.isEmpty() && !inputString.isBlank()){
                Matcher m = p.matcher(inputString);
                return m.find();
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String result;
        if (confirmPassword.equals(password)) {
            result = "Логин: " + login + ",\n" +
                    "пароль: " + password;
        } else {
            result = confirmPassword + ". Пожалуйста, введите логин и пароль заново.";
        }
        return result;
    }

    public static class WrongLoginException extends Exception {
        public WrongLoginException() {
        }

        public WrongLoginException(String message) {
            super(message);
        }
    }

    public static class WrongPasswordException extends Exception {
        public WrongPasswordException() {
        }

        public WrongPasswordException(String message) {
            super(message);
        }
    }
}
