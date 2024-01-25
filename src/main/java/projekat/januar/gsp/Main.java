package projekat.januar.gsp;

import com.mysql.cj.Session;
import org.hibernate.query.NativeQuery;
import projekat.januar.gsp.run.Test01;
import projekat.januar.gsp.run.abstraction.Test;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Test test = new Test01();
        test.test();

    }

}
