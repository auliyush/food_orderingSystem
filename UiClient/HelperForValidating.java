import java.util.regex.Pattern;
public class HelperForValidating {
    private static HelperForValidating instance;

    public static synchronized HelperForValidating getInstance(){
        if (instance == null){
            instance = new HelperForValidating();
        }
        return instance;
    }
    public String trimmedMethod(String str){
        return str.trim();
    }
    
//    VALIDATE USER'S USERNAME
    public String validateUserName(String username) {
        int specialCharacterCount = 0;
        int characterCount =  0;
        for(char ch : username.toCharArray()){
            if(ch >= 32 && ch <= 47 || ch >= 58 && ch <= 64 || ch >= 91 && ch <= 96 || ch >= 123 && ch <= 126){
                specialCharacterCount++;
            }
            characterCount++;
        }
        if(specialCharacterCount == 0){
            return "please enter atleast one special character %$#@";
        }
        if(characterCount < 5){
            return "Username should be must five character";
        }
        return "valid";
    }

    public String validateUserEmail(String userEmail) {
        if(userEmail == null || userEmail.isEmpty()){
            return "Please Enter E-mail";
        }
        String userEmailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+.)+[a-zA-Z]{2,7}";
        Pattern pattern = Pattern.compile(userEmailRegex);
        if(pattern.matcher(userEmail).matches()){
            return "valid";
        }else{
            return "Email is not valid ";
        }
    }

    public String validateUserPassword(String userPassword) {
        if (userPassword == null || userPassword.isEmpty()){
            return "please Enter password";
        }
        int specialCharacterCount = 0;
        int characterCount =  0;
        for(char ch : userPassword.toCharArray()){
            if(ch >= 32 && ch <= 64 || ch >= 91 && ch <= 96 || ch >= 123 && ch <= 126){
                specialCharacterCount++;
            }
            characterCount++;
        }
        if(specialCharacterCount == 0){
            return "please enter atleast one special character or integer %$#@ for strong password";
        }
        if(characterCount < 3){
            return "Password must be 4 character";
        }
        return "valid";
    }

    public boolean validateUserPhoneNUmber(String userPhoneNumber) {
        int lengthOfUserPhoneNumber = userPhoneNumber.length();
        boolean checkValue;
        try {
            Double.parseDouble(userPhoneNumber);
            checkValue = true;
        } catch (NumberFormatException e) {
            checkValue = false;
        }
        if (checkValue == false) {
            return false;
        } else if (lengthOfUserPhoneNumber < 10 || lengthOfUserPhoneNumber > 10) {
            return false;
        } else {
            return true;
        }

    }
}
//32–47, 58–64, 91–96, and 123–126