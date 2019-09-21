package StAXTest.dao;

import StAXTest.model.Bank;
import org.springframework.data.repository.CrudRepository;

public interface BankRepo extends CrudRepository<Bank, Integer> {
}
