package priv.calloriescounter.indirect.utis;

import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class DatabaseSession {
    @Getter
    private static final Session session = new Configuration().configure().buildSessionFactory().openSession();
    private DatabaseSession(){};
}
