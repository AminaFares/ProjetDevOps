package tn.esprit.rh.achat;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.DetailFournisseurRepository;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.IFournisseurService;

public class FournisseurTest {

	
	@Autowired
	IFournisseurService frournisseurServic;
	@Autowired
	FournisseurRepository fournisseurRepository;
	@Autowired
	DetailFournisseurRepository detailfournisseurrepository;
	@Autowired
	ProduitRepository produitrepository;
	@Autowired
	SecteurActiviteRepository secteuractiviterepository;
	
	int fournisseurId;
	Fournisseur fournisseur;
	
	
	//public void addFournisseur() {
		//assertTrue("ajout fournisseur echouer",fournisseurRepository.findAll());} 


	
}
