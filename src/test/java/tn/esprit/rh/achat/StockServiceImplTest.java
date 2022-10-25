package tn.esprit.rh.achat;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.IStockService;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
//@RunWith( SpringJUnit4ClassRunner.class )
public class StockServiceImplTest {

	@Autowired
	IStockService stockservice;
	@Autowired
	Stock s = new Stock();
	@Autowired
	StockRepository stockrepository; 

	@Test
	void contextLoads() {
	}
	
	@Test
	public List<Stock> retrieveAllStocks() {
		return (List<Stock>) stockrepository.findAll();
	}
	
	@Test
	public void addStock() {
		s.setLibelleStock("Ajout de stock");
		s.setQte(20);
		assertNotNull(s.getLibelleStock());
	}
	
	/*@Test
	public Stock addStock(Stock s) {
		return stockrepository.save(s);
	}*/
	
    @Test
	public String retrieveStatusStock() {
		System.out.println("Got into Method!");
		List<Stock> stocks = (List<Stock>) stockrepository.findAll();
		String incrementedOutput = "";
		for (Stock stock : stocks) {
			if(stock.getQte() < stock.getQteMin()) {
				incrementedOutput = incrementedOutput + "Stock "+stock.getLibelleStock()+" est infÃ©reur de "+(stock.getQteMin()-stock.getQte())+" de la quantitÃ© Minimale! \n";
			}
		}
		return incrementedOutput;
	}
	
	@Test
	public Stock retrieveStock(Long id) {
		return stockrepository.findById(id).get();
	}
	
	@Test 
	public Stock updateStock(Stock u) {
		Stock s = stockrepository.findById(u.getIdStock()).get();
		s.setLibelleStock(u.getLibelleStock());
		s.setQteMin(u.getQteMin());
		s.setQte(u.getQte());
		return stockrepository.save(s);
	}
	
	@Test
	void deleteStock(Long id)
	{
		stockrepository.deleteById(id);
		System.out.println(" STOCK DELETED");
	}
	
	
}
