package healthcarev3.service;

import healthcarev3.model.Office;
import healthcarev3.repository.OfficeRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
public class OfficeService {
    private OfficeRepository officeRepository;

    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public void createOffice(Office office) {
        officeRepository.createOffice(office);
    }

    public Office getOffice(int id) {
        return officeRepository.getOfficeById(id);
    }

    public void updateOffice(Office office) {
        officeRepository.updateOffice(office);
    }

    public void deleteOffice(int id) {
        officeRepository.deleteOffice(id);
    }

    public List<Office> getAllOffices() {
        return officeRepository.getAllOffices();
    }

}
