package strc.data.service;

import org.springframework.stereotype.Component;

@Component
public class TestClass {

    /*            Overloading                  */
    public int method(){
        return 0;
    }

    public int method(int x){
        return 0;
    }
    /*            Overloading                  */

    /*            Args                  */
    public static int function(String... args){
        for (String l : args){
            System.out.println("Argument " + l);
        }
        return 0;
    }


}
