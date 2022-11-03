package tn.esprit.rh.achat;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.IStockService;
import tn.esprit.rh.achat.services.StockServiceImpl;

//@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
@RunWith( SpringJUnit4ClassRunner.class )
@ExtendWith(MockitoExtension.class)
public class StockServiceImplTest {

	@Autowired
	IStockService istockservice;
	//@Autowired
	@Mock
	StockRepository stockrepository; 
	@InjectMocks
	StockServiceImpl stockservice;

	
	
	
	Stock s = new Stock("Tester stock",20,100);
	List<Stock> listStocks = new ArrayList<Stock>(){
	{
		add(new Stock ("Tester stock 1",40,50));
		add(new Stock ("Tester stock 1",40,50));
	}
	};
	
	/*@Test
	public void addStock() {
		s.setLibelleStock("Ajout de stock");
		s.setQte(20);
		assertNotNull(s.getLibelleStock());
	}*/
	
	@Test
	public void MockAddStock()
	{
		Mockito.when(stockrepository.findById(Mockito.anyLong())).thenReturn(Optional.of(s));
		Stock stock = stockservice.retrieveStock((long)4);
		assertNotNull(stock);
		log.info("affiche stock", stock.toString());
		
		
	}
	
	@Test
	public void TestRetriveAllStocks() {
		Mockito.when(stockrepository.findAll()).thenReturn(listStocks);
		assertEquals(listStocks.size(), stockservice.retrieveAllStocks().size());
	}
	
	
	@Test
	public void testAddStock() {
		
		List<Stock> stocks = stockservice.retrieveAllStocks();
		int expected = stocks.size();
		Stock s = new Stock();
		s.setLibelleStock("Tester stock");
		s.setQte(20);
		s.setQteMin(100);
		Stock savedStock = stockservice.addStock(s);
		assertEquals(expected+1, stockservice.retrieveAllStocks().size());
		assertNotNull(savedStock.getLibelleStock());
		stockservice.deleteStock(savedStock.getIdStock());
		
	}
	

	
	public List<Stock> retrieveAllStocks() {
		return (List<Stock>) stockrepository.findAll();
	}
	
	
	
	@Test
	public Stock addStock(Stock s) {
		return stockrepository.save(s);
	}
	
	
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
