package healthcarev3.impl;

import healthcarev3.model.Office;
import healthcarev3.repository.OfficeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class OfficeRepositoryImpl implements OfficeRepository {
    private SessionFactory sessionFactory;

    public void createOffice(Office office){
        try (Session session = sessionFactory.openSession()) {
           Transaction tx = session.beginTransaction();
            session.persist(office);
            tx.commit();
        }
    }

    @Override
    public Office getOfficeById(int officeId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Office.class, officeId);
        }
    }

    @Override
    public void updateOffice(Office office) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(office);
            tx.commit();
        }
    }

    @Override
    public void deleteOffice(int officeId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Office office = session.get(Office.class, officeId);
            session.remove(office);
            tx.commit();
        }
    }

    @Override
    public List<Office> getAllOffices() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Office", Office.class).list();
        }
    }
}
