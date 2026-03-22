package Ex05.Business;

import Ex05.DAO.DoctorDAO;
import Ex05.model.Doctor;

import java.util.List;

public class DoctorService {
    private DoctorDAO dao = new DoctorDAO();

    public void showAll() {
        List<Doctor> list = dao.getAllDoctors();
        for (Doctor d : list) {
            System.out.println(d.getId() + " | " + d.getName() + " | " + d.getSpecialty());
        }
    }

    public void add(String name, String specialty) {
        dao.addDoctor(new Doctor(name, specialty));
    }

    public void stats() {
        dao.countBySpecialty();
    }
}