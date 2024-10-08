package org.example.repository;

import org.example.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    //Data Persistence: CrudRepository (Basic), JpaRepository (Advanced, extends from CrudRepository)
    //save()
    //findOne()
    //findById()
    //findByEmail()
    //findAll()
    //count()
    //delete()
    //deleteById()
}
