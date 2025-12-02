package strc.data;

import strc.data.enums.FuelType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import strc.data.service.TestClass;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        //TestClass.function("Audi", "A6", FuelType.DIESEL.getType());
    }
}
