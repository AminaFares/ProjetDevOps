package tn.esprit.rh.achat;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.services.IStockService;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class StockServiceImplTest {

	@Autowired
	IStockService stockservice;
	@Autowired
	
	Stock s = new Stock();
	
	@Test
	public void TestAjoutStock() {
		s.setLibelleStock("tester ajout de stock");
		s.setQte(20);
		assertNotNull(s.getLibelleStock());
		 }
	
}
