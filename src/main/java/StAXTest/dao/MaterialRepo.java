package StAXTest.dao;

import StAXTest.model.Material;
import org.springframework.data.repository.CrudRepository;

public interface MaterialRepo extends CrudRepository<Material, Integer> {
}
