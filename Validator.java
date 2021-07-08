public class Validator{

    private String string;
    private boolean check;

    public Validator(String string) {

        this.string = string;
        check = false;

    }

    public boolean checkString() {

        ArrayStack<Character> stack = new ArrayStack<Character>(10);

        for (int i = 0; i < string.length(); i++) {

            if ((string.charAt(i) == '(') || (string.charAt(i) == '{') || (string.charAt(i) == '[')) {

                stack.push(string.charAt(i));

            }
            else if ((string.charAt(i) == ')') || (string.charAt(i) == '}') || (string.charAt(i) == ']')) {

                char checkChar = stack.pop();
                
                if ((checkChar == '(' && string.charAt(i) == ')') || (checkChar == '[' && string.charAt(i) == ']') || (checkChar == '{' && string.charAt(i) == '}')) {

                    check = true;

                }
                else { 

                    check = false;
                    break;

                }

            }

        }

        return check;

    }

}