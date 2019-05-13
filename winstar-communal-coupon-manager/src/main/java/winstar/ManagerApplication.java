package winstar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

/**
 * Created by zl on 2019/5/13
 */
@SpringBootApplication
public class ManagerApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ManagerApplication.class);
        application.addListeners(new ApplicationPidFileWriter("winstar-communal-coupon-manager.pid"));
        application.run(args);
    }

}
