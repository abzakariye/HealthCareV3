package healthcarev3.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name="Offices")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int officeId;
    @Column(name="location")
    private String location;
    @Column(name="phone")
    private String phone;

    @OneToOne()
        @JoinColumn(name="DoctorID")
    Doctor doctor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Office office = (Office) o;
        return officeId == office.officeId;
    }


    @Override
    public int hashCode() {
        return Objects.hash(officeId);
    }

}
