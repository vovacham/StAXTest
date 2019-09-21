package StAXTest.dao;

import StAXTest.model.Nomenclature;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NomenclatureRepo extends JpaRepository<Nomenclature, Long> {

}
