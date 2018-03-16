package de.hdm.ITProjekt.WorkTime.server.old;

import java.util.Vector;

import de.hdm.ITProjekt.WorkTime.server.datenbank.NotizMapper;
import de.hdm.ITProjekt.WorkTime.shared.Notiz;

public class StatistikImplementation {//muss jetzt Mapper implementiert werden in async interface


	public Vector<Notiz> findAll(){

	        return NotizMapper.findAll();//will R�ckgabewert
	    }

        public Notiz findById(int id) {

            return NotizMapper.findById(id);
        }
        
        public void Notizloeschen(Notiz notiz) {

        	NotizMapper.Notizloeschen(notiz); //Void deshalb kein R�ckgabewert
        	    
        }
    	public void Notizanlegen(Notiz notiz){

	        NotizMapper.Notizanlegen(notiz);//Void deshalb kein r�ckgabewert
	    }
    
}
